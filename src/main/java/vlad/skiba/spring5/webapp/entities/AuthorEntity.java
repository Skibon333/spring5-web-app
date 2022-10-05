package vlad.skiba.spring5.webapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright Vlad Skiba (c) 2022.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "books")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<BookEntity> books = new HashSet<>();

}
