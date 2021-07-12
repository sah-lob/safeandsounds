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
    private Integer economyPrice;
    private Integer groupPrice;
    private Integer premiumPrice;
    private Integer coolness;
    @ElementCollection
    private Set<Integer> availableWeekDays;
    private String duration;
    @Transient
    private boolean likedByPerson;

    public Tour(int imageId,
                String name,
                String description,
                Integer economyPrice,
                Integer groupPrice,
                Integer premiumPrice,
                Integer coolness,
                Set<Integer> availableWeekDays,
                String duration) {
        this.imagesId.add(imageId);
        this.name = name;
        this.description = description;
        this.economyPrice = economyPrice;
        this.groupPrice = groupPrice;
        this.premiumPrice = premiumPrice;
        this.coolness = coolness;
        this.availableWeekDays = availableWeekDays;
        this.duration = duration;
    }

    public void addNewImageId(int imageId) {
        imagesId.add(imageId);
    }
}
