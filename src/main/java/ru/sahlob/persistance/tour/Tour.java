package ru.sahlob.persistance.tour;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ElementCollection
    private List<Integer> imagesId = new ArrayList<>();
    private String name;
    @Type(type = "text")
    private String smallDescription;
    @Type(type = "text")
    private String description;
    private Integer price;
    private Integer coolness;
    @ElementCollection
    private Set<Integer> availableWeekDays;
//    @ElementCollection
//    private Map<TourTypes, Integer> tourPrices = new HashMap<>();

    public Tour(int imageId, String name, String description, Integer price, Integer coolness, Set<Integer> availableWeekDays) {
        this.imagesId.add(imageId);
        this.name = name;
        this.description = description;
        this.price = price;
        this.coolness = coolness;
        this.availableWeekDays = availableWeekDays;
    }

    public void addNewImageId(int imageId) {
        imagesId.add(imageId);
    }
}
