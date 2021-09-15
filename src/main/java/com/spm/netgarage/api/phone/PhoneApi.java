package com.spm.netgarage.api.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.netgarage.dal.model.phone.PhoneModel;
import com.spm.netgarage.domain.phone.PhoneDataAdapter;
import com.spm.netgarage.dto.phone.PhoneDto;

@Service
public class PhoneApi {
	
	private PhoneDataAdapter phoneDataAdapter;

	@Autowired
	public PhoneApi(PhoneDataAdapter phoneDataAdapter) {
		this.phoneDataAdapter = phoneDataAdapter;
	}
	
	//add a phone entry
	public String addPhone(PhoneDto phoneDto) {
		
		//instantiate new model
		PhoneModel newPhone = new PhoneModel();
		
		//set the attributes
		newPhone.setId(phoneDto.getId());
		newPhone.setBrandmodel(phoneDto.getBrandmodel());
		newPhone.setBrand(phoneDto.getBrand());
		newPhone.setImage(phoneDto.getImage());
		newPhone.setPublishstatus("unpublished");
		
		newPhone.setNetwork(phoneDto.getNetwork());
		
		//body
		newPhone.setDimensions(phoneDto.getDimensions());
		newPhone.setWeight(phoneDto.getWeight());
		newPhone.setSim(phoneDto.getSim());
		
		//display
		newPhone.setDisplaytype(phoneDto.getDisplaytype());
		newPhone.setDisplaysize(phoneDto.getDisplaysize());
		newPhone.setDisplayresolution(phoneDto.getDisplayresolution());
		newPhone.setDisplayprotection(phoneDto.getDisplayprotection());
		
		//software
		newPhone.setOs(phoneDto.getOs());
		newPhone.setSoftwarefeatures(phoneDto.getSoftwarefeatures());
		newPhone.setChipset(phoneDto.getChipset());
		newPhone.setMemorystorage(phoneDto.getMemorystorage());
		newPhone.setCard(phoneDto.getCard());
		
		//main camera
		newPhone.setMaincamera(phoneDto.getMaincamera());
		newPhone.setMaincameraDetails(phoneDto.getMaincameraDetails());
		newPhone.setMaincameraVideo(phoneDto.getMaincameraVideo());
		newPhone.setMaincameraFeatures(phoneDto.getMaincameraFeatures());
		
		//selfie camera
		newPhone.setSelfcamera(phoneDto.getSelfcamera());
		newPhone.setSelfcameraDetails(phoneDto.getSelfcameraDetails());
		newPhone.setSelfcameraVideo(phoneDto.getSelfcameraVideo());
		newPhone.setSelfcameraFeatures(phoneDto.getSelfcameraFeatures());
		
		//audio attributes
		newPhone.setLoudspeaker(phoneDto.getLoudspeaker());
		newPhone.setHeadphonejack(phoneDto.getHeadphonejack());
		newPhone.setWlan(phoneDto.getWlan());
		newPhone.setBluetooth(phoneDto.getBluetooth());
		newPhone.setGps(phoneDto.getGps());
		newPhone.setNfc(phoneDto.getNfc());
		newPhone.setRadio(phoneDto.getRadio());
		
		//sensors
		newPhone.setSensors(phoneDto.getSensors());
		
		//battery
		newPhone.setBatterytype(phoneDto.getBatterytype());
		newPhone.setCharging(phoneDto.getCharging());
		
		//miscellaneous
		newPhone.setColors(phoneDto.getColors());
		newPhone.setModels(phoneDto.getModels());
		newPhone.setSar(phoneDto.getSar());
		
		return phoneDataAdapter.save(newPhone);
		
	}
	
