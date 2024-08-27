package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.CustomerNotFoundException;
import com.example.BookstoreAPI.model.Author;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Get a list of all customers", description = "Retrieve all customers available in the bookstore")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the customers",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Custoemrs not found", content = @Content)
    })
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Customer by ID", description = "Retrieve a Customer by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Customer",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)
    })
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customerId));
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.FOUND);
        } else {
            throw new CustomerNotFoundException("Book with ID " + customerId + " not found");
        }
    }

    //JSON Data
    @Operation(summary = "Create a new customer", description = "Create a new customer and add it to the bookstore")
    @ApiResponse(responseCode = "201", description = "Customer created successfully",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))})
    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        if (customer.getFirstName() == null || customer.getEmail() == null) {
            throw new IllegalArgumentException("Customer First name and email are required");
        }
        customerService.addCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customer.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //Form Data
    @PostMapping(value = "/customers/register/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Customer> registerCustomerForm(@RequestParam("firstName") String firstName,
                                                         @RequestParam("lastName") String lastName,
                                                         @RequestParam("phone") String phone,
                                                         @RequestParam("email") String email,
                                                         @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        customerService.addCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customer.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @Operation(summary = "Update a Customer", description = "Update an existing Customer's details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))}),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)
    })
    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(customer.getId());
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Book with ID " + customer.getId() + " not found");
        }
        customerService.updateCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customer.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @Operation(summary = "Delete a customer", description = "Delete a customer by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found", content = @Content)
    })
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Book with ID " + customerId + " not found");
        }
        customerService.deleteCustomerById(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
