package com.amaan;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public Customer findCustomerById(int id) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return new Customer(000, "N/A", "N/A");
    }
}
