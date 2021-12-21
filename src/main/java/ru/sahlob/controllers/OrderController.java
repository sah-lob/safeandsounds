package ru.sahlob.controllers;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import ru.sahlob.persistance.order.Order;
import ru.sahlob.persistance.order.utils.InputTourUtils;
import ru.sahlob.security.MyUserDetailsService;
import ru.sahlob.security.MyUserPrincipal;
import ru.sahlob.service.ServiceUtil;
import ru.sahlob.service.mail.MailSender;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@Data
public class OrderController {

    private final DBToursRepository dbToursRepository;
    private final DBOrdersStorage dbOrdersStorage;
    private final DBUsersStorage dbUsersStorage;
    private final EmailSecretCodeRepository emailSecretCodeRepository;
    private final MailSender mailSender;
    private final MyUserDetailsService userService;

    @PostMapping("/newOrder")
    @ResponseBody
    public String newOrder(Order order) {
        order.setTourPrice(
                InputTourUtils.getOrderPriceFromWithTypeTour(
                        order.getTourType(),
                        dbToursRepository.findById(
                                order.getTourId())
                                .get()));
        var uuid = ServiceUtil.getRandomUuid();
        while (dbOrdersStorage.getOrderByUuid(uuid) != null) {
            uuid = ServiceUtil.getRandomUuid();
        }
        order.setUuid(uuid);
        order.setTourName(dbToursRepository
                .findFirstById(order.getTourId())
                .getName());
        dbOrdersStorage.saveOrder(order);
        return "/order?orderId=" + order.getUuid();
    }

    @GetMapping(value = "/order")
    public String order(@RequestParam String orderId, Model model, @AuthenticationPrincipal final Principal principal) {
        var order = dbOrdersStorage.getOrderByUuid(orderId);
        String email = null;
        String phone = null;
        String name = null;
        String communicationMethod = null;
        String instagram = null;
        if (principal != null) {
            var user = dbUsersStorage.getClientByPhoneOrEmail(principal.getName());
            email = user.getEmail();
            phone = user.getPhone();
            name = user.getFirstName();
            communicationMethod = user.getCommunicationMethod();
            instagram = user.getInstagramAccount();
        }
        model.addAttribute("personalAccount", new PersonalAccount(principal, dbUsersStorage));
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
    public String showOrder(@RequestParam String orderId, Model model, @AuthenticationPrincipal final Principal user) {
        var order = dbOrdersStorage.getOrderByUuid2(orderId);
        var client = dbUsersStorage.getClientByUuid(order.getClientUuid());
        var tour = dbToursRepository.findById(order.getTourId()).get();
        String messageToUser;
        if (user == null) {
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
        model.addAttribute("personalAccount", new PersonalAccount(user, dbUsersStorage));
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
    public String confirmSecretCode(@PathVariable String code, Model model, @AuthenticationPrincipal Principal user, HttpServletRequest httpRequest) {
        var emailCode = emailSecretCodeRepository.findFirstByUuid(code);
        var statusCode = 0;
        PersonalAccount personalAccount;
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
        } else {
            personalAccount = new PersonalAccount(user, dbUsersStorage);
        }
        model.addAttribute("personalAccount", personalAccount);
        model.addAttribute("status", statusCode);
        return "confirmEmail";
    }

//    @GetMapping(value = "allOrders")
//    public String allOrders(Model model,
//                            @PageableDefault(
//                                    sort = {"coolness"},
//                                    direction = Sort.Direction.DESC)
//                                    Pageable pageable,
//                            @AuthenticationPrincipal final Principal user) {
//        var personalAccount = new PersonalAccount(user, dbUsersStorage);
//        var client = personalAccount.getClient();
//        var tours = tourStorage.findTours(pageable);
//        if (client != null) {
//            tours.forEach(x ->
//                    x.setLikedByPerson(client.getLikedToursId().contains(x.getId()))
//            );
//
//
//        }
//        var likedTours = client.getLikedToursId();
//        var list = tours.stream().filter(x -> client.getLikedToursId().contains(x.getId())).collect(Collectors.toList());
//        Page<Tour> pageTour = new PageImpl(list, pageable, 10);
//
//        model.addAttribute("personalAccount", personalAccount);
//        model.addAttribute("page", pageTour);
//        model.addAttribute("url", "/");
//        return "index";
//    }
}