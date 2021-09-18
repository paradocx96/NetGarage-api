package com.spm.netgarage.api.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.netgarage.dal.model.phone.PhoneBrandModel;
import com.spm.netgarage.domain.phone.PhoneBrandDataAdapter;

import com.spm.netgarage.dto.phone.PhoneBrandDto;

@Service
public class PhoneBrandApi {
	
	private PhoneBrandDataAdapter phoneBrandDataAdapter;

	@Autowired
	public PhoneBrandApi(PhoneBrandDataAdapter phoneBrandDataAdapter) {
		this.phoneBrandDataAdapter = phoneBrandDataAdapter;
	}
	
	//save a phone brand
	public String addBrand(PhoneBrandDto phoneBrandDto) {
		PhoneBrandModel phoneBrandModel =  new PhoneBrandModel();
		phoneBrandModel.setName(phoneBrandDto.getName());
		
		//add the brand
		return phoneBrandDataAdapter.save(phoneBrandModel);
	}
	
	//get all brands
	public List<PhoneBrandDto> getAllBrands (){
		//instantiate lists
		List<PhoneBrandDto> phoneBrandDtoList = new ArrayList<>();
		List<PhoneBrandModel> phoneBrandModelList = new ArrayList<>();
		
		phoneBrandModelList = phoneBrandDataAdapter.getAll();
		
		//iterate through model list
		for(PhoneBrandModel phoneBrandModel : phoneBrandModelList) {
			
			//instantiate DTO and set attributes
			PhoneBrandDto phoneBrandDto = new PhoneBrandDto();
			phoneBrandDto.setId(phoneBrandModel.getId());
			phoneBrandDto.setName(phoneBrandModel.getName());
			
			//add the DTO to DTO list
			phoneBrandDtoList.add(phoneBrandDto);
		}
		
		return phoneBrandDtoList;
	}
	
	//get brand by id
	public PhoneBrandDto getBrandById(String id) {
		
		PhoneBrandDto phoneBrandDto = new PhoneBrandDto();
		PhoneBrandModel phoneBrandModel = phoneBrandDataAdapter.getById(id);
		
		phoneBrandDto.setId(phoneBrandModel.getId());
		phoneBrandDto.setName(phoneBrandModel.getName());
		
		return phoneBrandDto;
	}
	
	//get brand by name
	public PhoneBrandDto getBrandByName(String name) {
			
		PhoneBrandDto phoneBrandDto = new PhoneBrandDto();
		PhoneBrandModel phoneBrandModel = phoneBrandDataAdapter.getByName(name);
			
		phoneBrandDto.setId(phoneBrandModel.getId());
		phoneBrandDto.setName(phoneBrandModel.getName());
			
		return phoneBrandDto;
	}
	
	//update a phone brand
	public String updateBrand(PhoneBrandDto phoneBrandDto) {
		
		PhoneBrandModel phoneBrandModel = new PhoneBrandModel();
		phoneBrandModel.setId(phoneBrandDto.getId());
		phoneBrandModel.setName(phoneBrandDto.getName());
		
		return phoneBrandDataAdapter.update(phoneBrandModel);
	}
	
	//delete a phone brand
	public String deleteBrandById (String id) {
		return phoneBrandDataAdapter.delete(id);
	}
	
	//checks whether a brand is available
	public boolean isBrandAvailable(String brand) {
		List<PhoneBrandDto> brandDtoList = new ArrayList<>();
		brandDtoList = this.getAllBrands();
		
		boolean isAvailable = true;
		
		for(PhoneBrandDto phoneBrandDto : brandDtoList) {
			int compare = phoneBrandDto.getName().compareToIgnoreCase(brand);
			if(compare == 0) {
				isAvailable = false;
			}
		}
		return isAvailable;
	}
	
}
