package ru.sahlob.persistance.order;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordersTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uuid;
    private String uuid2;
    private String clientUuid;
    private TourType tourType;
    private String tourDate;
    private String tourName;
    private Integer tourPrice;
    private String comment;
    private int tourId;
    private OrderStatus orderStatus = OrderStatus.created;
    private String performCommunicationMethod;
}
