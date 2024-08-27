package com.example.BookstoreAPI.repository;

import com.example.BookstoreAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByTitleIs(String bookTitle);
    List<Book> findByAuthorFirstName(String authorName);
}
