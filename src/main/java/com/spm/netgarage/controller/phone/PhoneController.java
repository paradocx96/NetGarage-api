package com.spm.netgarage.controller.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.netgarage.api.phone.PhoneApi;
import com.spm.netgarage.dto.phone.PhoneDto;

@RestController
@RequestMapping("/api/phone/phones/")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class PhoneController {
	
	private PhoneApi phoneApi;

	@Autowired
	public PhoneController(PhoneApi phoneApi) {
		this.phoneApi = phoneApi;
	}
	
	//add a phone entry
	public String addPhone (PhoneDto phoneDto) {
		return phoneApi.addPhone(phoneDto);
	}
	
	//get all the phones 
	public List<PhoneDto> getAllPhones(){
		return phoneApi.getAllPhones();
	}
	
	//get the phone for a given id
	public PhoneDto getPhoneById(String id) {
		return phoneApi.getPhoneById(id);
	}
	
	//update a phone
	public String updatePhone (PhoneDto phoneDto) {
		return phoneApi.updatePhone(phoneDto);
	}
	
	//delete a phone on a given id
	public String deletePhoneById(String id) {
		return phoneApi.deletePhoneById(id);
	}
	
	

}
