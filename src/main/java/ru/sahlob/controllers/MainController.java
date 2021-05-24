package ru.sahlob.controllers;

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
import ru.sahlob.db.DBOrdersStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.db.interfaces.DBImagesRepository;
import ru.sahlob.db.interfaces.DBLogosRepository;
import ru.sahlob.db.interfaces.DBToursRepository;
import ru.sahlob.persistance.Logo;
import ru.sahlob.persistance.calender.CalenderAnswer;
import ru.sahlob.persistance.order.InputOrder;
import ru.sahlob.persistance.order.Order;
import ru.sahlob.persistance.order.utils.InputTourUtils;
import ru.sahlob.service.ServiceUtil;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;

import static ru.sahlob.service.calender.CalenderAnswerUtil.getCalenderAnswer;
import static ru.sahlob.service.calender.GeneralCalenderUtils.getNumOfMonthByTitle;

@Controller
@Data
public class MainController {

    private final DBImagesRepository dbImagesRepository;
    private final DBLogosRepository dbLogosRepository;
    private final DBToursRepository dbToursRepository;
    private final TourStorage tourStorage;
    private final DBOrdersStorage dbOrdersStorage;
    private final DBFileStorageService dbFileStorageService;
    private final DBUsersStorage dbUsersStorage;

    @GetMapping(value = "/")
    public String index(Model model,
                        @PageableDefault(
                                sort = {"coolness"},
                                direction = Sort.Direction.DESC)
                                Pageable pageable,
                        HttpSession session) {
        String sessionId = session.getId();
        System.out.println("[session-id]: " + sessionId);
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
