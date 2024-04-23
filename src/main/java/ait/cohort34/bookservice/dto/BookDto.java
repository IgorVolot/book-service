package ait.cohort34.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class BookDto {
    Long isbn;
    String title;
    List<AuthorDto> authors;
    String publisher;
}
