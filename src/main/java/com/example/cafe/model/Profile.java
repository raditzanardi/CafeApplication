package com.example.cafe.model;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="profiles")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="fullName")
	private String fullName;
	@Column(name="userName")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="password")
	private String password;
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	//==========================================
	//One to Many relationship

	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<CreditCard> creditCards = new HashSet<>();
	


	//==========================================
	// Constructors
	public Profile() {}
	public Profile(String fullName, String userName, String email, String address, String password, String phoneNumber) {

		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public void addCreditCard(CreditCard creditCard) {
		this.creditCards.add(creditCard);
		creditCard.setProfile(this);
	}
		
	public void removeCreditCard(CreditCard creditCard) {
		this.creditCards.remove(creditCard);
		creditCard.setProfile(this);
	}
	//==========================================
	// Getters and Setters

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String name) {
		this.fullName = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public Set<CreditCard> getCreditCards(){
		return creditCards;
	}
	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
}


