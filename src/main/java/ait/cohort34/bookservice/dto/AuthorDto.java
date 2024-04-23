package ait.cohort34.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class AuthorDto {
    String name;
    LocalDate birthDate;
}
