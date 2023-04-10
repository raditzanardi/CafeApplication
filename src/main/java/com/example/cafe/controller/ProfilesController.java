package com.example.cafe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.model.CreditCard;
import com.example.cafe.model.Profile;
import com.example.cafe.model.ProfileRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProfilesController {
	@Autowired
	ProfileRepository profileRepo;
	
	@PostMapping("/profiles")
	public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
		try {
			Profile _profile = new Profile(profile.getFullName(), profile.getUserName(), profile.getAddress(), profile.getEmail(), profile.getPassword(), profile.getPhoneNumber());
			profileRepo.save(_profile);
			return new ResponseEntity<>(_profile, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/profiles")
	public ResponseEntity<List<Profile>> getAllProfiles(@RequestParam(required = false)String fullName){
		try {
			List<Profile> profiles = profileRepo.findAll();
			if(profiles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(profiles, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/profiles/{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable("id") long id) {
		Optional<Profile> profileData = profileRepo.findById(id);

		if (profileData.isPresent()) {
			return new ResponseEntity<>(profileData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/profiles/update/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable("id") long id, @RequestBody Profile profile) {
		Optional<Profile> profileData = profileRepo.findById(id);

		if (profileData.isPresent()) {
			Profile _profile = profileData.get();
			_profile.setFullName(profile.getFullName());
			_profile.setUserName(profile.getUserName());
			_profile.setEmail(profile.getEmail());
			_profile.setAddress(profile.getAddress());
			_profile.setPassword(profile.getPassword());
			_profile.setPhoneNumber(profile.getPhoneNumber());
			Profile updatedProfile = profileRepo.save(_profile);
			return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
