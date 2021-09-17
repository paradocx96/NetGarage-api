package com.spm.netgarage.controller.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.netgarage.api.phone.PhoneApi;

import com.spm.netgarage.dto.phone.ImageUpdateRequest;
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
	@PostMapping("addPhone")
	public String addPhone (@RequestBody PhoneDto phoneDto) {
		return phoneApi.addPhone(phoneDto);
	}
	
	//get all the phones 
	@GetMapping("getAllPhones")
	public List<PhoneDto> getAllPhones(){
		return phoneApi.getAllPhones();
	}
	
	//get the phone for a given id
	@GetMapping("getPhoneById/{id}")
	public PhoneDto getPhoneById(@PathVariable String id) {
		System.out.println("Controller. Recived ID : " + id);
		return phoneApi.getPhoneById(id);
	}
	
	//update a phone
	@PutMapping("updatePhone")
	public String updatePhone (@RequestBody PhoneDto phoneDto) {
		return phoneApi.updatePhone(phoneDto);
	}
	
	//delete a phone on a given id
	@DeleteMapping("deletePhone/{id}")
	public String deletePhoneById(@PathVariable String id) {
		return phoneApi.deletePhoneById(id);
	}
	
	//check the availability of a phone
	//true if available else false
	@GetMapping("isPhoneAvailable/{brandmodel}")
	public boolean isPhoneAvailable(@PathVariable String brandmodel) {
		return phoneApi.isPhoneAvailable(brandmodel);
	}
	
	//get all published phones
	@GetMapping("getPublihsedPhones")
	public List<PhoneDto> getAllPublishedPhones(){
		return phoneApi.getPublishedPhones();
	}
	
	//get all unpublished phones
	@GetMapping("getUnpublihsedPhones")
	public List<PhoneDto> getAllUnpublishedPhones(){
		return phoneApi.getUnpublishedPhones();
	}
	
	//publish a phone entry by id
	@PutMapping("publishPhone/{id}")
	public String publishPhone(@PathVariable String id) {
		return phoneApi.doPublishPhone(id);
	}
	
	//unpublish a phone entry by id
	@PutMapping("unpublishPhone/{id}")
	public String unpublishPhone(@PathVariable String id) {
		return phoneApi.doUnpublishPhone(id);
	}
	
	//update the phone image
	@PutMapping("updateImage")
	public String updatePhoneImage(@RequestBody ImageUpdateRequest imageUpdateRequest) {
		return phoneApi.updatePhoneImage(imageUpdateRequest);
	}
	
	@GetMapping("getPhonesByChipset/{chipset}")
	public List<PhoneDto> getPhonesByChipset(@PathVariable String chipset){
		return phoneApi.getPhoneByChipset(chipset);
	}
	
	@GetMapping("getPhonesByOs/{os}")
	public List<PhoneDto> getPhonesByOs(@PathVariable String os){
		return phoneApi.getPhoneByOs(os);
	}
	
	@GetMapping("getPhonesByBrand/{brand}")
	public List<PhoneDto> getPhonesByBrand(@PathVariable String brand){
		return phoneApi.getPhoneByBrand(brand);
	}

}
