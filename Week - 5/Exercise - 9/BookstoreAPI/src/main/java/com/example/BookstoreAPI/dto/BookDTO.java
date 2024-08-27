package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Version;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BookDTO {

    private int id;

    @NotBlank(message = "Invalid Title: Empty title")
    @NotNull(message = "Invalid Title: Title is NULL")
    @Size(min = 1,message = "Invalid Title: Must be of atleast 1 character")
    @JsonProperty("book_title")
    private String title;

    @NotNull(message = "Invalid ISBN: ISBN is NULL")
    @Pattern(regexp = "^\\d{13}$", message = "Invalid ISBN number")
    private String isbn;

    @Min(value = 0, message = "Invalid Price: Price must be positive")
    private double price;

    @Min(value = 0, message = "Invalid Stock: Stock must be positive")
    private int stock;

}
