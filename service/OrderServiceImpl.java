package com.res.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.res.entity.Order;
import com.res.entity.User;
import com.res.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository or;

    public OrderServiceImpl(OrderRepository or) {
        this.or = or;
    }

    @Override
    public Order placeOrder(Order order) {
        return or.save(order);
    }

    @Override
    public List<Order> getOrdersByUser(User customer) {
        return or.findByCustomer(customer);
    }

    @Override
    public Order updateOrderStatus(Long orderId, String status) {
        Optional<Order> orderOpt = or.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setStatus(status);
            return or.save(order);
        }
        return null;
    }

}
