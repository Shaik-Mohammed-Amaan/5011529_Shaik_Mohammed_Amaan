package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.CustomerNotFoundException;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.service.CustomerService;
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

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

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
