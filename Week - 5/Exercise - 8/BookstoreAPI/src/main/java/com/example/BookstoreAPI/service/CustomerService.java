package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.mapper.MapStructMapper;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map((customer) -> MapStructMapper.MAPPER.mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(int customerId){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        return MapStructMapper.MAPPER.mapToCustomerDto(customer);
    }

    public void addCustomer(CustomerDTO customerDTO){
        Customer customer = MapStructMapper.MAPPER.mapToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    public void updateCustomer(CustomerDTO customerDTO){
        Customer customer = MapStructMapper.MAPPER.mapToCustomer(customerDTO);
        customerRepository.save(customer);
    }

    public void deleteCustomerById(int customerId){
       customerRepository.deleteById(customerId);
    }
}
