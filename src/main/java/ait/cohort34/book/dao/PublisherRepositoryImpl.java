package ait.cohort34.book.dao;

import ait.cohort34.book.model.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository{

    private static final String FIND_BY_PUBLISHERS_AUTHOR_QUERY = "select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name=?1";
    private static final String FIND_DISTINCT_BY_BOOKS_AUTHORS_NAME_QUERY = "select distinct p from Publisher p join p.books b join b.authors a where a.name=?1";

    @PersistenceContext
    EntityManager em;

    @Override
    public List<String> findByPublishersAuthor(String authorName) {
//        TypedQuery<String> query = em.createQuery(FIND_BY_PUBLISHERS_AUTHOR_QUERY, String.class);
//        query.setParameter(1, authorName);
//        return query.getResultList();
        return em.createQuery(FIND_BY_PUBLISHERS_AUTHOR_QUERY, String.class)
                .setParameter(1, authorName)
                .getResultList();
    }

    @Override
    public Stream<Publisher> findDistinctByBooksAuthorsName(String authorName) {
        TypedQuery<Publisher> query = em.createQuery(FIND_DISTINCT_BY_BOOKS_AUTHORS_NAME_QUERY, Publisher.class);
        query.setParameter(1, authorName);
        return query.getResultStream();
    }

    @Override
    public Optional<Publisher> findById(String publisher) {
        return Optional.ofNullable(em.find(Publisher.class, publisher));
    }

    @Override
    public Publisher save(Publisher publisher) {
        em.persist(publisher);
        return publisher;
    }
}