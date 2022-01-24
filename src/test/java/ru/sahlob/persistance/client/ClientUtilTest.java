package ru.sahlob.persistance.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientUtilTest {

    @Test
    void getClientFromRegistrationInputClientTest() {
        var registrationInputClient = new RegistrationInputClient();
        var firstName = "firstName";
        var password = "password";
        var email = "email";
        registrationInputClient.setFirstName(firstName);
        registrationInputClient.setPassword(password);
        registrationInputClient.setEmail(email);
        var client = ClientUtil.getClientFromRegistrationInputClient(registrationInputClient);
        assertEquals(firstName, client.getFirstName());
        assertEquals(password, client.getPassword());
        assertEquals(email, client.getEmail());
    }
}