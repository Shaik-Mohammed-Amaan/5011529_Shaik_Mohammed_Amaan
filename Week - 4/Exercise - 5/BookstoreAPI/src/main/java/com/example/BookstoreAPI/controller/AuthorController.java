package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.AuthorService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return new ResponseEntity<>(authorService.getAllAuthors(),HttpStatus.OK);
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int authorId){
        Author author = authorService.getAuthorById(authorId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Author-Resource", String.valueOf(author.getId()));
        if(author != null){
            return new ResponseEntity<>(author,headers,HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Author-Resource", String.valueOf(author.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers,HttpStatus.OK);
    }

    @PutMapping("/authors")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        authorService.updateAuthor(author);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Author-Resource", String.valueOf(author.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers,HttpStatus.OK);
    }

    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<Author> deleteAuthorById(@PathVariable int authorId){
       authorService.deleteAuthorById(authorId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
