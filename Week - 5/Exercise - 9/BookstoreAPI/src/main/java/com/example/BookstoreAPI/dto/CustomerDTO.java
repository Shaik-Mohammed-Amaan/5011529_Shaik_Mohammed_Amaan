package com.example.BookstoreAPI.dto;

import jakarta.persistence.Version;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDTO {
    private int id;

    @NotBlank(message = "Invalid FirstName: Empty firstName")
    @NotNull(message = "Invalid FirstName: FirstName is NULL")
    private String firstName;
    private String lastName;


    @NotNull(message = "Invalid Phone number: Phone number is NULL")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Phone number")
    private String phone;

    @Email(message = "Invalid Email: Provide a valid email address")
    private String email;

    private String address;

}
