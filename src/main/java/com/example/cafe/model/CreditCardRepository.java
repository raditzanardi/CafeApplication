package com.example.cafe.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	//List<CreditCard> findByUserId(Long userId); 
	
	//CreditCard findByCardNumberAndCvvAndExpirationDate(String cardNumber, String cvv, LocalDate expirationDate);
	
	//CreditCard findByCardIdAndUserId(long cardId/* ,Long userId */);
	
//	void deleteByCardNumber(String cardNumber);
	
//	@Query("INSERT INTO CreditCard (cardHolderName, cardNumber, cvv, expirationDate, billingAddress)" +
//			"VALUES(:cardHolderName, :cardNumber, :cvv, :expirationDate, :billingAddress")

	CreditCard save(CreditCard creditCard);

}
