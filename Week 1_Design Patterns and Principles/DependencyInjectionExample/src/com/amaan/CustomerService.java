package com.amaan;

public class CustomerService {
    private CustomerRepositoryImpl customerRepository;

    public CustomerService(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public Customer getCustomerId(int id) {
        return customerRepository.findCustomerById(id);
    }
}
