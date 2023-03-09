package com.example.cafe;

import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cafe.model.Menu;
import com.example.cafe.model.MenuRepository;

@SpringBootApplication
public class CafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}
	
	
	
	@Bean
	ApplicationRunner init(MenuRepository menuRepo) {
		return args -> {
			
			ArrayList<String> ingredients1 = new ArrayList<String>();
			 ingredients1.add("Coffee");
			 
			 ArrayList<String> ingredients2 = new ArrayList<String>();
			 ingredients2.add("Milk");
			 ingredients2.add("Syrup");
			 ingredients2.add("Espresso");
			 ingredients2.add("Caramel sauce");
			 
			 ArrayList<String> ingredients3 = new ArrayList<String>();
			 ingredients3.add("Milk");
			 ingredients3.add("Espresso"); 
			
			 ArrayList<String> ingredients4 = new ArrayList<String>();
			 ingredients4.add("White bread");
			 ingredients4.add("Butter"); 
			 ingredients4.add("Ham slices"); 
			 ingredients4.add("Ceese"); 
			 ingredients4.add("Hot sauce"); 
			 
			menuRepo.save(new Menu("Black Coffee", 1.99, ingredients1 ));
			menuRepo.save(new Menu("Caramel Macchiato", 5.99, ingredients2));
			menuRepo.save(new Menu("Latte", 3.99, ingredients3));
			menuRepo.save(new Menu("Ham Sandwich", 6.99, ingredients4));
			
			menuRepo.findAll().forEach(System.out::println);
		};
	}

}
