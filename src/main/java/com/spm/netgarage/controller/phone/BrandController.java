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

import com.spm.netgarage.api.phone.PhoneBrandApi;
import com.spm.netgarage.dto.phone.PhoneBrandDto;

@RestController
@RequestMapping("/api/phone/brand/")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class BrandController {
	
	private PhoneBrandApi phoneBrandApi;
	
	@Autowired
	public BrandController(PhoneBrandApi phoneBrandApi) {
		this.phoneBrandApi = phoneBrandApi;
	}
	
	//add a new phone brand
	@PostMapping("addBrand")
	public String addBrand(@RequestBody PhoneBrandDto phoneBrandDto) {
		return phoneBrandApi.addBrand(phoneBrandDto);
	}
	
	//get all phone brands
	@GetMapping("getAllBrands")
	public List<PhoneBrandDto> getAllBrands() {
		return phoneBrandApi.getAllBrands();
	}
	
	//get a brand entry by id
	@GetMapping("getBrandById/{id}")
	public PhoneBrandDto getBrandById(@PathVariable String id) {
		return phoneBrandApi.getBrandById(id);
	}
	
	//get brand by name
	@GetMapping("getBrandByName/{id}")
	public PhoneBrandDto getBrandByName(@PathVariable String name) {
		return phoneBrandApi.getBrandByName(name);
	}
	
	//update a brand entry
	@PutMapping("updateBrand")
	public String updateBrand(@RequestBody PhoneBrandDto phoneBrandDto) {
		return phoneBrandApi.updateBrand(phoneBrandDto);
	}
	
	//delete a brand on a given id
	@DeleteMapping("deleteBrandById/{id}")
	public String deleteBrandById(@PathVariable String id) {
		return phoneBrandApi.deleteBrandById(id);
	}
}
