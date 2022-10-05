package vlad.skiba.spring5.webapp.repositories;

import vlad.skiba.spring5.webapp.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright Vlad Skiba (c) 2022.
 */
@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
