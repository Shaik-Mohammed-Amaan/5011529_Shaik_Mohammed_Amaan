package com.library.repository;

import com.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> books = new ArrayList<>(Arrays.asList(new Book(123, "Adventures of Tom Sawyer", "Mark Twain"),
            new Book(124, "Alice in Wonderland", "Lewis Carrol"),
            new Book(126, "Gulliver’s Travels", "Jonathan Swift"),
            new Book(125, "A passage to India", "E.M.Forster"),
            new Book(128, "Discovery of India", "Pandit Jawaharlal Nehru")));

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBook(Book book) {
        int index = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == book.getBookId()) {
                index = i;
                break;
            }
        }
        books.set(index, book);
    }

    public void deleteBook(int id) {
        int index = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == id) {
                index = i;
                break;
            }
        }
        books.remove(index);
    }

}
