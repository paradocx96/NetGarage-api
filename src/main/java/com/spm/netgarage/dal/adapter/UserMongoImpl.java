package com.spm.netgarage.dal.adapter;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.spm.netgarage.dal.model.EmailSender;
import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.dal.repository.UserMongoRepository;
import com.spm.netgarage.domain.UserDataAdapter;
import com.spm.netgarage.dto.MessageResponseDto;
import com.spm.netgarage.dto.UserRegisterDto;

@Component
public class UserMongoImpl implements UserDataAdapter{

	@Autowired
	private UserMongoRepository userRepository;
	
	@Autowired
	private EmailSender emailSender;

	@Override
	public ResponseEntity<?> createAccount(@Valid @RequestBody UserRegisterDto userRegisterDto) {
	
		if (userRepository.existsByUsername(userRegisterDto.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponseDto("Username is already taken!"));
		}

		if (userRepository.existsByEmail(userRegisterDto.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponseDto("Email is already taken!"));
		}
		
		// Create new user's account
		User user = new User(userRegisterDto.getUsername(),
							userRegisterDto.getPassword(),
							userRegisterDto.getEmail());
		
		emailSender.setEmail(userRegisterDto.getEmail());
		emailSender.setUsername(userRegisterDto.getUsername());
		
		try {
				emailSender.sendEmail();
				
		} catch (UnsupportedEncodingException | MessagingException e) {
			
			e.printStackTrace();
		}
		
		//Save all user details into the database
		userRepository.save(user);
		
		//return success MSG to frontEnd user is registered successfully
		return ResponseEntity.ok(new MessageResponseDto("User registered successfully!"));
			
	}

	@Override
	public ResponseEntity<?> updateAccount(UserRegisterDto user) {
		
		User exist = userRepository.findById(user.getId()).get();
		
		exist.setUsername(user.getUsername());
		exist.setPassword(user.getPassword());
		exist.setEmail(user.getEmail());
		
		userRepository.save(exist);
		
		// return success MSG to frontEnd user is updated successfully
		return ResponseEntity.ok(new MessageResponseDto("Profile Updated successfully!"));
	}

	@Override
	public User getByID(String id) {
		return userRepository.findById(id).get();
	}

	@Override
	public ResponseEntity<?> loginAccount(UserRegisterDto user) {
		
		User exist = userRepository.findByUsername(user.getUsername()).get();
		
		System.out.println(exist.getEmail());
		exist.getId();
		exist.getEmail();
		exist.getUsername();
		
		// return success MSG to frontEnd user is updated successfully
		return ResponseEntity.ok(new UserRegisterDto(exist.getId(),exist.getUsername(),exist.getEmail()));
	}
	
}
