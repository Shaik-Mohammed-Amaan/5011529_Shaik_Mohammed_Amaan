package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Orders;
import com.example.BookstoreAPI.service.OrdersService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        return new ResponseEntity<>(ordersService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Orders> getCustomerById(@PathVariable int orderId) {
        Orders order = ordersService.getOrderById(orderId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Orders-Resource", String.valueOf(orderId));
        if (order != null) {
            return new ResponseEntity<>(order, headers, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
        ordersService.addOrder(order);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Orders-Resource", String.valueOf(order.getOrderId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers,HttpStatus.OK);
    }

    @PutMapping("/orders")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
        ordersService.updateOrder(order);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Orders-Resource", String.valueOf(order.getOrderId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers,HttpStatus.OK);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Orders> deleteOrderById(@PathVariable int orderId) {
        ordersService.deleteOrderById(orderId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
