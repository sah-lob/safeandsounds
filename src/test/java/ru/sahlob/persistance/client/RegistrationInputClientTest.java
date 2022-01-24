package ru.sahlob.persistance.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationInputClientTest {

    private RegistrationInputClient registrationInputClient;
    private String firstName = "firstName";
    private String email = "email";
    private String password = "123";

    @BeforeEach
    void setUp() {
        registrationInputClient = new RegistrationInputClient();
        registrationInputClient.setFirstName(firstName);
        registrationInputClient.setEmail(email);
        registrationInputClient.setPassword(password);
    }

    @Test
    void getFirstName() {
        assertEquals(firstName, registrationInputClient.getFirstName());
    }

    @Test
    void getPassword() {
        assertEquals(password, registrationInputClient.getPassword());
    }

    @Test
    void getEmail() {
        assertEquals(email, registrationInputClient.getEmail());
    }

    @Test
    void setFirstName() {
        registrationInputClient.setFirstName("newName");
        assertEquals("newName", registrationInputClient.getFirstName());
    }

    @Test
    void setPassword() {
        registrationInputClient.setPassword("newPassword");
        assertEquals("newPassword", registrationInputClient.getPassword());
    }

    @Test
    void setEmail() {
        registrationInputClient.setEmail("newEmail");
        assertEquals("newEmail", registrationInputClient.getEmail());
    }
}