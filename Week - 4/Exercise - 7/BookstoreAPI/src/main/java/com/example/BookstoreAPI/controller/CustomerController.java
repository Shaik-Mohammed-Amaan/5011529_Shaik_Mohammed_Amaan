package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.CustomerDTO;
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
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customerId));
        if (customerDTO != null) {
            return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);
        } else {
            throw new CustomerNotFoundException("Book with ID " + customerId + " not found");
        }
    }

    //JSON Data
    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getFirstName() == null || customerDTO.getEmail() == null) {
            throw new IllegalArgumentException("Customer First name and email are required");
        }
        customerService.addCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customerDTO.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //Form Data
    @PostMapping(value = "/customers/register/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<CustomerDTO> registerCustomerForm(@RequestParam("firstName") String firstName,
                                                         @RequestParam("lastName") String lastName,
                                                         @RequestParam("phone") String phone,
                                                         @RequestParam("email") String email,
                                                         @RequestParam("address") String address) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(firstName);
        customerDTO.setLastName(lastName);
        customerDTO.setPhone(phone);
        customerDTO.setEmail(email);
        customerDTO.setAddress(address);
        customerService.addCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customerDTO.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO existingCustomerDTO = customerService.getCustomerById(customerDTO.getId());
        if (existingCustomerDTO == null) {
            throw new CustomerNotFoundException("Book with ID " + customerDTO.getId() + " not found");
        }
        customerService.updateCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Customer-Resource", String.valueOf(customerDTO.getId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<CustomerDTO> deleteCustomerById(@PathVariable int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        if (customerDTO == null) {
            throw new CustomerNotFoundException("Book with ID " + customerId + " not found");
        }
        customerService.deleteCustomerById(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
