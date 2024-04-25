package ait.cohort34.book.dao;

import ait.cohort34.book.model.Publisher;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {
//    @Query("select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name=?1")
    List<String> findByPublishersAuthor(String authorName);

    Optional<Publisher> findById(String publisher);

    Publisher save(Publisher publisher);
}

