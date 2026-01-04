package com.res.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.res.entity.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByItemCategory(String category); // filter by category

	
}
