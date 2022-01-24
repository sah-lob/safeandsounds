package ru.sahlob.persistance.client;

import lombok.*;
import ru.sahlob.persistance.order.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer imageId = -1;
    private String uuid;
    private String firstName;
    private String password;
    private boolean active;
    private String phone;
    private String email;
    private String communicationMethod;
    private String whatsAppPhone;
    private String telegramPhone;
    private String instagramAccount = "";
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @ElementCollection(targetClass = ClientRoles.class, fetch = FetchType.EAGER)
    private Set<ClientRoles> roles;

    @ElementCollection
    private Set<Integer> likedToursId;

    public Client(String firstName, String phone, String email) {
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
    }

    public void addNewOrder(Order order) {
        orders.add(order);
    }
}
