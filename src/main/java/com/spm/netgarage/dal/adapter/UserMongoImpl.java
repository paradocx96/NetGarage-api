package com.spm.netgarage.dal.adapter;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.dal.repository.UserMongoRepository;
import com.spm.netgarage.domain.UserDataAdapter;
import com.spm.netgarage.dto.MessageResponseDto;
import com.spm.netgarage.dto.UserRegisterDto;

@Component
public class UserMongoImpl implements UserDataAdapter{

	@Autowired
	private UserMongoRepository userRepository;

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
		
		//Save all user details into the database
		userRepository.save(user);
		
		//return success MSG to frontEnd user is registered successfully
		return ResponseEntity.ok(new MessageResponseDto("User registered successfully!"));
			
	}
	
}
