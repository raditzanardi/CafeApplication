package com.example.cafe.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	List<CreditCard> findByProfile(Profile profile); 
	
	CreditCard findByCardNumberAndCvvAndExpirationDate(String cardNumber, String cvv, LocalDate expirationDate);
	
	CreditCard findByCardIdAndProfileId(Long cardId,Profile profile);
	
	Long deleteByCardNumber(String cardNumber);
	
	CreditCard save(CreditCard creditCard);

}


