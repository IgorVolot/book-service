package ait.cohort34.bookservice.controller;

import ait.cohort34.bookservice.dto.AuthorDto;
import ait.cohort34.bookservice.dto.BookDto;
import ait.cohort34.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("/book")
    public Boolean createBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findBookByIsbn(@PathVariable Long isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto deleteBook(@PathVariable Long isbn) {
        return bookService.removeBook(isbn);
    }

    @PutMapping("/book/{isbn}/title/{title}")
    public BookDto updateBookTitle(@PathVariable Long isbn, @PathVariable String title) {
        return bookService.updateBookTitle(isbn, title);
    }

    @GetMapping("/books/author/{author}")
    public BookDto[] findBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/books/publisher/{publisher}")
    public BookDto[] findBooksByPublisher(@PathVariable String publisher) {
        return bookService.findBooksByPublisher(publisher);
    }

    @GetMapping("/authors/book/{isbn}")
    public AuthorDto[] findAuthorsByIsbn(@PathVariable Long isbn) {
        return bookService.findAuthorsByIsbn(isbn);
    }

    @GetMapping("/publishers/author/{author}")
    public String[] findPublisherByAuthor(@PathVariable String author) {
        return bookService.findPublisherByAuthor(author);
    }

    @DeleteMapping("/author/{author}")
    public AuthorDto removeAuthor(@PathVariable String author) {
        return bookService.removeAuthor(author);
    }
}
