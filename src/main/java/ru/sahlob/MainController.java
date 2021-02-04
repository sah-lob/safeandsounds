package ru.sahlob;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import ru.sahlob.db.DBImagesRepository;
import ru.sahlob.db.DBLogosRepository;
import ru.sahlob.persistance.InputTour;
import ru.sahlob.persistance.Logo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@Data
public class MainController {

    private final DBImagesRepository dbImagesRepository;
    private final DBLogosRepository dbLogosRepository;

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(HttpServletRequest req, HttpServletResponse resp) {
        return "login";
    }

    @GetMapping(value = "/chooseTour")
    public String chooseTour() {
        return "chooseTour";
    }

    @GetMapping(value = "/security/adminpage")
    public String adminPage() {
        return "security/adminpage";
    }


    @PostMapping("/newLogo")
    @ResponseBody
    public void newPost(@RequestBody Logo logo) {
        dbLogosRepository.save(logo);
    }

    @PostMapping("/newTour")
    @ResponseBody
    public RedirectView newTour(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var sb = new StringBuilder();
        try (var reader = req.getReader()) {
            if (reader != null) {
                sb.append(reader.readLine());
            }
        }

        var mapper = new ObjectMapper();
        var inputTour = mapper.readValue(sb.toString(), InputTour.class);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("index");
        resp.getWriter().write("success");
        return redirectView;
    }

    @GetMapping(value = "/getLogo")
    @ResponseBody
    public Logo getLogo() {
        var logos = new ArrayList<Logo>();
        dbLogosRepository.findAll().iterator().forEachRemaining(logos::add);
        Logo logo = null;
        if (!logos.isEmpty()) {
            logo = logos.get(0);
        }
        return logo;
    }
}
