package com.spm.netgarage.domain;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.dto.UserFeedbackDto;
import com.spm.netgarage.dto.UserRegisterDto;

public interface UserDataAdapter {
	
	ResponseEntity<?> createAccount(UserRegisterDto user);
	User getByID(String id);
	ResponseEntity<?> updateAccount(UserRegisterDto user);
	ResponseEntity<?> deleteAccount(String id);
	ResponseEntity<?> loginAccount(UserLoginDto user);
	ResponseEntity<?> forgotPassword(UserRegisterDto user);
	ResponseEntity<?> resetPassword(UserRegisterDto user);
	ResponseEntity<?> addUserFeedback(UserFeedbackDto feedback);

}
