package ait.cohort34.book.dao;

import ait.cohort34.book.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final String QUERY_SELECT_BOOK_BY_AUTHOR_NAME = "SELECT b FROM Book b JOIN b.authors a WHERE a.name = :name";
    private static final String QUERY_SELECT_BOOK_BY_PUBLISHER_NAME = "SELECT b FROM Book b WHERE b.publisher.publisherName = :name";
    private static final String QUERY_DELETE_BY_AUTHOR_NAME = "DELETE FROM Book b WHERE b IN (SELECT b1 FROM Book b1 JOIN b1.authors a WHERE a.name = :name)";

    @PersistenceContext
    EntityManager em;

    @Override
    public Stream<Book> findByAuthorsName(String authorName) {
        return getResultStreamForQueryWithParameter(QUERY_SELECT_BOOK_BY_AUTHOR_NAME, authorName);
    }

    @Override
    public Stream<Book> findByPublisherPublisherName(String name) {
        return getResultStreamForQueryWithParameter(QUERY_SELECT_BOOK_BY_PUBLISHER_NAME, name);
    }

    @Override
    public void deleteByAuthorsName(String name) {
        Query query = em.createQuery(QUERY_DELETE_BY_AUTHOR_NAME);
        query.setParameter("name", name);
        query.executeUpdate();
    }

    @Override
    public boolean existsById(String isbn) {
        return em.find(Book.class, isbn) != null;
    }

    @Override
    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(em.find(Book.class, isbn));
    }

    @Override
    public void deleteById(String isbn) {
        em.remove(em.find(Book.class, isbn));
    }

    private Stream<Book> getResultStreamForQueryWithParameter(String query, String parameter) {
        TypedQuery<Book> typedQuery = em.createQuery(query, Book.class);
        typedQuery.setParameter("name", parameter);
        return typedQuery.getResultStream();
    }
}
