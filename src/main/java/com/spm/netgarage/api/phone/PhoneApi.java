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
	
	public String addPhone(PhoneDto phoneDto) {
		PhoneModel newPhone = new PhoneModel();
		newPhone.setId(phoneDto.getId());
		newPhone.setBrandmodel(phoneDto.getBrandmodel());
		newPhone.setBrand(phoneDto.getBrand());
		newPhone.setImage(phoneDto.getImage());
		
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
		List<PhoneDto> phoneDtoList = new ArrayList<>();
		List<PhoneModel> phoneModelList = new ArrayList<>();
		
		phoneModelList =  phoneDataAdapter.getAll();
		
		for(PhoneModel phoneModel : phoneModelList) {
			PhoneDto phoneDto = new PhoneDto();
			
			phoneDto.setId(phoneModel.getId());
			phoneDto.setBrandmodel(phoneModel.getBrandmodel());
			phoneDto.setBrand(phoneModel.getBrand());
			phoneDto.setImage(phoneModel.getImage());
			
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
	

}
