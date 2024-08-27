package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookAuthorDTO;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.model.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-25T20:05:44+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public BookDTO mapToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setPrice( book.getPrice() );
        bookDTO.setStock( book.getStock() );

        return bookDTO;
    }

    @Override
    public Book mapToBook(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setTitle( bookDTO.getTitle() );
        book.setIsbn( bookDTO.getIsbn() );
        book.setPrice( bookDTO.getPrice() );
        book.setStock( bookDTO.getStock() );

        return book;
    }

    @Override
    public CustomerDTO mapToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setPhone( customer.getPhone() );
        customerDTO.setEmail( customer.getEmail() );
        customerDTO.setAddress( customer.getAddress() );

        return customerDTO;
    }

    @Override
    public Customer mapToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setPhone( customerDTO.getPhone() );
        customer.setEmail( customerDTO.getEmail() );
        customer.setAddress( customerDTO.getAddress() );

        return customer;
    }

    @Override
    public BookAuthorDTO mapToBookAuthorDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookAuthorDTO bookAuthorDTO = new BookAuthorDTO();

        bookAuthorDTO.setId( book.getId() );
        bookAuthorDTO.setTitle( book.getTitle() );
        bookAuthorDTO.setIsbn( book.getIsbn() );
        bookAuthorDTO.setPrice( book.getPrice() );
        bookAuthorDTO.setStock( book.getStock() );
        bookAuthorDTO.setAuthor( book.getAuthor() );

        return bookAuthorDTO;
    }
}
