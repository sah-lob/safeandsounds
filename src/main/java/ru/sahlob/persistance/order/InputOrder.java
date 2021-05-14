package ru.sahlob.persistance.order;

import lombok.Data;

@Data
public class InputOrder {
    private int orderID;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private int communicationMethodNum;
    private String communicationMethodAdditionalValue;
    private String comment;
}
