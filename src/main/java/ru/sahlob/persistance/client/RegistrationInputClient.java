package ru.sahlob.persistance.client;

import lombok.Data;

@Data
public class RegistrationInputClient {
    private String firstName;
    private String password;
    private String email;
}
