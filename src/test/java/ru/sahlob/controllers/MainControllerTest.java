package ru.sahlob.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.sahlob.AbstractIT;
import ru.sahlob.db.DBFileStorageService;
import ru.sahlob.db.DBImagesStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.service.mail.MailSender;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
public class MainControllerTest extends AbstractIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DBUsersStorage dbUsersStorage;
    @Mock
    private DBImagesStorage dBImagesStorage;
    @Mock
    private TourStorage tourStorage;
    @Mock
    private DBFileStorageService dbFileStorageService;
    @Mock
    private MailSender mailSender;

    @Mock
    Client client;

    @Test
    public void mainIndexTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void mainIndexTest2() throws Exception {
        client = new Client();
        client.setFirstName("Gena");
        client.setEmail("email");
        Mockito.when(dbUsersStorage.getClientByPhoneOrEmail("user")).thenReturn(client);
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
