package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.dto.BookAuthorDTO;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.MapStructMapper;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map((book)-> MapStructMapper.MAPPER.mapToBookDto(book))
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(int bookId) {
        Book book =  bookRepository.findById(bookId).orElse(null);
        return MapStructMapper.MAPPER.mapToBookDto(book);
    }

    public void addBook(BookDTO bookDTO) {
        Book book = MapStructMapper.MAPPER.mapToBook(bookDTO);
        bookRepository.save(book);
    }

    public void updateBook(BookDTO bookDTO) {
        Book book = MapStructMapper.MAPPER.mapToBook(bookDTO);
        bookRepository.save(book);
    }

    public void deleteBookById(int bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookDTO getBookByTitle(String bookTitle) {
        Book book = bookRepository.findByTitleIs(bookTitle);
        return MapStructMapper.MAPPER.mapToBookDto(book);
    }

    public List<BookDTO> getBookByAuthorFirstName(String authorName) {
        List<Book> books = bookRepository.findByAuthorFirstName(authorName);
        return books.stream()
                .map((book)-> MapStructMapper.MAPPER.mapToBookDto(book))
                .collect(Collectors.toList());
    }

    public List<BookAuthorDTO> getBookAuthor(){
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map((book)->MapStructMapper.MAPPER.mapToBookAuthorDto(book))
                .collect(Collectors.toList());
    }
}
