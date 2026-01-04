package com.res.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.res.entity.Order;
import com.res.entity.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByCustomer(User customer); // get orders for a user

}
