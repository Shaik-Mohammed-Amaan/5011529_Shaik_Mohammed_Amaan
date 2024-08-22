package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBookById(@PathVariable int bookId){
        bookService.deleteBookById(bookId);
    }

    @GetMapping("/books/title/{bookTitle}")
    public Book getBookByTitle(@PathVariable String bookTitle){
        return bookService.getBookByTitle(bookTitle);
    }

    @GetMapping("/books/author/{authorName}")
    public List<Book> getBookByAuthorFirstName(@PathVariable String authorName) {
        return bookService.getBookByAuthorFirstName(authorName);
    }
}
