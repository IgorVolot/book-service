package ait.cohort34.bookservice.service;

import ait.cohort34.bookservice.dto.AuthorDto;
import ait.cohort34.bookservice.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Override
    public Boolean addBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto findBookByIsbn(Long isbn) {
        return null;
    }

    @Override
    public BookDto removeBook(Long isbn) {
        return null;
    }

    @Override
    public BookDto updateBookTitle(Long isbn, String title) {
        return null;
    }

    @Override
    public BookDto[] findBooksByAuthor(String author) {
        return new BookDto[0];
    }

    @Override
    public BookDto[] findBooksByPublisher(String publisher) {
        return new BookDto[0];
    }

    @Override
    public AuthorDto[] findAuthorsByIsbn(Long isbn) {
        return new AuthorDto[0];
    }

    @Override
    public String[] findPublisherByAuthor(String author) {
        return new String[0];
    }

    @Override
    public AuthorDto removeAuthor(String author) {
        return null;
    }
}
