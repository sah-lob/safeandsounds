package ru.sahlob.controllers;

import lombok.Data;
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
import ru.sahlob.db.interfaces.DBToursRepository;
import ru.sahlob.persistance.Image;
import ru.sahlob.persistance.client.PersonalAccount;
import ru.sahlob.persistance.tour.InputTour;
import ru.sahlob.service.GenerateImageUtil;
import ru.sahlob.service.GenerateTestTours;

import java.io.IOException;
import java.security.Principal;

@Controller
@Data
public class SecurityController {

    private final DBImagesRepository dbImagesRepository;
    private final DBLogosRepository dbLogosRepository;
    private final DBToursRepository dbToursRepository;
    private final TourStorage tourStorage;
    private final DBFileStorageService dbFileStorageService;


    @GetMapping(value = "/security/adminpage")
    public String adminPage(Model model,
                            @AuthenticationPrincipal final Principal user) {
        model.addAttribute("personalAccount", new PersonalAccount(user));
        return "security/adminpage";
    }

    @GetMapping(value = "/security/addTour")
    public String addTour(Model model,
                          @AuthenticationPrincipal final Principal user) {
        model.addAttribute("personalAccount", new PersonalAccount(user));
        return "security/addTour";
    }

    @PostMapping("/security/addTour")
    @ResponseBody
    public void newTour(InputTour inputTour) throws IOException {
        tourStorage.addTour(inputTour);
    }

    @GetMapping(value = "/security/testingPage")
    public String testingPage(Model model,
                              @AuthenticationPrincipal final Principal user) {
        model.addAttribute("personalAccount", new PersonalAccount(user));
        return "security/testingPage";
    }

    @PostMapping("/security/testingPage")
    @ResponseBody
    public void generateTours(@RequestParam int numOfGeneratingTours) {
        for (int i = 0; i < numOfGeneratingTours; i++) {
            var tour = GenerateTestTours.generateTours();
            for (int j = 0; j < 5; j++) {
                var image = GenerateImageUtil.convertByteToImage(
                        GenerateImageUtil.generateRandomImage());
                dbImagesRepository.save(image);
                tour.addNewImageId(image.getId());
            }
            dbToursRepository.save(tour);
        }
    }


    @PostMapping("/security/adminpage/addphotototour")
    @ResponseBody
    public void addphotototour(@RequestParam MultipartFile file,
                               @RequestParam String name) throws IOException {
        var tour = tourStorage.findTourById(Integer.parseInt(name));
        var image = new Image(file);
        dbImagesRepository.save(image);
        tour.addNewImageId(image.getId());
        tourStorage.updateTour(tour);
    }
}
