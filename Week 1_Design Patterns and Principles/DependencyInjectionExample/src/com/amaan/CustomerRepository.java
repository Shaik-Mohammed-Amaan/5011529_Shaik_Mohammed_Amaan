package com.amaan;

public interface CustomerRepository {
    public void addCustomer(Customer customer);

    public Customer findCustomerById(int id);
}
