package com.res.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private MenuItem menuItem;

	private int quantity;

	// Constructors
	public OrderItem() {
	}

	public OrderItem(Long id, Order order, MenuItem menuItem, int quantity) {
		this.id = id;
		this.order = order;
		this.menuItem = menuItem;
		this.quantity = quantity;
	}

 	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
