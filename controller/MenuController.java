package com.res.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.res.entity.MenuItem;
import com.res.repository.MenuRepository;
import com.res.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
    private final MenuService ms;

    public MenuController(MenuService menuService) {
        this.ms = menuService;
    }

    // Add new menu item (Admin only)
    @PostMapping("/add")
    public ResponseEntity<String> addMenuItem(@RequestBody MenuItem menuItem) {
    	ms.addMenuItem(menuItem);
    	return ResponseEntity.ok("Menu added successfully");
    }

    // Get all menu items
    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return ms.getAllMenuItems();
    }

    // Get menu items by category
    @GetMapping("/category/{category}")
    public List<MenuItem> getMenuByCategory(@PathVariable String category) {
        return ms.getMenuByCategory(category);
    }
}