	public List<PhoneDto> getAllPhones(){
		
		//instantiate phoneDto and model list
		List<PhoneDto> phoneDtoList = new ArrayList<>();
		List<PhoneModel> phoneModelList = new ArrayList<>();
		
		//get all phone models to phoneModel list
		phoneModelList =  phoneDataAdapter.getAll();
		
		//iterate through phone model list
		for(PhoneModel phoneModel : phoneModelList) {
			//instantiate phone dto
			PhoneDto phoneDto = new PhoneDto();
			
			//set the attributes to the phone DTO
			phoneDto.setId(phoneModel.getId());
			phoneDto.setBrandmodel(phoneModel.getBrandmodel());
			phoneDto.setBrand(phoneModel.getBrand());
			phoneDto.setImage(phoneModel.getImage());
			phoneDto.setPublishstatus(phoneModel.getPublishstatus());
			
			phoneDto.setNetwork(phoneModel.getNetwork());
			
			//body
			phoneDto.setDimensions(phoneModel.getDimensions());
			phoneDto.setWeight(phoneModel.getWeight());
			phoneDto.setSim(phoneModel.getSim());
			
			//display
			phoneDto.setDisplaytype(phoneModel.getDisplaytype());
			phoneDto.setDisplaysize(phoneModel.getDisplaysize());
			phoneDto.setDisplayresolution(phoneModel.getDisplayresolution());
			phoneDto.setDisplayprotection(phoneModel.getDisplayprotection());
			
			//software
			phoneDto.setOs(phoneModel.getOs());
			phoneDto.setSoftwarefeatures(phoneModel.getSoftwarefeatures());
			phoneDto.setChipset(phoneModel.getChipset());
			phoneDto.setMemorystorage(phoneModel.getMemorystorage());
			phoneDto.setCard(phoneModel.getCard());
			
			//main camera
			phoneDto.setMaincamera(phoneModel.getMaincamera());
			phoneDto.setMaincameraDetails(phoneModel.getMaincameraDetails());
			phoneDto.setMaincameraVideo(phoneModel.getMaincameraVideo());
			phoneDto.setMaincameraFeatures(phoneModel.getMaincameraFeatures());
			
			//selfie camera
			phoneDto.setSelfcamera(phoneModel.getSelfcamera());
			phoneDto.setSelfcameraDetails(phoneModel.getSelfcameraDetails());
			phoneDto.setSelfcameraVideo(phoneModel.getSelfcameraVideo());
			phoneDto.setSelfcameraFeatures(phoneModel.getSelfcameraFeatures());
			
			//audio attributes
			phoneDto.setLoudspeaker(phoneModel.getLoudspeaker());
			phoneDto.setHeadphonejack(phoneModel.getHeadphonejack());
			phoneDto.setWlan(phoneModel.getWlan());
			phoneDto.setBluetooth(phoneModel.getBluetooth());
			phoneDto.setGps(phoneModel.getGps());
			phoneDto.setNfc(phoneModel.getNfc());
			phoneDto.setRadio(phoneModel.getRadio());
			
			//sensors
			phoneDto.setSensors(phoneModel.getSensors());
			
			//battery
			phoneDto.setBatterytype(phoneModel.getBatterytype());
			phoneDto.setCharging(phoneModel.getCharging());
			
			//miscellaneous
			phoneDto.setColors(phoneModel.getColors());
			phoneDto.setModels(phoneModel.getModels());
			phoneDto.setSar(phoneModel.getSar());
			
			phoneDtoList.add(phoneDto);
		}
		
		return phoneDtoList;
	}
	
	//get a phone by id
	public PhoneDto getPhoneById(String id) {
		PhoneDto phoneDto = new PhoneDto();
		PhoneModel phoneModel = new PhoneModel();
		
		phoneDto.setId(phoneModel.getId());
		phoneDto.setBrandmodel(phoneModel.getBrandmodel());
		phoneDto.setBrand(phoneModel.getBrand());
		phoneDto.setImage(phoneModel.getImage());
		phoneDto.setPublishstatus(phoneModel.getPublishstatus());
		
		phoneDto.setNetwork(phoneModel.getNetwork());
		
		//body
		phoneDto.setDimensions(phoneModel.getDimensions());
		phoneDto.setWeight(phoneModel.getWeight());
		phoneDto.setSim(phoneModel.getSim());
		
		//display
		phoneDto.setDisplaytype(phoneModel.getDisplaytype());
		phoneDto.setDisplaysize(phoneModel.getDisplaysize());
		phoneDto.setDisplayresolution(phoneModel.getDisplayresolution());
		phoneDto.setDisplayprotection(phoneModel.getDisplayprotection());
		
		//software
		phoneDto.setOs(phoneModel.getOs());
		phoneDto.setSoftwarefeatures(phoneModel.getSoftwarefeatures());
		phoneDto.setChipset(phoneModel.getChipset());
		phoneDto.setMemorystorage(phoneModel.getMemorystorage());
		phoneDto.setCard(phoneModel.getCard());
		
		//main camera
		phoneDto.setMaincamera(phoneModel.getMaincamera());
		phoneDto.setMaincameraDetails(phoneModel.getMaincameraDetails());
		phoneDto.setMaincameraVideo(phoneModel.getMaincameraVideo());
		phoneDto.setMaincameraFeatures(phoneModel.getMaincameraFeatures());
		
		//selfie camera
		phoneDto.setSelfcamera(phoneModel.getSelfcamera());
		phoneDto.setSelfcameraDetails(phoneModel.getSelfcameraDetails());
		phoneDto.setSelfcameraVideo(phoneModel.getSelfcameraVideo());
		phoneDto.setSelfcameraFeatures(phoneModel.getSelfcameraFeatures());
		
		//audio attributes
		phoneDto.setLoudspeaker(phoneModel.getLoudspeaker());
		phoneDto.setHeadphonejack(phoneModel.getHeadphonejack());
		phoneDto.setWlan(phoneModel.getWlan());
		phoneDto.setBluetooth(phoneModel.getBluetooth());
		phoneDto.setGps(phoneModel.getGps());
		phoneDto.setNfc(phoneModel.getNfc());
		phoneDto.setRadio(phoneModel.getRadio());
		
		//sensors
		phoneDto.setSensors(phoneModel.getSensors());
		
		//battery
		phoneDto.setBatterytype(phoneModel.getBatterytype());
		phoneDto.setCharging(phoneModel.getCharging());
		
		//miscellaneous
		phoneDto.setColors(phoneModel.getColors());
		phoneDto.setModels(phoneModel.getModels());
		phoneDto.setSar(phoneModel.getSar());
		
		return phoneDto;
	}
	
