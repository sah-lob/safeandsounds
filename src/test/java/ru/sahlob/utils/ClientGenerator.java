package ru.sahlob.utils;

import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.client.ClientRoles;
import ru.sahlob.persistance.client.RegistrationInputClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public abstract class ClientGenerator {

    public static Client generateClient() {
        var client = Client.builder()
                .id(1)
                .imageId(2)
                .uuid("uuid")
                .firstName("first name")
                .password("pass")
                .active(true)
                .phone("phoneNumber")
                .email("email")
                .communicationMethod("communicationMethod")
                .whatsAppPhone("whats app phone")
                .telegramPhone("telegram phone")
                .instagramAccount("instagram account")
                .orders(new ArrayList<>())
                .roles(Collections.singleton(ClientRoles.CLIENT))
                .likedToursId(new HashSet<>())
                .build();
        return client;
    }

    public static RegistrationInputClient generateRegistrationInputClient() {
        return RegistrationInputClient.builder().firstName("firstName").password("password").email("emil").build();
    }
}
