package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Orders;
import com.example.BookstoreAPI.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/orders")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Orders getCustomerById(@PathVariable int orderId){
        return ordersService.getOrderById(orderId);
    }

    @PostMapping("/orders")
    public void addOrder(@RequestBody Orders order){
        ordersService.addOrder(order);
    }

    @PutMapping("/orders")
    public void updateOrder(@RequestBody Orders order){
        ordersService.updateOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrderById(@PathVariable int orderId){
        ordersService.deleteOrderById(orderId);
    }
}
