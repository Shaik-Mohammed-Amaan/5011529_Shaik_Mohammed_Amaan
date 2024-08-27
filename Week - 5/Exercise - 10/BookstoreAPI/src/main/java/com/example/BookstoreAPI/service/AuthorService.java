package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(int authorId){
        return authorRepository.findById(authorId).orElse(null);
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthorById(int authorId){
        authorRepository.deleteById(authorId);
    }
}
