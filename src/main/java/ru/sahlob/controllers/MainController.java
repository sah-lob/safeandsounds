package ru.sahlob.controllers;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.sahlob.db.DBFileStorageService;
import ru.sahlob.db.DBImagesStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.persistance.calender.CalenderInput;
import ru.sahlob.persistance.client.*;
import ru.sahlob.persistance.tour.TourFilter;
import ru.sahlob.service.mail.MailSender;

import java.security.Principal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Set;

import static ru.sahlob.service.calender.CalenderAnswerUtil.getCalenderAnswer;

@Controller
@Data
public class MainController {

    private final DBUsersStorage dbUsersStorage;
    private final DBImagesStorage dBImagesStorage;
    private final TourStorage tourStorage;
    private final DBFileStorageService dbFileStorageService;
    private final MailSender mailSender;

    @GetMapping(value = "/")
    public String index(Model model,
                        @PageableDefault(
                                sort = {"coolness"},
                                direction = Sort.Direction.DESC)
                                Pageable pageable,
                        @RequestParam(required = false) boolean lt,
                        @RequestParam(required = false) Integer durationFrom,
                        @RequestParam(required = false) Integer durationTo,
                        @RequestParam(required = false) Integer hourFrom,
                        @RequestParam(required = false) Integer hourTo,
                        @RequestParam(required = false) Integer priceFrom,
                        @RequestParam(required = false) Integer priceTo) {


        var personalAccount = new PersonalAccount(SecurityContextHolder.getContext().getAuthentication(), dbUsersStorage);
        var client = personalAccount.getClient();
        Set<Integer> likedToursId;
        if (client == null) {
            likedToursId = null;
        } else {
            if (lt) {
                likedToursId = client.getLikedToursId();
            } else {
                likedToursId = null;
            }
        }
        var tourFilter = new TourFilter();
        tourFilter.setLt(lt);
        tourFilter.setLikedToursId(likedToursId);
        tourFilter.setDurationFrom(durationFrom);
        tourFilter.setDurationTo(durationTo);
        tourFilter.setHourFrom(hourFrom);
        tourFilter.setHourTo(hourTo);
        tourFilter.setPriceFrom(priceFrom);
        tourFilter.setPriceTo(priceTo);

        var tours = tourStorage.testFindTours(pageable, tourFilter);
        if (client != null) {
            var finalClient = client;
            tours.forEach(x ->
                    x.setLikedByPerson(finalClient.getLikedToursId().contains(x.getId()))
            );
        }

        model.addAttribute("personalAccount", personalAccount);
        model.addAttribute("page", tours);
        model.addAttribute("url", "/");
        model.addAttribute("tourFilter", tourFilter);
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/login2")
    public String login2() {
        return "login2";
    }


    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(RegistrationInputClient registrationInputClient, Model model) {
        Client client = ClientUtil.getClientFromRegistrationInputClient(registrationInputClient);
        if (dbUsersStorage.getClientByName(client.getFirstName()) != null) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
        client.setActive(true);
        client.setRoles(Collections.singleton(ClientRoles.CLIENT));
        dbUsersStorage.saveUser(client);
        return "redirect:/login";
    }

    @GetMapping(value = "/getCalender")
    @ResponseBody
    public CalenderAnswer getCalender(CalenderInput calenderInput) {
        var calenderAnswer = getCalenderAnswer(calenderInput, tourStorage);
        calenderAnswer.setBackMonth(calenderAnswer.getCurrentMonth() != Calendar.getInstance().get(Calendar.MONTH));
        return calenderAnswer;
    }

    @GetMapping(value = "/chooseTour")
    public String chooseTour(@RequestParam int id, Model model,
                             @AuthenticationPrincipal final Principal user) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        model.addAttribute("personalAccount", personalAccount);
        model.addAttribute("tour", tourStorage.findTourById(id));
        return "chooseTour";
    }

    @PostMapping("/")
    @ResponseBody
    public void newPost(@RequestParam("file") MultipartFile multipartFile) {
        dbFileStorageService.storeFile(multipartFile);
    }

    @GetMapping(value = "/getLogin")
    @ResponseBody
    public byte[] getLogin(@RequestParam Integer id) {
        return dBImagesStorage.findById(id).getData();
    }


    @PostMapping(value = "/like")
    @ResponseBody
    public void like(@RequestParam Integer tourId, @AuthenticationPrincipal final Principal user) {
        var personalAccount = new PersonalAccount(user, dbUsersStorage);
        var client = personalAccount.getClient();
        if (client != null) {
            if (client.getLikedToursId().contains(tourId)) {
                client.getLikedToursId().remove(tourId);
            } else {
                client.getLikedToursId().add(tourId);
            }
        }
        dbUsersStorage.saveUser(client);
    }
}
