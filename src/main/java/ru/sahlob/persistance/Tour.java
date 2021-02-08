package ru.sahlob.persistance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer imageId;
    private String name;
    private String description;
    private Integer price;
    private Integer coolness;

    public Tour(int imageId, String name, String description, Integer price, Integer coolness) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.coolness = coolness;
    }
}
