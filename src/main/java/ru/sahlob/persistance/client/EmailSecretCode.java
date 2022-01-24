package ru.sahlob.persistance.client;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailSecretCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clientId;
    public String uuid;

    public EmailSecretCode(int clientId, String uuid) {
        this.clientId = clientId;
        this.uuid = uuid;
    }
}
