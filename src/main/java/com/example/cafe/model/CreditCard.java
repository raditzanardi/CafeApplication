	package com.example.cafe.model;
	
	import java.time.LocalDate;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.FetchType;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
	
	//Users class is being defined by Leticia
	@Entity
	@Table(name = "credit_cards")
	public class CreditCard {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long cardId;
	
	
	
		@Column(name = "card_holder_name")
		private String cardHolderName;
	
		@Column(name = "card_number")
		private String cardNumber;
	
		@Column(name = "cvv")
		private String cvv;
	
		@Column(name = "expiration_date")
		private LocalDate expirationDate;
	
		@Column(name = "billing_address")
		private String billingAddress;
		
		
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "profileid")
		private Profile profile;
		 
		
		
	
		public CreditCard() {
	
		}
	
		public CreditCard(String cardHolderName, String cardNumber, String cvv, LocalDate expirationDate,
				String billingAddress, Profile profile) {
			this.cardHolderName = cardHolderName;
			this.cardNumber = cardNumber;
			this.cvv = cvv;
			this.expirationDate = expirationDate;
			this.billingAddress = billingAddress;
			this.profile = profile;
		}
	
		public long getCardId() {
			return cardId;
		}
	
		public void setCardId(long cardId) {
			this.cardId = cardId;
		}
	

		public String getCardHolderName() {
			return cardHolderName;
		}
	
		public void setCardHolderName(String cardHolderName) {
			this.cardHolderName = cardHolderName;
		}
	
		public String getCardNumber() {
			return cardNumber;
		}
	
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
	
		public String getCvv() {
			return cvv;
		}
	
		public void setCvv(String cvv) {
			this.cvv = cvv;
		}
	
		public LocalDate getExpirationDate() {
			return expirationDate;
		}
	
		public void setExpirationDate(LocalDate expirationDate) {
			this.expirationDate = expirationDate;
		}
	
		public String getBillingAddress() {
			return billingAddress;
		}
	
		public void setBillingAddress(String billingAddress) {
			this.billingAddress = billingAddress;
		}
		
		
		public Profile getProfile() {
			return profile;
		}
		
		public void setProfile(Profile profile) {
			this.profile = profile;
		}
	
	}

	
	
	
	
	