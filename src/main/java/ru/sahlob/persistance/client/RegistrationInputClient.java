package ru.sahlob.persistance.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationInputClient {
    private String firstName;
    private String password;
    private String email;
}
