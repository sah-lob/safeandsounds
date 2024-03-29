package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sahlob.persistance.Logo;

@Repository
public interface DBLogosRepository extends CrudRepository<Logo, Integer> {
}
