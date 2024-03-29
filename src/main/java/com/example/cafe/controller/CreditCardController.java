package com.example.cafe.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.model.CreditCard;
import com.example.cafe.model.CreditCardRepository;
import com.example.cafe.model.Profile;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

	@Autowired
	CreditCardRepository cCRepo;
	/*
	 * @Autowired UserRepository userRepo;
	 */
	
//Add a Credit Card	
	@PostMapping
	public ResponseEntity<CreditCard> addPmtMethod(@RequestBody CreditCard creditCard){
		CreditCard saveCreditCard = cCRepo.save(creditCard);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCreditCard);
	}
	
	
//Get all credit cards	
	@GetMapping("/credit_cards")
	public ResponseEntity<List<CreditCard>> getAllCreditCards(){
		List<CreditCard> creditCards = cCRepo.findAll();
		return new ResponseEntity<>(creditCards, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CreditCard> updateCreditCardById(@PathVariable Long cardId, @RequestBody CreditCard creditCard){
		Optional<CreditCard> optionalCreditCard = cCRepo.findById(cardId);
		if(optionalCreditCard.isPresent()) {
			creditCard.setCardId(cardId);
			CreditCard updatedCreditCard = cCRepo.save(creditCard);
			
			return new ResponseEntity<>(updatedCreditCard, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}

	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void>deleteCreditCardByCardId(@PathVariable Long cardId){
		Optional<CreditCard> optionalCreditCard = cCRepo.findById(cardId);
		if(optionalCreditCard.isPresent()) {
			cCRepo.deleteById(cardId); 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}
		}
	
	

	//finds credit card(s) with the Profile ID
	@GetMapping("/{profileId}")
	public List<CreditCard> findByProfile(@PathVariable Profile profileId){
		return cCRepo.findByProfile(profileId);
		
	}
	
	
	//finds a credit card by cardnumber, cvv, and exp date
//	@GetMapping("/{cardNumber}/{cvv}/expirationDate}")
//	public CreditCard findByCardNumberAndCvvAndExpirationDate(@PathVariable String cardNumber, @PathVariable String cvv, 
//			@PathVariable LocalDate expirationDate){
//		return cCRepo.findByCardNumberAndCvvAndExpirationDate(cardNumber, cvv, expirationDate);
//		
//	}	
//	
	
	//finds a credit card by cardId and profileId
	@GetMapping("/{cardId}/{profileId}")
	public CreditCard findByCardIdAndProfileId(@PathVariable Long cardId, @PathVariable Profile profileId){
		return cCRepo.findByCardIdAndProfileId(cardId, profileId);
		
	}
	
	
	//deletes credit card by card number
	@DeleteMapping("/{cardNumber}")
	public void deleteCardNumber(@PathVariable String cardNumber) {
		cCRepo.deleteByCardNumber(cardNumber);
	}

		
	
	
}






