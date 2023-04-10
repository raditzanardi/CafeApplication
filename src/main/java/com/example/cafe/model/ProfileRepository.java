package com.example.cafe.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	Profile findByFullName (String fullName);
	Optional<Profile> findByUserName (String userName);
	Profile findByEmail (String email);
	Profile findByAddress (String address);
	Profile findByPassword (String password);
	Profile findByPhoneNumber (String phoneNumber);
	Profile findByFullNameContaining (String fullName);
	Boolean existsByUserName (String userName);
}
