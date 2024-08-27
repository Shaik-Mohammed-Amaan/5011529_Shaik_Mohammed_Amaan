package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.BookNotFoundException;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        Book book = bookService.getBookById(bookId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Resource", String.valueOf(bookId));
        if (book != null) {
            return new ResponseEntity<>(book, headers, HttpStatus.FOUND);
        } else {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (book.getIsbn() == null || book.getTitle() == null) {
            throw new IllegalArgumentException("Title and ISBN number are required");
        }
        bookService.addBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Resource", String.valueOf(book.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book existingBook = bookService.getBookById(book.getId());

        if (existingBook == null) {
            throw new BookNotFoundException("Book with ID " + book.getId() + " not found");
        }
        bookService.updateBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Resource", String.valueOf(book.getId()));
        headers.add("X-Updation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBookById(@PathVariable int bookId) {
        Book book = bookService.getBookById(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }
        bookService.deleteBookById(bookId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/title/{bookTitle}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String bookTitle) {
        Book book = bookService.getBookByTitle(bookTitle);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books/author/{authorName}")
    public ResponseEntity<List<Book>> getBookByAuthorFirstName(@PathVariable String authorName) {
        List<Book> books = bookService.getBookByAuthorFirstName(authorName);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }
    }
}
