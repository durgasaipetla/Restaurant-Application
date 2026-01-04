package com.res.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	@Column(nullable = false)
	private String itemName;

	private String description;

	@Column(nullable = false)
	private double itemPrice;

	@Column(nullable = false)
	private String itemCategory; // starter, main, dessert, beverage


	public MenuItem() {
	}

	public MenuItem(Long itemId, String name, String description, double price, String category) {
		this.itemId = itemId;
		this.itemName = name;
		this.description = description;
		this.itemPrice = price;
		this.itemCategory = category;
	}


	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
}
