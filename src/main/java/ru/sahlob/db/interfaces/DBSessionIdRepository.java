package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.sessionid.SessionId;

import java.util.List;

@Repository
public interface DBSessionIdRepository extends CrudRepository<SessionId, Integer> {
    List<SessionId> findAll();
}
