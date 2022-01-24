package ru.sahlob.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sahlob.db.DBOrdersStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.interfaces.DBToursRepository;
import ru.sahlob.db.interfaces.EmailSecretCodeRepository;
import ru.sahlob.persistance.client.EmailSecretCode;
import ru.sahlob.persistance.client.PersonalAccount;
import ru.sahlob.persistance.order.InputOrder;
import ru.sahlob.persistance.order.NewInputOrder;
import ru.sahlob.persistance.order.utils.InputTourUtils;
import ru.sahlob.persistance.order.utils.OrderUtils;
import ru.sahlob.security.MyUserDetailsService;
import ru.sahlob.security.MyUserPrincipal;
import ru.sahlob.service.ServiceUtil;
import ru.sahlob.service.mail.MailSender;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class OrderController {

    private final DBToursRepository dbToursRepository;
    private final DBOrdersStorage dbOrdersStorage;
    private final DBUsersStorage dbUsersStorage;
    private final EmailSecretCodeRepository emailSecretCodeRepository;
    private final MailSender mailSender;
    private final MyUserDetailsService userService;

    @PostMapping("/newOrder")
    @ResponseBody
    public String newOrder(NewInputOrder newInputOrder) {
        var order = OrderUtils.newInputOrderToOrder(newInputOrder);
        var tour = dbToursRepository.findFirstById(order.getId());
        order.setTourPrice(
                InputTourUtils.getOrderPriceFromWithTypeTour(
                        order.getTourType(),
                        tour));
        order.setTourName(tour.getName());
        var uuid = ServiceUtil.getRandomUuid();
        while (dbOrdersStorage.getOrderByUuid(uuid) != null) {
            uuid = ServiceUtil.getRandomUuid();
        }
        order.setUuid(uuid);
        dbOrdersStorage.saveOrder(order);
        return "/order?orderId=" + order.getUuid();
    }

    @GetMapping(value = "/order")
    public String order(@RequestParam String orderId, Model model) {
        var personalAccount = new PersonalAccount(SecurityContextHolder.getContext().getAuthentication(), dbUsersStorage);
        var order = dbOrdersStorage.getOrderByUuid(orderId);
        String email = null;
        String phone = null;
        String name = null;
        String communicationMethod = null;
        String instagram = null;
        if (personalAccount.getName() != null) {
            var user = dbUsersStorage.getClientByPhoneOrEmail(personalAccount.getName());
            email = user.getEmail();
            phone = user.getPhone();
            name = user.getFirstName();
            communicationMethod = user.getCommunicationMethod();
            instagram = user.getInstagramAccount();
        }
        model.addAttribute("personalAccount", personalAccount);
        model.addAttribute("id", order.getId());
        model.addAttribute("date", order.getTourDate());
        model.addAttribute("type", order.getTourType());
        model.addAttribute("price", order.getTourPrice());
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("name", name);
        model.addAttribute("orderName", order.getTourName());
        model.addAttribute("communicationMethod", communicationMethod);
        model.addAttribute("instagram", instagram);
        return "newOrder";
    }

    @PostMapping(value = "/confirmNewOrder")
    @ResponseBody
    public String confirmNewOrder(InputOrder inputOrder) {
        var order = dbOrdersStorage.getOrderById(inputOrder.getOrderID());
        var client = dbUsersStorage.getClientByPhoneOrEmail(
                inputOrder.getClientPhone(),
                inputOrder.getClientEmail());
        if (client == null) {
            client = dbUsersStorage
                    .addNewUserFromInputOrder(inputOrder);
        }
        client.setCommunicationMethod(inputOrder.getCommunicationMethodAdditionalValue());
        client.setInstagramAccount(inputOrder.getInstagram());
        order.setPerformCommunicationMethod(inputOrder.getCommunicationMethodAdditionalValue());
        order.setComment(inputOrder.getComment());
        if (client.getUuid() == null) {
            client.setUuid(ServiceUtil.getRandomUuid());
        }
        order.setClientUuid(client.getUuid());
        order.setUuid2(ServiceUtil.getRandomUuid());
        order.setUuid(null);
        client.addNewOrder(order);
        dbUsersStorage.saveUser(client);
        dbOrdersStorage.saveOrder(order);
        return "/showOrder?orderId=" + order.getUuid2();
    }

    @GetMapping(value = "/showOrder")
    public String showOrder(@RequestParam String orderId, Model model) {
        var personalAccount = new PersonalAccount(SecurityContextHolder.getContext().getAuthentication(), dbUsersStorage);
        var order = dbOrdersStorage.getOrderByUuid2(orderId);
        var client = dbUsersStorage.getClientByUuid(order.getClientUuid());
        var tour = dbToursRepository.findFirstById(order.getTourId());
        String messageToUser;
        if (personalAccount.getName() == null) {
            var emailSecretCode = new EmailSecretCode(client.getId(), ServiceUtil.getRandomUuid());
            var url = "http://localhost:8080/confirmCode/" + emailSecretCode.getUuid();
            var subject = "Подтверждение email";
            var message = "Для подтверждения email перейдите по ссылке: " + url;
            emailSecretCodeRepository.save(new EmailSecretCode(client.getId(), ServiceUtil.getRandomUuid()));
            mailSender.send(client.getEmail(), subject, message);
            messageToUser = client.getEmail() + " - на данный email отправлено письмо с подтверждением";
        } else {
            messageToUser = "Заказ можно посмотреть в личном кабинете";
        }
        model.addAttribute("personalAccount", personalAccount);
        model.addAttribute("name", client.getFirstName());
        model.addAttribute("imgId", tour.getImagesId().get(0));
        model.addAttribute("tourDate", order.getTourDate());
        model.addAttribute("orderNum", order.getId());
        model.addAttribute("tourName", tour.getName());
        model.addAttribute("orderType", order.getTourType());
        model.addAttribute("tourPrice", order.getTourPrice());
        model.addAttribute("orderComment", order.getComment());
        model.addAttribute("orderEmail", client.getEmail());
        model.addAttribute("price", order.getTourPrice());
        model.addAttribute("performCommunicationMethod", order.getPerformCommunicationMethod());
        model.addAttribute("message", messageToUser);
        return "/showOrder";
    }


    @GetMapping(value = "confirmCode/{code}")
    public String confirmSecretCode(@PathVariable String code, Model model, HttpServletRequest httpRequest) {
        var personalAccount = new PersonalAccount(SecurityContextHolder.getContext().getAuthentication(), dbUsersStorage);
        var emailCode = emailSecretCodeRepository.findFirstByUuid(code);
        var statusCode = 0;
        if (emailCode != null) {
            var client = dbUsersStorage.getClientById(emailCode.getClientId());
            dbUsersStorage.saveUser(client);
            statusCode = 1;
            var userDetails = userService.loadUserByUsername(client.getEmail());
            var token = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities());
            token.setDetails(new WebAuthenticationDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(token);
            personalAccount = new PersonalAccount(
                    (MyUserPrincipal) SecurityContextHolder
                            .getContext()
                            .getAuthentication()
                            .getPrincipal(), dbUsersStorage);
            var newClientsPassword = ServiceUtil.generatePassword();
            var subject = "Safe and sounds tours. Your new password";
            var message = "Your new password: " + newClientsPassword;
            mailSender.send(client.getEmail(), subject, message);
            client.setPassword(newClientsPassword);
            dbUsersStorage.saveUser(client);
            emailSecretCodeRepository.delete(emailCode);
        }
        model.addAttribute("personalAccount", personalAccount);
        model.addAttribute("status", statusCode);
        return "confirmEmail";
    }
}