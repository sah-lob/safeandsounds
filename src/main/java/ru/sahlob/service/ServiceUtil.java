package ru.sahlob.service;

import java.util.UUID;

public class ServiceUtil {
    public static String getRandomUuid() {
        return UUID.randomUUID()
                .toString()
                .replaceAll("-", "");
    }
}
