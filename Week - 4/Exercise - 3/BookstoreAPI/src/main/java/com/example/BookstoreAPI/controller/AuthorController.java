package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable int authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping("/authors")
    public void addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }

    @PutMapping("/authors")
    public void updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthorById(@PathVariable int authorId){
       authorService.deleteAuthorById(authorId);
    }
}
