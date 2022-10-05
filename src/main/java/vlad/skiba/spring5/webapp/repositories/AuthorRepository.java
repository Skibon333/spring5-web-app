package vlad.skiba.spring5.webapp.repositories;

import vlad.skiba.spring5.webapp.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright Vlad Skiba (c) 2022.
 */
@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
