package ru.sahlob.controllers;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sahlob.db.DBOrdersStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.interfaces.DBToursRepository;
import ru.sahlob.persistance.order.InputOrder;
import ru.sahlob.persistance.order.Order;
import ru.sahlob.persistance.order.utils.InputTourUtils;
import ru.sahlob.service.ServiceUtil;

@Controller
@Data
public class OrderController {

    private final DBToursRepository dbToursRepository;
    private final DBOrdersStorage dbOrdersStorage;
    private final DBUsersStorage dbUsersStorage;

    @PostMapping("/newOrder")
    @ResponseBody
    public String newOrder(Order order) {
        order.setTourPrice(
                InputTourUtils.getOrderPriceFromWithTypeTour(
                        order.getTourType(),
                        dbToursRepository.findById(
                                order.getTourId())
                                .get()));
        dbOrdersStorage.saveOrder(order);
        var uuid = ServiceUtil.getRandomUuid();
        while (dbOrdersStorage.getOrderByUuid(uuid) != null) {
            uuid = ServiceUtil.getRandomUuid();
        }
        order.setUuid(uuid);
        return "/order?orderId=" + order.getUuid();
    }

    @GetMapping(value = "/order")
    public String order(@RequestParam String orderId, Model model) {
        var order = dbOrdersStorage.getOrderByUuid(orderId);
        model.addAttribute("id", order.getId());
        model.addAttribute("date", order.getTourDate());
        model.addAttribute("type", order.getTourType());
        model.addAttribute("price", order.getTourPrice());
        return "order";
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
                    .addNewUser(inputOrder);
        }
        InputTourUtils.addAdditionalInfo(client, order, inputOrder);
        order.setComment(inputOrder.getComment());
        if (client.getUuid() == null) {
            client.setUuid(ServiceUtil.getRandomUuid());
        }
        order.setClientUuid(client.getUuid());
        order.setUuid2(ServiceUtil.getRandomUuid());
        order.setUuid(null);
        dbUsersStorage.saveUser(client);
        dbOrdersStorage.saveOrder(order);
        return "/showOrder?orderId=" + order.getUuid2();
    }

    @GetMapping(value = "/showOrder")
    public String showOrder(@RequestParam String orderId, Model model) {
        var order = dbOrdersStorage.getOrderByUuid2(orderId);
        var client = dbUsersStorage.getClientByUuid(order.getClientUuid());
        var tour = dbToursRepository.findById(order.getTourId()).get();
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
        return "/showOrder";
    }
}
