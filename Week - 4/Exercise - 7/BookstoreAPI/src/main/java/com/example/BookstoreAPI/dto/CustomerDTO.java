package com.example.BookstoreAPI.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
}
