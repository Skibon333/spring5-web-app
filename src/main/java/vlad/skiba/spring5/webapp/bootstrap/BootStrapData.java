package vlad.skiba.spring5.webapp.bootstrap;

import vlad.skiba.spring5.webapp.entities.AuthorEntity;
import vlad.skiba.spring5.webapp.entities.BookEntity;
import vlad.skiba.spring5.webapp.entities.PublisherEntity;
import vlad.skiba.spring5.webapp.repositories.AuthorRepository;
import vlad.skiba.spring5.webapp.repositories.BookRepository;
import vlad.skiba.spring5.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright Vlad Skiba (c) 2022.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Started in Bootstrap");

        PublisherEntity publisher = new PublisherEntity();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        AuthorEntity eric = new AuthorEntity("Eric", "Evans");
        BookEntity ddd = new BookEntity("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        AuthorEntity rod = new AuthorEntity("Rod", "Johnson");
        BookEntity noEJB = new BookEntity("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }

}
