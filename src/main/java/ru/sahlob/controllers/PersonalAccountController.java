package ru.sahlob.controllers;

import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.persistance.client.PersonalAccount;
import ru.sahlob.persistance.tour.LikedTour;

import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@Data
public class PersonalAccountController {

    private final DBUsersStorage dbUsersStorage;
    private final TourStorage tourStorage;

    @GetMapping(value = "/personalAccount")
    public String login(@AuthenticationPrincipal final Principal user, Model model) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        model.addAttribute("personalAccount", personalAccount);
        if (personalAccount.isAuthorized()) {
            var client = personalAccount.getClient();
            var likeCount = client.getLikedToursId().size();
            var ordersCount = client.getOrders().size();
            model.addAttribute("id", client.getId());
            model.addAttribute("name", client.getFirstName());
            model.addAttribute("phone", client.getPhone());
            model.addAttribute("email", client.getEmail());
            model.addAttribute("communicationMethod", client.getCommunicationMethod());
            model.addAttribute("instagram", client.getInstagramAccount());
            model.addAttribute("ordersCount", ordersCount);
            model.addAttribute("orders", client.getOrders().stream().limit(3).collect(Collectors.toList()));
            model.addAttribute("likeCount", likeCount);
            if (likeCount > 0) {
                model.addAttribute("likes", client.getLikedToursId().stream().limit(3).map(x -> new LikedTour(tourStorage.findTourById(x))).collect(Collectors.toList()));
            }
        }
        return "personalAccount/personalAccount";
    }
}
