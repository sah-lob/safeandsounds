package ru.sahlob.db;

import org.springframework.data.repository.CrudRepository;
import ru.sahlob.persistance.Logo;

public interface DBLogosRepository extends CrudRepository<Logo, Integer> {

}
