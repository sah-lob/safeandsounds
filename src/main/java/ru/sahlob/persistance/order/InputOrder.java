package ru.sahlob.persistance.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputOrder {
    private int orderID;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private String communicationMethodAdditionalValue;
    private String instagram;
    private String comment;
}
