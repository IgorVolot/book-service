package ait.cohort34.book.dao;

import ait.cohort34.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface BookRepository {

    Stream<Book> findByAuthorsName(String authorName);

    Stream<Book> findByPublisherPublisherName(String name);

    void deleteByAuthorsName(String name);

    boolean existsById(String isbn);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    void deleteById(String isbn);
}
