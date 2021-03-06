package com.spm.netgarage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.netgarage.api.UserApi;
import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.dal.model.UserFeedback;
import com.spm.netgarage.domain.UserLoginDto;
import com.spm.netgarage.dto.UserFeedbackDto;
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
	
	@GetMapping("/getUser-id/{id}")
	public User getByID(@PathVariable String id) {
		return userApi.getByID(id);
	}
	
	@PostMapping("/update-account")
	public ResponseEntity<?> updateUserAccount(@Valid @RequestBody UserRegisterDto userRegisterDto){
		return userApi.updateUserAccount(userRegisterDto);
	}
	
	@DeleteMapping("/delete-account/{id}")
	public ResponseEntity<?> deleteUserAccount(@PathVariable String id){
		return userApi.deleteUserAccount(id);
  }
  
	@PostMapping("/sign-in")
	public ResponseEntity<?> loginUserAccount(@Valid @RequestBody UserLoginDto userLoginDto){
		return userApi.loginAccount(userLoginDto);
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<?> userForgotPassword(@Valid @RequestBody UserRegisterDto user){
		return userApi.forgotPassword(user);
	}
	
	@PostMapping("/reset-password")
	public ResponseEntity<?> userResetPassword(@Valid @RequestBody UserRegisterDto user){
		return userApi.resetPassword(user);
	}
	
	@PostMapping("/add-feedback")
	public ResponseEntity<?> userAddFeedback(@Valid @RequestBody UserFeedbackDto feedback){
		return userApi.addUserFeedback(feedback);
	}
  
	@GetMapping("/get-feedback-all")
	public List<UserFeedback> getFeedBackAll() {
		return userApi.getFeedbackAll();
	}
	
	@GetMapping("/get-feedback-by-deviceId/{id}")
	public List<UserFeedbackDto> getUserFeedbackDeviceByID(@PathVariable String id) {
		return userApi.getUserFeedbackDeviceByID(id);
	}
	
	@GetMapping("/get-all-users")
	public List<User> getAllUsers(){
		return userApi.getAllUsers();
	}
	
}
