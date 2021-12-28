package ru.sahlob.persistance.client;

public class ClientUtil {
    public static Client getClientFromRegistrationInputClient(RegistrationInputClient registrationInputClient) {
        var client = new Client();
        client.setFirstName(registrationInputClient.getFirstName());
        client.setPassword(registrationInputClient.getPassword());
        client.setEmail(registrationInputClient.getEmail());
        return client;
    }
}
