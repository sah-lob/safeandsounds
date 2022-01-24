package ru.sahlob.persistance.client;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationInputClient {
    private String firstName;
    private String password;
    private String email;
}
