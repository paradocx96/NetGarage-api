package com.spm.netgarage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.netgarage.api.UserApi;
import com.spm.netgarage.dto.UserRegisterDto;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class UserEndPoint {

	@Autowired
	private UserApi userApi;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> userRegistration(@Valid @RequestBody UserRegisterDto userRegisterDto){
		return userApi.userRegistration(userRegisterDto);
	}
}
