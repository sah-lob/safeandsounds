package ru.sahlob;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.sahlob.db.DBFileStorageService;
import ru.sahlob.db.DBImagesRepository;
import ru.sahlob.db.DBLogosRepository;
import ru.sahlob.persistance.Image;
import ru.sahlob.persistance.InputTour;
import ru.sahlob.persistance.Logo;
import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.service.CalenderUtil;
import ru.sahlob.storage.TourStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
@Data
public class MainController {

    private final DBImagesRepository dbImagesRepository;
    private final DBLogosRepository dbLogosRepository;
    private final TourStorage tourStorage;
    private final DBFileStorageService dbFileStorageService;

    @GetMapping(value = "/")
    public String index(Model model,
                        @PageableDefault(sort = {"coolness"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("page", tourStorage.findTours(pageable));
        model.addAttribute("url", "/");
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @GetMapping(value = "/test")
    @ResponseBody
    public CalenderAnswer test(@RequestParam String currentMonth,
                               @RequestParam int direction,
                               @RequestParam int currentYear,
                               @RequestParam int tourId) {
        var newCurrentMonth = CalenderUtil.getNumOfMonth(currentMonth) + direction;
        var calenderAnswer = CalenderUtil.getCalenderAnswer(newCurrentMonth, currentYear, tourStorage.findTourById(tourId));
        calenderAnswer.setBackMonth(calenderAnswer.getCurrentMonth() != Calendar.getInstance().get(Calendar.MONTH));
        return calenderAnswer;
    }

    @GetMapping(value = "/chooseTour")
    public String chooseTour(@RequestParam int id, Model model) {
        model.addAttribute("tour", tourStorage.findTourById(id));
        return "chooseTour";
    }

    @GetMapping(value = "/security/adminpage")
    public String adminPage() {
        return "security/adminpage";
    }

    @GetMapping(value = "/security/addTour")
    public String addTour() {
        return "security/addTour";
    }

    @PostMapping("/security/addTour")
    @ResponseBody
    public void newTour(InputTour inputTour) throws IOException {
        tourStorage.addTour(inputTour);
    }


    @PostMapping("/")
    @ResponseBody
    public void newPost(@RequestParam("file") MultipartFile multipartFile) {
        dbFileStorageService.storeFile(multipartFile);
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
