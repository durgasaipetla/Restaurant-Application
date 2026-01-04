package com.res.service;
import java.util.List;

import com.res.entity.MenuItem;

public interface MenuService {
    MenuItem addMenuItem(MenuItem menuItem);
    List<MenuItem> getAllMenuItems();
    List<MenuItem> getMenuByCategory(String category);
}
