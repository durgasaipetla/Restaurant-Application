package com.res.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.res.entity.Order;
import com.res.entity.OrderItem;
import com.res.entity.User;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
