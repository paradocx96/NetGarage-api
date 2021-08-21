package com.spm.netgarage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spm.netgarage.domain.UserDataAdapter;
import com.spm.netgarage.dto.UserRegisterDto;

@Service
public class UserApi {

	@Autowired
	private UserDataAdapter userDataAdapter;
	
	public ResponseEntity<?> userRegistration(UserRegisterDto userRegisterDto){
		return userDataAdapter.createAccount(userRegisterDto);
	}
}
