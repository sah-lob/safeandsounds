package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import ru.sahlob.persistance.sessionid.SessionId;

import java.util.List;

public interface DBSessionIdRepository extends CrudRepository<SessionId, Integer> {
    List<SessionId> findAll();
}
