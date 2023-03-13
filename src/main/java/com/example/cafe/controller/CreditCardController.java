package com.example.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crs.model.CreditCard;
import com.example.crs.model.CreditCardRepository;

@CrossOrigin(origins="http:localhost:8081")
@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

	@Autowired
	CreditCardRepository cCRepo;
	/*
	 * @Autowired UserRepository userRepo;
	 */
	
	
	@PostMapping
	public ResponseEntity<CreditCard> addPmtMethod(@RequestBody CreditCard creditCard){
		CreditCard saveCreditCard = cCRepo.save(creditCard);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCreditCard);
	}
	
//	
//	@GetMapping("/{userId}")
//	public ResponseEntity<List<CreditCard>> getCreditCardsForUser(@PathVariable Long userId){
//		List<CreditCard> creditCards = cCRepo.findByUserId(userId);
//		return new ResponseEntity<>(creditCards, HttpStatus.OK);
//	}
//	
	
//	@GetMapping("/{cardId}/{userId}")
//	public ResponseEntity<CreditCard> getCreditCardForUser(@PathVariable Long cardId, @PathVariable Long userId){
//		CreditCard creditCard = cCRepo.findByCardIdAndUserId(cardId, userId);
//		if(creditCard != null) {
//			return new ResponseEntity<>(creditCard, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}	
//	}
	
	
	/*
	 * 
	 * 
	 * @DeleteMapping("/{cardNumber}") public ResponseEntity<Void>
	 * deleteCreditCard(@PathVariable String cardNumber){
	 * cCRepo.deleteByCardNumber(cardNumber); return new
	 * ResponseEntity<>(HttpStatus.NO_CONTENT);
	 * 
	 * }
	 */
	
		
	
	
}
