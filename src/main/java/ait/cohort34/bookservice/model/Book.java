package ait.cohort34.bookservice.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    Long isbn;
    @Setter
    String title;
    @Setter
    @Embedded
    Author author;
    @Setter
    String publisher;
}
