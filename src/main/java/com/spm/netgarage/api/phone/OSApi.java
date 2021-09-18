package com.spm.netgarage.api.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.netgarage.dal.model.phone.OSModel;
import com.spm.netgarage.domain.phone.OSDataAdapter;
import com.spm.netgarage.dto.phone.OSDto;

@Service
public class OSApi {
	
	private OSDataAdapter osDataAdapter;
	
	@Autowired
	public OSApi(OSDataAdapter osDataAdapter) {
		this.osDataAdapter = osDataAdapter;
	}
	
	public OSDto addOS (OSDto osDto) {
		//instantiate OS Model object
		OSModel osModel = new OSModel();
		
		//setting attributes
		osModel.setId(osDto.getId());
		osModel.setName(osDto.getName());
		
		OSModel savedOSModel =  osDataAdapter.save(osModel);
		
		//set returned attributes to OS DTO
		osDto.setId(savedOSModel.getId());
		osDto.setName(savedOSModel.getName());
		
		return osDto;
		
	}
	
	public List<OSDto> getAllOS(){
		
		//instantiate model list
		List<OSModel> osModelList = new ArrayList<>();
		//instantiate DTO list
		List<OSDto> osDtoList = new ArrayList<>();
		
		osModelList = osDataAdapter.getAll();
		
		//iterate through the OS model list
		for(OSModel os : osModelList) {
			OSDto osDto = new OSDto();
			osDto.setId(os.getId());
			osDto.setName(os.getName());
			
			//add the DTO to the DTO list
			osDtoList.add(osDto);
		}
		
		//return the OS DTO list
		return osDtoList;
		
	}
	
	public OSDto findOSById (String id) {
		//get OS model object
		OSModel osModel = osDataAdapter.getById(id);
		//instantiate OS DTO
		OSDto osDto = new OSDto();
		
		//set attributes to the DTO
		osDto.setId(osModel.getId());
		osDto.setName(osModel.getName());
		
		//return OS DTO
		return osDto;
	}
	
	public String updateOS(OSDto osDto) {
		//instantiate new OSModel
		OSModel osModel = new OSModel();
		
		osModel.setId(osDto.getId());
		osModel.setName(osDto.getName());
		
		return osDataAdapter.update(osModel);
	}
	
	public String deleteOS (String id) {
		return osDataAdapter.delete(id);
	}
	
	public OSModel getOsByName(String name) {
		return osDataAdapter.getByName(name);
	}
	
	//method checking whether the name for the OS is taken
	//returns true if the name is available
	public boolean isNameAvailable(String name) {
		//instantiate OSDto list
		List<OSDto> osList = new ArrayList<>();
		//get all OSes to the list
		osList = this.getAllOS();
		
		//iterate through the OS list
		for(OSDto os : osList) {
			//if the lower case name mathces the OS name is taken
			if(os.getName().toLowerCase().equals(name.toLowerCase())) {
				return false;
			}
		}
		
		//name did not match
		//return true
		return true;
	}

}
