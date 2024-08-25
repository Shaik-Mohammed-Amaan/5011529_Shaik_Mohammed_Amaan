package com.example.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDTO {
    private int id;
    @JsonProperty("book_title")
    private String title;
    private String isbn;
    private double price;
    private int stock;
}
