package ru.sahlob.persistance.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientUtil {
    public static Client getClientFromRegistrationInputClient(RegistrationInputClient registrationInputClient) {
        var client = new Client();
        client.setFirstName(registrationInputClient.getFirstName());
        client.setPassword(registrationInputClient.getPassword());
        client.setEmail(registrationInputClient.getEmail());
        return client;
    }
}
