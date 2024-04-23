package ait.cohort34.bookservice.service;

import ait.cohort34.bookservice.dto.BookDto;

import java.awt.print.Book;

public interface BookService {
    Book addBook(Book book);
    BookDto findBookByIsbn(Long isbn);

}
