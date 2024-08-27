package com.example.BookstoreAPI.mapper;

import com.example.BookstoreAPI.dto.BookAuthorDTO;
import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    MapStructMapper MAPPER = Mappers.getMapper(MapStructMapper.class);

    BookDTO mapToBookDto(Book book);

    Book mapToBook(BookDTO bookDTO);

    CustomerDTO mapToCustomerDto(Customer customer);

    Customer mapToCustomer(CustomerDTO customerDTO);

    BookAuthorDTO mapToBookAuthorDto(Book book);

}
