package ru.sahlob.controllers;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.db.interfaces.DBImagesRepository;
import ru.sahlob.persistance.Image;
import ru.sahlob.persistance.client.PersonalAccount;
import ru.sahlob.persistance.tour.LikedTour;
import ru.sahlob.security.MyUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@Data
public class PersonalAccountController {

    private final DBUsersStorage dbUsersStorage;
    private final MyUserDetailsService userService;
    private final TourStorage tourStorage;
    private final DBImagesRepository dbImagesRepository;

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
            model.addAttribute("photo", client.getImageId());
            if (likeCount > 0) {
                model.addAttribute("likes", client.getLikedToursId().stream().limit(3).map(x -> new LikedTour(tourStorage.findTourById(x))).collect(Collectors.toList()));
            }
        }
        return "personalAccount/personalAccount";
    }


    @PostMapping(value = "/editClientName")
    @ResponseBody
    public void editClientName(@AuthenticationPrincipal final Principal user, @RequestParam String newClientName) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        if (personalAccount.isAuthorized()) {
            var client = personalAccount.getClient();
            client.setFirstName(newClientName);
            dbUsersStorage.saveUser(client);
        }
    }

    @PostMapping(value = "/editClientPhone")
    @ResponseBody
    public void editClientPhone(@AuthenticationPrincipal final Principal user, @RequestParam String newClientPhone) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        if (personalAccount.isAuthorized()) {
            var client = personalAccount.getClient();
            client.setPhone(newClientPhone);
            dbUsersStorage.saveUser(client);
        }
    }

    @PostMapping(value = "/editClientEmail")
    @ResponseBody
    public void editClientEmail(@AuthenticationPrincipal final Principal user, @RequestParam String newClientEmail, HttpServletRequest httpRequest) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        if (personalAccount.isAuthorized()) {
            var client = personalAccount.getClient();
            client.setEmail(newClientEmail);
            dbUsersStorage.saveUser(client);
            var userDetails = userService.loadUserByUsername(client.getEmail());
            var token = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities());
            token.setDetails(new WebAuthenticationDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }


    @PostMapping(value = "/editClientInstagram")
    @ResponseBody
    public void editClientInstagram(@AuthenticationPrincipal final Principal user, @RequestParam String newClientInstagram) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        if (personalAccount.isAuthorized()) {
            var client = personalAccount.getClient();
            client.setInstagramAccount(newClientInstagram);
            dbUsersStorage.saveUser(client);
        }
    }

    @PostMapping(value = "/newAvatar")
    @ResponseBody
    public void newAvatar(@AuthenticationPrincipal final Principal user, @RequestParam("files[]") MultipartFile[] files) throws IOException {
        if (files.length > 0) {
            MultipartFile multipartFile = files[0];
            var image = new Image(multipartFile);
            dbImagesRepository.save(image);
            var client = new PersonalAccount(user, dbUsersStorage).getClient();
            if (client.getImageId() != -1) {
                dbImagesRepository.deleteById(client.getImageId());
            }
            client.setImageId(image.getId());
            dbUsersStorage.saveUser(client);
        }
    }

    @GetMapping(value = "/getAvatar")
    @ResponseBody
    public byte[] getAvatar(@AuthenticationPrincipal final Principal user) {
        var image = dbImagesRepository.findAllById(new PersonalAccount(user, dbUsersStorage).getClient().getImageId());
        return image.getData();
    }
}
