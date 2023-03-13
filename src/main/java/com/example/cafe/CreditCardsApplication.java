package com.example.crs;

import java.time.LocalDate;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crs.model.CreditCard;
import com.example.crs.model.CreditCardRepository;

@SpringBootApplication
public class CreditCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardsApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init(CreditCardRepository cCRepo) {
		return args -> {
			cCRepo.save(new CreditCard(/*UserID,*/ "Pablo Zambrano", "123992349874", "237", LocalDate.of(2024, 11, 10),"238 George St, Vancouver, BC"));
			cCRepo.save(new CreditCard(/*UserID,*/ "Leticia Ishiyama", "834765209833", "334", LocalDate.of(2025, 01, 11),"112 Rowe St, Vancouver, BC"));
			cCRepo.save(new CreditCard(/*UserID,*/ "Radit Zanardi", "745362750912", "112", LocalDate.of(2024, 04, 04),"West Palm St, Vancouver, BC"));

			cCRepo.findAll().forEach(System.out::println);
			
			
		};
	}

}
