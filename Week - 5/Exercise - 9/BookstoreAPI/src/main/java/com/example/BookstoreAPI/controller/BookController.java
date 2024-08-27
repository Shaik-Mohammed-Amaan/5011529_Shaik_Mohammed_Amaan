package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookAuthorDTO;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.exception.BookNotFoundException;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.BookService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable int bookId) {
        BookDTO bookDTO = bookService.getBookById(bookId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Resource", String.valueOf(bookId));
        if (bookDTO != null) {
            EntityModel<BookDTO> bookResource = EntityModel.of(bookDTO);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(bookId)).withSelfRel();
            Link booksLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books");
            bookResource.add(selfLink);
            bookResource.add(booksLink);
            return new ResponseEntity<>(bookResource, headers, HttpStatus.FOUND);
        } else {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }
    }

    @PostMapping("/books")
    public ResponseEntity<BookDTO> addBook(@RequestBody @Valid BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Resource", String.valueOf(bookDTO.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO existingBookDTO = bookService.getBookById(bookDTO.getId());
        bookService.updateBook(bookDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Resource", String.valueOf(bookDTO.getId()));
        headers.add("X-Updation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBookById(@PathVariable int bookId) {
        BookDTO bookDTO = bookService.getBookById(bookId);

        if (bookDTO == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }
        bookService.deleteBookById(bookId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/books/title/{bookTitle}")
    public ResponseEntity<BookDTO> getBookByTitle(@PathVariable String bookTitle) {
        BookDTO bookDTO = bookService.getBookByTitle(bookTitle);
        if (bookDTO != null) {
            return new ResponseEntity<>(bookDTO, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/books/author/{authorName}")
    public ResponseEntity<List<BookDTO>> getBookByAuthorFirstName(@PathVariable String authorName) {
        List<BookDTO> books = bookService.getBookByAuthorFirstName(authorName);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(books, HttpStatus.FOUND);
        }
    }

    @GetMapping("books/authors")
    public ResponseEntity<List<BookAuthorDTO>> getBookAuthor(){
        return new ResponseEntity<>(bookService.getBookAuthor(),HttpStatus.OK);
    }
}
