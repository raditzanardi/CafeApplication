package com.example.cafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.model.Menu;
import com.example.cafe.model.MenuRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MenuController {
	@Autowired
	MenuRepository menuRepo;
	
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getAllMenu(@RequestParam(required = false)String item, String type){
		try {
			List<Menu> menu = new ArrayList<Menu>();
			if(item == null && type == null) {
				menuRepo.findAll().forEach(menu::add);
			}else {
				menuRepo.findByItem(item).forEach(menu::add);
				menuRepo.findByType(type).forEach(menu::add);
			}
			if(menu.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(menu, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu> getItemById(@PathVariable("id") long id) {
		java.util.Optional<Menu> menuData = menuRepo.findById(id);

		if (menuData.isPresent()) {
			return new ResponseEntity<>(menuData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
