package com.example.BookstoreAPI.controllerTest;

import com.example.BookstoreAPI.controller.BookController;
import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private Book book;
    private Author author;
    @BeforeEach
    public void setUp() {
        book = new Book(1, "Test Book", "1234567890", 9.99, 10,new Author(101,"abc","def","pqr"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = Arrays.asList(book);
        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(book.getTitle())));
    }

    @Test
    public void testCreateBook() throws Exception {

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Test Book\", \"isbn\": \"1234567890\", \"price\": 9.99, \"stock\": 10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(book.getTitle())));
    }

    @Test
    public void testGetBookById() throws Exception {
        when(bookService.getBookById(anyInt())).thenReturn(book);

        mockMvc.perform(get("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(book.getTitle())));
    }

    @Test
    public void testUpdateBook() throws Exception {

        mockMvc.perform(put("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Updated Book\", \"isbn\": \"1234567890\", \"price\": 9.99, \"stock\": 10}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(book.getTitle())));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
