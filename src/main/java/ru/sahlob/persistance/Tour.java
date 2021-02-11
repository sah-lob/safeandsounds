package ru.sahlob.persistance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String description;
    private Integer price;
    private Integer coolness;

    public Tour(int imageId, String name, String description, Integer price, Integer coolness) {
        this.imagesId.add(imageId);
        this.name = name;
        this.description = description;
        this.price = price;
        this.coolness = coolness;
    }
}
