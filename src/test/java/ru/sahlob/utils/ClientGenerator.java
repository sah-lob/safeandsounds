package ru.sahlob.utils;

import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.client.ClientRoles;

import java.util.ArrayList;
import java.util.Collections;

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
                .likedToursId(Collections.emptySet())
                .build();
        return client;
    }
}
