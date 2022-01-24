package ru.sahlob.utils;

import ru.sahlob.persistance.client.EmailSecretCode;

public abstract class EmailGenerator {
    public static EmailSecretCode generateEmailSecretCode() {
        return EmailSecretCode.builder()
                .id(1)
                .clientId(2)
                .uuid("23")
                .build();
    }
}