	//update a phone entry
	public String updatePhone(PhoneDto phoneDto) {
		PhoneModel phoneModel =  new PhoneModel();
		
		phoneModel.setId(phoneDto.getId());
		phoneModel.setBrandmodel(phoneDto.getBrandmodel());
		phoneModel.setBrand(phoneDto.getBrand());
		phoneModel.setImage(phoneDto.getImage());
		phoneModel.setPublishstatus(phoneDto.getPublishstatus());
		
		phoneModel.setNetwork(phoneDto.getNetwork());
		
		//body
		phoneModel.setDimensions(phoneDto.getDimensions());
		phoneModel.setWeight(phoneDto.getWeight());
		phoneModel.setSim(phoneDto.getSim());
		
		//display
		phoneModel.setDisplaytype(phoneDto.getDisplaytype());
		phoneModel.setDisplaysize(phoneDto.getDisplaysize());
		phoneModel.setDisplayresolution(phoneDto.getDisplayresolution());
		phoneModel.setDisplayprotection(phoneDto.getDisplayprotection());
		
		//software
		phoneModel.setOs(phoneDto.getOs());
		phoneModel.setSoftwarefeatures(phoneDto.getSoftwarefeatures());
		phoneModel.setChipset(phoneDto.getChipset());
		phoneModel.setMemorystorage(phoneDto.getMemorystorage());
		phoneModel.setCard(phoneDto.getCard());
		
		//main camera
		phoneModel.setMaincamera(phoneDto.getMaincamera());
		phoneModel.setMaincameraDetails(phoneDto.getMaincameraDetails());
		phoneModel.setMaincameraVideo(phoneDto.getMaincameraVideo());
		phoneModel.setMaincameraFeatures(phoneDto.getMaincameraFeatures());
		
		//selfie camera
		phoneModel.setSelfcamera(phoneDto.getSelfcamera());
		phoneModel.setSelfcameraDetails(phoneDto.getSelfcameraDetails());
		phoneModel.setSelfcameraVideo(phoneDto.getSelfcameraVideo());
		phoneModel.setSelfcameraFeatures(phoneDto.getSelfcameraFeatures());
		
		//audio attributes
		phoneModel.setLoudspeaker(phoneDto.getLoudspeaker());
		phoneModel.setHeadphonejack(phoneDto.getHeadphonejack());
		phoneModel.setWlan(phoneDto.getWlan());
		phoneModel.setBluetooth(phoneDto.getBluetooth());
		phoneModel.setGps(phoneDto.getGps());
		phoneModel.setNfc(phoneDto.getNfc());
		phoneModel.setRadio(phoneDto.getRadio());
		
		//sensors
		phoneModel.setSensors(phoneDto.getSensors());
		
		//battery
		phoneModel.setBatterytype(phoneDto.getBatterytype());
		phoneModel.setCharging(phoneDto.getCharging());
		
		//miscellaneous
		phoneModel.setColors(phoneDto.getColors());
		phoneModel.setModels(phoneDto.getModels());
		phoneModel.setSar(phoneDto.getSar());
		
		return phoneDataAdapter.updateById(phoneModel);
	}
	
