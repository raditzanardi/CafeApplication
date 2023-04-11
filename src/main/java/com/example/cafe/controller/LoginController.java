package com.example.cafe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafe.model.Profile;
import com.example.cafe.model.ProfileRepository;
import com.example.cafe.request.ProfileLoginRequest;
import com.example.demo.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	ProfileRepository profileRepo;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody ProfileLoginRequest loginRequest) {

		try {
			Optional<Profile> profileData = profileRepo.findByUserName(loginRequest.getUserName());
			if (profileData.isPresent()) {
				String password = profileData.get().getPassword();
				if (password.equals(loginRequest.getPassword())) {
					return new ResponseEntity<>(profileData.get(), HttpStatus.OK);
				}
				else {
				MessageResponse msg = new MessageResponse("Incorrect password");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
				}
			}
			else {
				MessageResponse msg = new MessageResponse("No such a profile");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			MessageResponse msg = new MessageResponse("Server Error");
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
