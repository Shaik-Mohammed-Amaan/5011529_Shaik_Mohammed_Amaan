package com.example.BookstoreAPI;

import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class BookstoreIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        // Set up initial data in the database
        Book book = new Book();
        Author author = new Author();
        author.setFirstName("abc");
        author.setLastName("def");
        author.setAddress("pqr");
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPrice(19.99);
        book.setAuthor(author);
        bookRepository.save(book);
    }

    @Test
    void testGetBookById() throws Exception {
        Book book = bookRepository.findAll().get(0);

        mockMvc.perform(get("/books/{id}", book.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Test Author"));
    }

    @Test
    void testCreateBook() throws Exception {
        String newBookJson = """
                {
                    "title": "New Book",
                    "author": "New Author",
                    "isbn": "0987654321",
                    "price": 29.99
                }
                """;

        MvcResult result = mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newBookJson))
                .andExpect(status().isCreated())
                .andReturn();

        // Verify that the book is saved to the database
        String responseJson = result.getResponse().getContentAsString();
        Book createdBook = bookRepository.findById(Integer.parseInt(responseJson)).orElseThrow();
        assertThat(createdBook.getTitle()).isEqualTo("New Book");
    }

    @Test
    void testUpdateBook() throws Exception {
        Book book = bookRepository.findAll().get(0);

        String updatedBookJson = """
                {
                    "title": "Updated Book",
                    "author": "Updated Author",
                    "isbn": "1234567890",
                    "price": 29.99
                }
                """;

        mockMvc.perform(put("/books/{id}", book.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBookJson))
                .andExpect(status().isOk());

        // Verify that the book is updated in the database
        Optional<Book> updatedBook = bookRepository.findById(book.getId());
        assertThat(updatedBook).isPresent();
        assertThat(updatedBook.get().getTitle()).isEqualTo("Updated Book");
    }

    @Test
    void testDeleteBook() throws Exception {
        Book book = bookRepository.findAll().get(0);

        mockMvc.perform(delete("/books/{id}", book.getId()))
                .andExpect(status().isNoContent());

        // Verify that the book is deleted from the database
        Optional<Book> deletedBook = bookRepository.findById(book.getId());
        assertThat(deletedBook).isEmpty();
    }
}
