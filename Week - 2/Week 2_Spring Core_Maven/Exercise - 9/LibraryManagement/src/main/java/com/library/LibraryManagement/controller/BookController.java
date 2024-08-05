package com.library.LibraryManagement.controller;

import com.library.LibraryManagement.model.Book;
import com.library.LibraryManagement.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{bookid}")
    public Book getBookById(@PathVariable int bookid) {
        return service.getBookById(bookid);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        service.addBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book) {
        service.updateBook(book);
    }

    @DeleteMapping("/books/{bookid}")
    public void deleteProduct(@PathVariable int bookid) {
        service.deleteBookById(bookid);
    }

}
