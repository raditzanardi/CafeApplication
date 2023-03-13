package com.example.cafe;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cafe.model.CreditCard;
import com.example.cafe.model.CreditCardRepository;
import com.example.cafe.model.Menu;
import com.example.cafe.model.MenuRepository;
import com.example.cafe.model.ProfileRepository;
import com.example.cafe.model.Profile;

@SpringBootApplication
public class CafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(MenuRepository menuRepo, ProfileRepository profileRepo,CreditCardRepository cCRepo) {
		return args -> {
			
			ArrayList<String> ingredients1 = new ArrayList<String>();
			 ingredients1.add("Coffee");
			 
			 ArrayList<String> ingredients2 = new ArrayList<String>();
			 ingredients2.add("Milk");
			 ingredients2.add("Syrup");
			 ingredients2.add("Espresso");
			 ingredients2.add("Caramel");
			 
			 ArrayList<String> ingredients3 = new ArrayList<String>();
			 ingredients3.add("Milk");
			 ingredients3.add("Espresso"); 
			
			 ArrayList<String> ingredients4 = new ArrayList<String>();
			 ingredients4.add("White bread");
			 ingredients4.add("Butter"); 
			 ingredients4.add("Ham slices"); 
			 ingredients4.add("Cheese"); 
			 ingredients4.add("Hot sauce"); 
			 
			menuRepo.save(new Menu("Black Coffee", 1.99, "Beverage", ingredients1 ));
			menuRepo.save(new Menu("Caramel Macchiato", 5.99, "Beverage", ingredients2));
			menuRepo.save(new Menu("Latte", 3.99, "Beverage", ingredients3));
			menuRepo.save(new Menu("Ham Sandwich", 6.99, "Food", ingredients4));
			
			profileRepo.save(new Profile("profile1 full name", "profile1", "email@email.com", "123 street", "123456", "123-456-7890"));
			profileRepo.save(new Profile("profile2 full name", "profile2", "email@email.com", "123 street", "123456", "123-456-7890"));


			cCRepo.save(new CreditCard("Pablo Zambrano", "123992349874", "237", LocalDate.of(2024, 11, 10),"238 George St, Vancouver, BC", null));
			cCRepo.save(new CreditCard("Leticia Ishiyama", "834765209833", "334", LocalDate.of(2025, 01, 11),"112 Rowe St, Vancouver, BC",null));
			cCRepo.save(new CreditCard("Radit Zanardi", "745362750912", "112", LocalDate.of(2024, 04, 04),"West Palm St, Vancouver, BC",null));


			menuRepo.findAll().forEach(System.out::println);
			profileRepo.findAll().forEach(System.out::println);
			cCRepo.findAll().forEach(System.out::println);


			
		
		};
	}

}