	//deletes a phone by id
	public String deletePhoneById(String id) {
		return phoneDataAdapter.delete(id);
	}
	
	public boolean isPhoneAvailable(String brandmodel) {
		List<PhoneDto> phoneDtoList = new ArrayList<>();
		phoneDtoList = this.getAllPhones();
		
		boolean isAvailable = true;
		
		for(PhoneDto phoneDto : phoneDtoList) {
			int compare = phoneDto.getBrandmodel().compareToIgnoreCase(brandmodel);
			if(compare == 0) {
				isAvailable = false;
			}
		}
		
		return isAvailable;
	}
	
	//get published phones
	public List<PhoneDto> getPublishedPhones(){
		//instantiate phoneDto and model list
				List<PhoneDto> phoneDtoList = new ArrayList<>();
				List<PhoneModel> phoneModelList = new ArrayList<>();
				
				//get all phone models to phoneModel list
				phoneModelList =  phoneDataAdapter.getByPublishedStatus("published");
				
				//iterate through phone model list
				for(PhoneModel phoneModel : phoneModelList) {
					//instantiate phone dto
					PhoneDto phoneDto = new PhoneDto();
					
					//set the attributes to the phone DTO
					phoneDto.setId(phoneModel.getId());
					phoneDto.setBrandmodel(phoneModel.getBrandmodel());
					phoneDto.setBrand(phoneModel.getBrand());
					phoneDto.setImage(phoneModel.getImage());
					phoneDto.setPublishstatus(phoneModel.getPublishstatus());
					
					phoneDto.setNetwork(phoneModel.getNetwork());
					
					//body
					phoneDto.setDimensions(phoneModel.getDimensions());
					phoneDto.setWeight(phoneModel.getWeight());
					phoneDto.setSim(phoneModel.getSim());
					
					//display
					phoneDto.setDisplaytype(phoneModel.getDisplaytype());
					phoneDto.setDisplaysize(phoneModel.getDisplaysize());
					phoneDto.setDisplayresolution(phoneModel.getDisplayresolution());
					phoneDto.setDisplayprotection(phoneModel.getDisplayprotection());
					
					//software
					phoneDto.setOs(phoneModel.getOs());
					phoneDto.setSoftwarefeatures(phoneModel.getSoftwarefeatures());
					phoneDto.setChipset(phoneModel.getChipset());
					phoneDto.setMemorystorage(phoneModel.getMemorystorage());
					phoneDto.setCard(phoneModel.getCard());
					
					//main camera
					phoneDto.setMaincamera(phoneModel.getMaincamera());
					phoneDto.setMaincameraDetails(phoneModel.getMaincameraDetails());
					phoneDto.setMaincameraVideo(phoneModel.getMaincameraVideo());
					phoneDto.setMaincameraFeatures(phoneModel.getMaincameraFeatures());
					
					//selfie camera
					phoneDto.setSelfcamera(phoneModel.getSelfcamera());
					phoneDto.setSelfcameraDetails(phoneModel.getSelfcameraDetails());
					phoneDto.setSelfcameraVideo(phoneModel.getSelfcameraVideo());
					phoneDto.setSelfcameraFeatures(phoneModel.getSelfcameraFeatures());
					
					//audio attributes
					phoneDto.setLoudspeaker(phoneModel.getLoudspeaker());
					phoneDto.setHeadphonejack(phoneModel.getHeadphonejack());
					phoneDto.setWlan(phoneModel.getWlan());
					phoneDto.setBluetooth(phoneModel.getBluetooth());
					phoneDto.setGps(phoneModel.getGps());
					phoneDto.setNfc(phoneModel.getNfc());
					phoneDto.setRadio(phoneModel.getRadio());
					
					//sensors
					phoneDto.setSensors(phoneModel.getSensors());
					
					//battery
					phoneDto.setBatterytype(phoneModel.getBatterytype());
					phoneDto.setCharging(phoneModel.getCharging());
					
					//miscellaneous
					phoneDto.setColors(phoneModel.getColors());
					phoneDto.setModels(phoneModel.getModels());
					phoneDto.setSar(phoneModel.getSar());
					
					phoneDtoList.add(phoneDto);
				}
				
				return phoneDtoList;
				
				
	}
	
