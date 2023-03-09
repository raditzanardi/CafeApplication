package com.example.cafe.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	List<Menu> findByItem (String item);
	List<Menu> findByPrice (double price);
	List<Menu> findAllByIngredientsIn (ArrayList<String> ingredients);
}
