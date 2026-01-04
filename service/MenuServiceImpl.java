package com.res.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.res.entity.MenuItem;
import com.res.repository.MenuRepository;


@Service
public class MenuServiceImpl implements MenuService {
	private final MenuRepository mr;

	public MenuServiceImpl(MenuRepository mr) {
		this.mr = mr;
	}

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		return mr.save(menuItem);
	}

	@Override
	public List<MenuItem> getAllMenuItems() {
		return mr.findAll();
	}

	@Override
	public List<MenuItem> getMenuByCategory(String category) {
		return mr.findByItemCategory(category);
	}

}
