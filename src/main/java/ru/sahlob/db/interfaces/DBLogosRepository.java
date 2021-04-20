package ru.sahlob.db.interfaces;

import org.springframework.data.repository.CrudRepository;
import ru.sahlob.persistance.Logo;

public interface DBLogosRepository extends CrudRepository<Logo, Integer> {

}
