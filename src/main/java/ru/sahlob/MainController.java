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
import ru.sahlob.persistance.InputTour;
import ru.sahlob.persistance.Logo;
import ru.sahlob.storage.TourStorage;

import java.io.IOException;
import java.util.ArrayList;

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

    @GetMapping(value = "/chooseTour")
    public String chooseTour(@RequestParam int id, Model model) {
        model.addAttribute("tour", tourStorage.findTourById(id));
        return "chooseTour";
    }

    @GetMapping(value = "/security/adminpage")
    public String adminPage() {
        return "security/adminpage";
    }


    @PostMapping("/")
    @ResponseBody
    public void newPost(@RequestParam("file") MultipartFile multipartFile) {
        dbFileStorageService.storeFile(multipartFile);
    }

    @PostMapping("/security/adminpage")
    @ResponseBody
    public void newTour(InputTour inputTour) throws IOException {
        tourStorage.addTour(inputTour);
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
