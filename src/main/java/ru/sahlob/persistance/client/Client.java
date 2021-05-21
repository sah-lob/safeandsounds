package ru.sahlob.persistance.client;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.sahlob.persistance.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uuid;
    private String firstName;
    private String phone;
    private String email;
    private String whatsAppPhone;
    private String telegramPhone;
    private String instagramAccount;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();


    public Client(String firstName, String phone, String email) {
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
    }
}
