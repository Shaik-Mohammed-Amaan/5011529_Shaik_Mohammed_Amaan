package com.amaan;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer(101, "Ram", "Hyderbad");
        Customer customer2 = new Customer(102, "Suresh", "Bangalore");
        Customer customer3 = new Customer(103, "Ramesh", "Mumbai");
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        //Adding customers to the Repository
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);

        //Retrieving customers through their id
        System.out.println(customerService.getCustomerId(102));
        System.out.println(customerService.getCustomerId(103));
        System.out.println(customerService.getCustomerId(105));
    }
}
