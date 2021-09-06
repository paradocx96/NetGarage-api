package com.spm.netgarage.dal.adapter;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.spm.netgarage.dal.model.ERole;
import com.spm.netgarage.dal.model.EmailSender;
import com.spm.netgarage.dal.model.Role;
import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.dal.repository.RoleMongoRepository;
import com.spm.netgarage.dal.repository.UserMongoRepository;
import com.spm.netgarage.domain.JwtResponseDto;
import com.spm.netgarage.domain.UserDataAdapter;
import com.spm.netgarage.domain.UserLoginDto;
import com.spm.netgarage.dto.MessageResponseDto;
import com.spm.netgarage.dto.UserRegisterDto;
import com.spm.netgarage.security.jwt.JwtUtils;

@Component
public class UserMongoImpl implements UserDataAdapter{

	@Autowired
	private UserMongoRepository userRepository;
	
	@Autowired
	RoleMongoRepository roleRepository;
	
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

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
							passwordEncoder.encode(userRegisterDto.getPassword()),
							userRegisterDto.getEmail());
		
		
		//Create new HashSet to store user Roles
		Set<Role> roles = new HashSet<>();
				
		//If it is true, Add ROLE_USER to that user
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		
		roles.add(userRole);
				
		
		emailSender.setEmail(userRegisterDto.getEmail());
		emailSender.setUsername(userRegisterDto.getUsername());
		
		try {
				emailSender.sendEmail();
				
		} catch (UnsupportedEncodingException | MessagingException e) {
			
			e.printStackTrace();
		}
		
		
		//set all roles to user object
		user.setRoles(roles);
				
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
	public ResponseEntity<?> loginAccount(@Valid @RequestBody UserLoginDto user) {
		
		//Get user name and password and create new AuthenticationToken 
		Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		//Set above assigned user credentials using Authentication object
		SecurityContextHolder.getContext().setAuthentication(authentication);
				
		//After that create new JWT Token for that person
		String jwt = jwtUtils.generateJwtToken(authentication);
				
		//Then get authentication principles and set that UserDetailimpl object 
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
				
		//Get getAuthorities and set to List object
		List<String> roles = userDetails.getAuthorities().stream()
						.map(item -> item.getAuthority())
						.collect(Collectors.toList());
		
		//This is for check the program display correct values or not
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.getPassword());
		System.out.println(jwt);
		System.out.println(roles.toString());
		
		
		//Return JWT response to FrontEnd
		return ResponseEntity.ok(new JwtResponseDto(jwt, 
													userDetails.getId(), 
													userDetails.getUsername(), 
													userDetails.getEmail(), 
													roles));
	}

	@Override
	public ResponseEntity<?> forgotPassword(@Valid @RequestBody UserRegisterDto user) {
		
		User userObject = userRepository.findByEmail(user.getEmail()).get();
		
		// Check if student email already exist in the DB
		if(userRepository.existsByEmail(user.getEmail())) {
			
			System.out.println("User ID " + userObject.getId());
			System.out.println("User Email " + user.getEmail());
			
		}
		
		return null;
	}
}
