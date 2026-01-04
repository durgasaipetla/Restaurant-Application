package com.res.controller;

import org.springframework.web.bind.annotation.*;

import com.res.entity.Order;
import com.res.entity.User;
import com.res.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Place new order
    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    // Get orders by user
    @GetMapping("/user")
    public List<Order> getOrdersByUser(@RequestBody User user) {
        return orderService.getOrdersByUser(user);
    }

    // Update order status (Admin)
    @PutMapping("/update/{orderId}")
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}
