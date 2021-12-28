package ru.sahlob.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import ru.sahlob.AbstractIT;
import ru.sahlob.db.DBFileStorageService;
import ru.sahlob.db.DBImagesStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.service.mail.MailSender;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
public class MainControllerTest extends AbstractIT {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DBUsersStorage dbUsersStorage;
    @Mock
    private DBImagesStorage dBImagesStorage;
    @Mock
    private TourStorage tourStorage;
    @Mock
    private DBFileStorageService dbFileStorageService;
    @Mock
    private MailSender mailSender;

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
