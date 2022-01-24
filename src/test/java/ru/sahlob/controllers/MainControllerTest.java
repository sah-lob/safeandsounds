package ru.sahlob.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.shaded.com.fasterxml.jackson.core.type.TypeReference;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.sahlob.AbstractIT;
import ru.sahlob.db.DBFileStorageService;
import ru.sahlob.db.DBImagesStorage;
import ru.sahlob.db.DBUsersStorage;
import ru.sahlob.db.TourStorage;
import ru.sahlob.persistance.Image;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.tour.Tour;
import ru.sahlob.service.mail.MailSender;
import ru.sahlob.utils.CalenderGenerator;
import ru.sahlob.utils.ClientGenerator;
import ru.sahlob.utils.TourGenerator;

import java.util.Collections;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
class MainControllerTest extends AbstractIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private DBUsersStorage dbUsersStorage;
    @MockBean
    private DBImagesStorage dBImagesStorage;
    @MockBean
    private TourStorage tourStorage;
    @Mock
    private DBFileStorageService dbFileStorageService;
    @Mock
    private MailSender mailSender;

    @Mock
    Client client;

    @BeforeEach
    public void setMocks() {
        client = new Client();
        client.setFirstName("Gena");
        client.setEmail("email");
        client.setLikedToursId(Collections.singleton(1));
        when(dbUsersStorage.getClientByPhoneOrEmail("user")).thenReturn(client);
        Tour tour = new Tour();
        tour.setId(1);
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public Pageable withPage(int pageNumber) {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        Page<Tour> pages = new PageImpl<Tour>(Collections.singletonList(tour), pageable, 1);
        when(tourStorage.testFindTours(any(), any())).thenReturn(pages);
    }

    @Test
    void mainPageAntonym() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void mainPageWithUser() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void mainPageWithUserAndLikedTours() throws Exception {
        this.mockMvc.perform(get("/?lt=true"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void mainPageWithUserAndLikedToursAndClientLikeTourWithID1() throws Exception {
        this.mockMvc.perform(get("/?lt=true"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getMappingLogin() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getMappingLogin2() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockMvc.perform(get("/login2")).andExpect(status().isOk());
    }

    @Test
    void getMappingRegistration() throws Exception {
        this.mockMvc.perform(get("/registration"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void postRegistration() throws Exception {
        this.mockMvc.perform(post("/registration").params(generateRegistrationInputClient()))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void postRegistrationUserExists() throws Exception {
        when(dbUsersStorage.getClientByName(any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(post("/registration").params(generateRegistrationInputClient()))
                .andDo(print()).andExpect(status().isOk());
    }

    private LinkedMultiValueMap<String, String> generateRegistrationInputClient() {
        Map<String, String> maps = new ObjectMapper()
                .convertValue(
                        ClientGenerator.generateRegistrationInputClient(),
                        new TypeReference<Map<String, String>>() {
                        });
        var parameters = new LinkedMultiValueMap<String, String>();
        parameters.setAll(maps);
        return parameters;
    }

    @Test
    void getCalender() throws Exception {
        when(tourStorage.findTourById(anyInt())).thenReturn(TourGenerator.generateOptionalTour());
        this.mockMvc.perform(get("/getCalender")
                        .params(generateRegistrationCalenderInput()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private LinkedMultiValueMap<String, String> generateRegistrationCalenderInput() {
        Map<String, String> maps = new ObjectMapper()
                .convertValue(
                        CalenderGenerator.generateCalenderInput(),
                        new TypeReference<Map<String, String>>() {
                        });
        var parameters = new LinkedMultiValueMap<String, String>();
        parameters.setAll(maps);
        return parameters;
    }


    @Test
    void getChooseTour() throws Exception {
        this.mockMvc.perform(get("/chooseTour?id=3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getLogin() throws Exception {
        var image = new Image();
        image.setData(null);
        when(dBImagesStorage.findById(anyInt())).thenReturn(image);
        this.mockMvc.perform(get("/getLogin?id=3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void postLikeWithUser() throws Exception {
        when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(post("/like?tourId=3")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void postLike() throws Exception {
//        when(dbUsersStorage.getClientByPhoneOrEmail(any())).thenReturn(ClientGenerator.generateClient());
        this.mockMvc.perform(post("/like?tourId=3")).andDo(print()).andExpect(status().isOk());
    }
}
