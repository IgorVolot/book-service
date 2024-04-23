package ait.cohort34.bookservice.service;

import ait.cohort34.bookservice.dto.AuthorDto;
import ait.cohort34.bookservice.dto.BookDto;

import java.awt.print.Book;

public interface BookService {
    Boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(Long isbn);

    BookDto removeBook(Long isbn);

    BookDto updateBookTitle(Long isbn, String title);

    BookDto[] findBooksByAuthor(String author);

    BookDto[] findBooksByPublisher(String publisher);

    AuthorDto[] findAuthorsByIsbn(Long isbn);

    String[] findPublisherByAuthor(String author);

    AuthorDto removeAuthor(String author);
}
