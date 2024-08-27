package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.AuthorNotFoundException;
import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Operation(summary = "Get a list of all authors", description = "Retrieve all authors available in the bookstore")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the authors",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Author.class))}),
            @ApiResponse(responseCode = "404", description = "Authors not found", content = @Content)
    })
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Author by ID", description = "Retrieve a author by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the author",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Author.class))}),
            @ApiResponse(responseCode = "404", description = "Author not found", content = @Content)
    })
    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int authorId) {
        Author author = authorService.getAuthorById(authorId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Author-Resource", String.valueOf(authorId));
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + authorId + " not found");

        } else {
            return new ResponseEntity<>(author, headers, HttpStatus.FOUND);
        }
    }

    @Operation(summary = "Create a new author", description = "Create a new author and add it to the bookstore")
    @ApiResponse(responseCode = "201", description = "Author created successfully",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Author.class))})
    @PostMapping("/authors")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        if (author.getFirstName() == null) {
            throw new IllegalArgumentException("Author first name is required");
        }
        authorService.addAuthor(author);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Author-Resource", String.valueOf(author.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @Operation(summary = "Update a author", description = "Update an existing author's details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author updated successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Author.class))}),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content)
    })
    @PutMapping("/authors")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        Author existingAuthor = authorService.getAuthorById(author.getId());
        if (existingAuthor == null) {
            throw new AuthorNotFoundException("Author with ID " + author.getId() + " not found");
        }
        authorService.updateAuthor(author);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Author-Resource", String.valueOf(author.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @Operation(summary = "Delete a author", description = "Delete a author by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found", content = @Content)
    })
    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<Author> deleteAuthorById(@PathVariable int authorId) {
        Author author = authorService.getAuthorById(authorId);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + authorId + " not found");
        }
        authorService.deleteAuthorById(authorId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
