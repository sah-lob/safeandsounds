package ru.sahlob.persistance.order;

import lombok.Data;

@Data
public class InputOrder {
    private int orderID;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private String communicationMethodAdditionalValue;
    private String instagram;
    private String comment;
}
