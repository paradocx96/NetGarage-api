package com.spm.netgarage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spm.netgarage.dal.model.User;
import com.spm.netgarage.domain.UserDataAdapter;
import com.spm.netgarage.domain.UserLoginDto;
import com.spm.netgarage.dto.UserRegisterDto;

@Service
public class UserApi {

	@Autowired
	private UserDataAdapter userDataAdapter;
	
	public ResponseEntity<?> userRegistration(UserRegisterDto userRegisterDto){
		return userDataAdapter.createAccount(userRegisterDto);
	}
	
	public User getByID(String ID) {
		return userDataAdapter.getByID(ID);
	}
	
	public ResponseEntity<?> updateUserAccount(UserRegisterDto userRegisterDto){
		return userDataAdapter.updateAccount(userRegisterDto);
	}
	
	public ResponseEntity<?> deleteUserAccount(String id){
		return userDataAdapter.deleteAccount(id);
	}
	
	public ResponseEntity<?> loginAccount(UserLoginDto userLoginDto){
		return userDataAdapter.loginAccount(userLoginDto);
	}
	
	public ResponseEntity<?> forgotPassword(UserRegisterDto user){
		return userDataAdapter.forgotPassword(user);
	}
	
	public ResponseEntity<?> resetPassword(UserRegisterDto user){
		return userDataAdapter.resetPassword(user);
	}

}