	//method to get unpublished phones
	public List<PhoneDto> getUnpublishedPhones(){
		//instantiate phoneDto and model list
				List<PhoneDto> phoneDtoList = new ArrayList<>();
				List<PhoneModel> phoneModelList = new ArrayList<>();
				
				//get all phone models to phoneModel list
				phoneModelList =  phoneDataAdapter.getByPublishedStatus("unpublished");
				
				//iterate through phone model list
				for(PhoneModel phoneModel : phoneModelList) {
					//instantiate phone dto
					PhoneDto phoneDto = new PhoneDto();
					
					//set the attributes to the phone DTO
					phoneDto.setId(phoneModel.getId());
					phoneDto.setBrandmodel(phoneModel.getBrandmodel());
					phoneDto.setBrand(phoneModel.getBrand());
					phoneDto.setImage(phoneModel.getImage());
					phoneDto.setPublishstatus(phoneModel.getPublishstatus());
					
					phoneDto.setNetwork(phoneModel.getNetwork());
					
					//body
					phoneDto.setDimensions(phoneModel.getDimensions());
					phoneDto.setWeight(phoneModel.getWeight());
					phoneDto.setSim(phoneModel.getSim());
					
					//display
					phoneDto.setDisplaytype(phoneModel.getDisplaytype());
					phoneDto.setDisplaysize(phoneModel.getDisplaysize());
					phoneDto.setDisplayresolution(phoneModel.getDisplayresolution());
					phoneDto.setDisplayprotection(phoneModel.getDisplayprotection());
					
					//software
					phoneDto.setOs(phoneModel.getOs());
					phoneDto.setSoftwarefeatures(phoneModel.getSoftwarefeatures());
					phoneDto.setChipset(phoneModel.getChipset());
					phoneDto.setMemorystorage(phoneModel.getMemorystorage());
					phoneDto.setCard(phoneModel.getCard());
					
					//main camera
					phoneDto.setMaincamera(phoneModel.getMaincamera());
					phoneDto.setMaincameraDetails(phoneModel.getMaincameraDetails());
					phoneDto.setMaincameraVideo(phoneModel.getMaincameraVideo());
					phoneDto.setMaincameraFeatures(phoneModel.getMaincameraFeatures());
					
					//selfie camera
					phoneDto.setSelfcamera(phoneModel.getSelfcamera());
					phoneDto.setSelfcameraDetails(phoneModel.getSelfcameraDetails());
					phoneDto.setSelfcameraVideo(phoneModel.getSelfcameraVideo());
					phoneDto.setSelfcameraFeatures(phoneModel.getSelfcameraFeatures());
					
					//audio attributes
					phoneDto.setLoudspeaker(phoneModel.getLoudspeaker());
					phoneDto.setHeadphonejack(phoneModel.getHeadphonejack());
					phoneDto.setWlan(phoneModel.getWlan());
					phoneDto.setBluetooth(phoneModel.getBluetooth());
					phoneDto.setGps(phoneModel.getGps());
					phoneDto.setNfc(phoneModel.getNfc());
					phoneDto.setRadio(phoneModel.getRadio());
					
					//sensors
					phoneDto.setSensors(phoneModel.getSensors());
					
					//battery
					phoneDto.setBatterytype(phoneModel.getBatterytype());
					phoneDto.setCharging(phoneModel.getCharging());
					
					//miscellaneous
					phoneDto.setColors(phoneModel.getColors());
					phoneDto.setModels(phoneModel.getModels());
					phoneDto.setSar(phoneModel.getSar());
					
					phoneDtoList.add(phoneDto);
				}
				
				return phoneDtoList;
				
				
	}
	
	//publish a phone
	public String doPublishPhone(String id) {
		//get the phone on the given id
		PhoneModel phoneModel =  phoneDataAdapter.getById(id);
		//set the status as published
		phoneModel.setPublishstatus("published");
		//update the database
		return phoneDataAdapter.updateById(phoneModel);
	}
	
	//unpublish a phone
		public String doUnpublishPhone(String id) {
			//get the phone on the given id
			PhoneModel phoneModel =  phoneDataAdapter.getById(id);
			//set the status as published
			phoneModel.setPublishstatus("unpublished");
			//update the database
			return phoneDataAdapter.updateById(phoneModel);
		}
	

}
