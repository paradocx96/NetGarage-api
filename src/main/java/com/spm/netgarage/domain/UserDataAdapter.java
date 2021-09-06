package com.spm.netgarage.domain;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.dto.UserRegisterDto;

public interface UserDataAdapter {
	
	ResponseEntity<?> createAccount(UserRegisterDto user);
	User getByID(String id);
	ResponseEntity<?> updateAccount(UserRegisterDto user);
	ResponseEntity<?> loginAccount(UserLoginDto user);
	ResponseEntity<?> forgotPassword(UserRegisterDto user);
}
