package com.example.cafe.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	List<Profile> findByFullName (String fullName);
	List<Profile> findByUserName (String userName);
	List<Profile> findByEmail (String email);
	List<Profile> findByAddress (String address);
	List<Profile> findByPassword (String password);
	List<Profile> findByPhoneNumber (String phoneNumber);
	List<Profile> findByFullNameContaining (String fullName);
}
