package com.example.BookstoreAPI.dto;

import com.example.BookstoreAPI.model.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;

@Data
public class BookAuthorDTO {


    private int id;
    private String title;
    @JsonIgnore
    private String isbn;
    @JsonIgnore
    private double price;
    @JsonIgnore
    private int stock;
    @JsonUnwrapped
    private Author author;
}
