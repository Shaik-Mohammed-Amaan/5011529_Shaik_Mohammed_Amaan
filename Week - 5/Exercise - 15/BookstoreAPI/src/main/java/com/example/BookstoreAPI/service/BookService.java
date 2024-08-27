package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book getBookByTitle(String bookTitle) {
        return bookRepository.findByTitleIs(bookTitle);
    }

    public List<Book> getBookByAuthorFirstName(String authorName) {
        return bookRepository.findByAuthorFirstName(authorName);
    }
}
