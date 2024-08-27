package com.example.BookstoreAPI.service;

import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.model.Orders;
import com.example.BookstoreAPI.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    public Orders getOrderById(int ordersId){
        return ordersRepository.findById(ordersId).orElse(null);
    }

    public void addOrder(Orders order){
        ordersRepository.save(order);
    }

    public void updateOrder(Orders order){
        ordersRepository.save(order);
    }

    public void deleteOrderById(int orderId){
        ordersRepository.deleteById(orderId);
    }
}
