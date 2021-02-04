package ru.sahlob;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Data
public class MainController {

    private final DBImagesRepository dbImagesRepository;

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


    @PostMapping("/newCar")
    public RedirectView newPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var sb = new StringBuilder();
        try (var reader = req.getReader()) {
            if (reader != null) {
                sb.append(reader.readLine());
            }
        }

        var mapper = new ObjectMapper();
        var image = mapper.readValue(sb.toString(), Image.class);

        dbImagesRepository.save(image);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("index");
        resp.getWriter().write("success");
        return redirectView;
    }

    @GetMapping(value = "/img")
    public void imgGet(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        var pw = resp.getWriter();
        var images = dbImagesRepository.findAll();
        var image = Iterables.get(images, 0);
        var objectMapper = new ObjectMapper();
        var arrayJson = objectMapper.createArrayNode();
        var node = objectMapper.createObjectNode();
        var arrayNode = objectMapper.createArrayNode();
        node.put("id", image.getImage());
        var innerNode = objectMapper.createObjectNode();
        arrayNode.add(innerNode);
        arrayJson.add(node);
        pw.append(objectMapper.writeValueAsString(arrayJson));
        pw.flush();
    }
}
