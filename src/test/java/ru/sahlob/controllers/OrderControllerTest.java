package ru.sahlob.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.testcontainers.shaded.com.fasterxml.jackson.core.type.TypeReference;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.sahlob.AbstractIT;
import ru.sahlob.db.DBOrdersStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.interfaces.DBToursRepository;
import ru.sahlob.db.interfaces.EmailSecretCodeRepository;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.security.MyUserDetailsService;
import ru.sahlob.security.MyUserPrincipal;
import ru.sahlob.service.mail.MailSender;
import ru.sahlob.utils.ClientGenerator;
import ru.sahlob.utils.EmailGenerator;
import ru.sahlob.utils.OrderGenerator;
import ru.sahlob.utils.TourGenerator;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class OrderControllerTest extends AbstractIT {

    @MockBean
    private DBToursRepository dbToursRepository;
    @MockBean
    private DBOrdersStorage dbOrdersStorage;
    @MockBean
    private DBUsersStorage dbUsersStorage;
    @MockBean
    private EmailSecretCodeRepository emailSecretCodeRepository;
    @MockBean
    private MailSender mailSender;
    @MockBean
    private MyUserDetailsService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void postNewOrder() throws Exception {
        Mockito.when(dbToursRepository.findFirstById(anyInt())).thenReturn(TourGenerator.generateOptionalTour());
        Mockito.when(dbOrdersStorage.getOrderByUuid(any())).thenReturn(null);
        this.mockMvc.perform(post("/newOrder").params(generateNewInputOrderToParams()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getNewOrderAntonym() throws Exception {
        Mockito.when(dbOrdersStorage.getOrderByUuid(any())).thenReturn(OrderGenerator.generateOrder());
        this.mockMvc.perform(get("/order?orderId=3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void getNewOrderWithUser() throws Exception {
        Mockito.when(dbOrdersStorage.getOrderByUuid(any())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(get("/order?orderId=3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void postConfirmNewOrderWithExistingUser() throws Exception {
        Mockito.when(dbOrdersStorage.getOrderByUuid(any())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbOrdersStorage.getOrderById(anyInt())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any(), any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(post("/confirmNewOrder").params(generateInputOrderToParams()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void postConfirmNewOrderWithNewUser() throws Exception {
        Mockito.when(dbOrdersStorage.getOrderByUuid(any())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbOrdersStorage.getOrderById(anyInt())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any(), any())).thenReturn(null);
        Client clientWithoutUUid = ClientGenerator.generateClient();
        clientWithoutUUid.setUuid(null);
        Mockito.when(dbUsersStorage.addNewUserFromInputOrder(any())).thenReturn(clientWithoutUUid);
        this.mockMvc.perform(post("/confirmNewOrder").params(generateInputOrderToParams()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getShowOrder() throws Exception {
        Mockito.when(dbOrdersStorage.getOrderByUuid2(any())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbUsersStorage.getClientByUuid(any())).thenReturn(ClientGenerator.generateClient());
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        Mockito.when(dbToursRepository.findFirstById(anyInt())).thenReturn(TourGenerator.generateOptionalTour());
        this.mockMvc.perform(get("/showOrder?orderId=3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void getShowOrderWithUser() throws Exception {
        Mockito.when(dbOrdersStorage.getOrderByUuid2(any())).thenReturn(OrderGenerator.generateOrder());
        Mockito.when(dbUsersStorage.getClientByUuid(any())).thenReturn(ClientGenerator.generateClient());
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        Mockito.when(dbToursRepository.findFirstById(anyInt())).thenReturn(TourGenerator.generateOptionalTour());
        this.mockMvc.perform(get("/showOrder?orderId=3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getConfirmCode() throws Exception {
        this.mockMvc.perform(get("/confirmCode/93"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void getConfirmCodeWithUser() throws Exception {
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(get("/confirmCode/93"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void getConfirmCodeWithUserAndEmailSecretCode() throws Exception {
        Mockito.when(emailSecretCodeRepository.findFirstByUuid(any())).thenReturn(EmailGenerator.generateEmailSecretCode());
        Mockito.when(dbUsersStorage.getClientById(anyInt())).thenReturn(ClientGenerator.generateClient());
        Mockito.when(userService.loadUserByUsername(any())).thenReturn(new MyUserPrincipal(ClientGenerator.generateClient()));
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(get("/confirmCode/93"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private LinkedMultiValueMap<String, String> generateNewInputOrderToParams() {
        Map<String, String> maps = new ObjectMapper()
                .convertValue(
                        OrderGenerator.generateNewInputOrder(),
                        new TypeReference<Map<String, String>>() {
                        });
        var parameters = new LinkedMultiValueMap<String, String>();
        parameters.setAll(maps);
        return parameters;
    }

    private LinkedMultiValueMap<String, String> generateInputOrderToParams() {
        Map<String, String> maps = new ObjectMapper()
                .convertValue(
                        OrderGenerator.generateInputOrder(),
                        new TypeReference<Map<String, String>>() {
                        });
        var parameters = new LinkedMultiValueMap<String, String>();
        parameters.setAll(maps);
        return parameters;
    }
}