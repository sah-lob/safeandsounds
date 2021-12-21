package ru.sahlob.controllers.restpersistance;

import lombok.Data;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

@Data
public class IndexInput {
    private Pageable pageable;
    private boolean lt = false;
    private Integer durationFrom;
    private Integer durationTo;
    private Integer hourFrom;
    private Integer hourTo;
    private Integer priceFrom;
    private Integer priceTo;
    private Principal user;
}
