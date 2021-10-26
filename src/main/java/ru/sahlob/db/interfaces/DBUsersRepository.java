package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.client.Client;

@Repository
public interface DBUsersRepository extends CrudRepository<Client, Integer> {

    Client findByPhone(String phone);

    Client findByEmail(String email);

    Client findByUuid(String uuid);

    Client findByFirstName(String username);
}
