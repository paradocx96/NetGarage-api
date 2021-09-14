package com.spm.netgarage.api.phone;

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
	

}
