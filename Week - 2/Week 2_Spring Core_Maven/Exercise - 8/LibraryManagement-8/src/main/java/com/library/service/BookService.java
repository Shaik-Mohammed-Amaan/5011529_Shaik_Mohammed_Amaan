package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book getBookById(int id){
        return bookRepository.getBookById(id);
    }

    public void addBook(Book book){
        bookRepository.addBook(book);
    }

    public void updateBook(Book book){
        bookRepository.updateBook(book);
    }

    public void deleteBook(int id){
        bookRepository.deleteBook(id);
    }


}
