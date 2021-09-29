package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import ru.sahlob.persistance.client.EmailSecretCode;

public interface EmailSecretCodeRepository extends CrudRepository<EmailSecretCode, Integer> {
    EmailSecretCode findFirstByUuid(String uuid);
}
