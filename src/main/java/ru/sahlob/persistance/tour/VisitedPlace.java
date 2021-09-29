package ru.sahlob.persistance.tour;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
public class VisitedPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int duration;
}
