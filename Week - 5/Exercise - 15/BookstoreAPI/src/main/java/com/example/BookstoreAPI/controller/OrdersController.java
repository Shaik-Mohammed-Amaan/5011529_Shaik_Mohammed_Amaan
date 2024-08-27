package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.exception.OrderNotFoundException;
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
            throw new OrderNotFoundException("Order with ID" + orderId + " not found");
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
        if (order.getBookId() == 0 || order.getCustomerId() == 0) {
            throw new IllegalArgumentException("BookId and CustomerId is required");
        }
        ordersService.addOrder(order);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Orders-Resource", String.valueOf(order.getOrderId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PutMapping("/orders")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
        Orders existingOrder = ordersService.getOrderById(order.getOrderId());
        if (existingOrder == null) {
            throw new OrderNotFoundException("Order with ID" + order.getOrderId() + " not found");
        }
        ordersService.updateOrder(order);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Orders-Resource", String.valueOf(order.getOrderId()));
        headers.add("X-Creation-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Orders> deleteOrderById(@PathVariable int orderId) {
        Orders order = ordersService.getOrderById(orderId);
        if (order == null) {
            throw new OrderNotFoundException("Order with ID" + orderId + " not found");
        }
        ordersService.deleteOrderById(orderId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Deletion-Time", Long.toString(System.currentTimeMillis()));
        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
}
