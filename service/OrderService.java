package com.res.service;

import java.util.List;

import com.res.entity.Order;
import com.res.entity.User;

public interface OrderService {
	Order placeOrder(Order order);
    List<Order> getOrdersByUser(User customer);
    Order updateOrderStatus(Long orderId, String status);
}
