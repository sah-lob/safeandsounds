package ru.sahlob.controllers;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.sahlob.db.DBFileStorageService;
import ru.sahlob.db.TourStorage;
import ru.sahlob.db.interfaces.DBImagesRepository;
import ru.sahlob.db.interfaces.DBLogosRepository;
import ru.sahlob.db.interfaces.DBUsersRepository;
import ru.sahlob.persistance.Logo;
import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.client.ClientRoles;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import static ru.sahlob.service.calender.CalenderAnswerUtil.getCalenderAnswer;
import static ru.sahlob.service.calender.GeneralCalenderUtils.getNumOfMonthByTitle;

@Controller
@Data
public class MainController {

    private final DBUsersRepository dbUsersRepository;
    private final DBImagesRepository dbImagesRepository;
    private final DBLogosRepository dbLogosRepository;
    private final TourStorage tourStorage;
    private final DBFileStorageService dbFileStorageService;

    @GetMapping(value = "/")
    public String index(Model model,
                        @PageableDefault(
                                sort = {"coolness"},
                                direction = Sort.Direction.DESC)
                                Pageable pageable,
                        HttpSession session,
                        @AuthenticationPrincipal final Principal user) {
        String userName = null;
        if (user != null) {
            userName = user.getName();
        }
        var sessionId = session.getId();
        System.out.println("[session-id]: " + sessionId);
        System.out.println("[userName]: " + userName);
        model.addAttribute("user", userName);
        model.addAttribute("page", tourStorage.findTours(pageable));
        model.addAttribute("url", "/");
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Client client, Model model) {
        Client userFromDb = dbUsersRepository.findByFirstName(client.getFirstName());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists");
            return "registration";
        }

        client.setActive(true);
        client.setRoles(Collections.singleton(ClientRoles.CLIENT));
        dbUsersRepository.save(client);

        return "redirect:/login";
    }


    @GetMapping(value = "/test")
    @ResponseBody
    public CalenderAnswer test(@RequestParam String currentMonth,
                               @RequestParam int direction,
                               @RequestParam int currentYear,
                               @RequestParam int tourId) {
        var newCurrentMonth = getNumOfMonthByTitle(currentMonth) + direction;
        var calenderAnswer = getCalenderAnswer(newCurrentMonth, currentYear, tourStorage.findTourById(tourId));
        calenderAnswer.setBackMonth(calenderAnswer.getCurrentMonth() != Calendar.getInstance().get(Calendar.MONTH));
        return calenderAnswer;
    }

    @GetMapping(value = "/chooseTour")
    public String chooseTour(@RequestParam int id, Model model) {
        model.addAttribute("tour", tourStorage.findTourById(id));
        return "chooseTour";
    }

    @PostMapping("/")
    @ResponseBody
    public void newPost(@RequestParam("file") MultipartFile multipartFile) {
        dbFileStorageService.storeFile(multipartFile);
    }

    @GetMapping(value = "/getLogo")
    @ResponseBody
    public byte[] getLogo() {
        var logos = new ArrayList<Logo>();
        dbLogosRepository.findAll().iterator().forEachRemaining(logos::add);
        if (logos.isEmpty()) {
            return null;
        }
        var logo = logos.get(0);
        return logo.getData();
    }

    @GetMapping(value = "/getLogin")
    @ResponseBody
    public byte[] getLogin(@RequestParam Integer id) {
        var image = dbImagesRepository.findAllById(id);
        return image.getData();
    }
}
