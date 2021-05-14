package ru.sahlob.persistance.order.utils;

import org.springframework.stereotype.Component;
import ru.sahlob.persistance.client.Client;
import ru.sahlob.persistance.order.InputOrder;
import ru.sahlob.persistance.order.Order;
import ru.sahlob.persistance.order.PerformCommunicationMethod;

@Component
public class InputTourUtils {
    public static void addAdditionalInfo(Client client, Order order, InputOrder inputOrder) {
        var performCommunicationMethod = getPerformCommunicationMethodFromInputOrder(inputOrder);
        var additionalInfo = inputOrder.getCommunicationMethodAdditionalValue();
        order.setPerformCommunicationMethod(performCommunicationMethod);
        setAdditionalInfoToClient(additionalInfo, order, client);
    }

    private static void setAdditionalInfoToClient(String additionalInfo, Order order, Client client) {
        if (!additionalInfo.isEmpty()) {
            var communicationMethod = order.getPerformCommunicationMethod();
            switch (communicationMethod) {
                case telegram:
                    client.setTelegramPhone(additionalInfo);
                    break;
                case whatsApp:
                    client.setWhatsAppPhone(additionalInfo);
                    break;
                case instagram:
                    client.setInstagramAccount(additionalInfo);
                    break;
                case phone:
                    client.setPhone(additionalInfo);
                    break;
            }
        }
    }

    private static PerformCommunicationMethod getPerformCommunicationMethodFromInputOrder(InputOrder inputOrder) {
        switch (inputOrder.getCommunicationMethodNum()) {
            case (1):
                return PerformCommunicationMethod.whatsApp;
            case (2):
                return PerformCommunicationMethod.telegram;
            case (3):
                return PerformCommunicationMethod.instagram;
            case (4):
                return PerformCommunicationMethod.email;
//            case (5): return PerformCommunicationMethod.phone;
            default:
                return PerformCommunicationMethod.phone;
        }
    }
}
