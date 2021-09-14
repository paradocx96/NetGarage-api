package com.spm.netgarage.dal.adapter.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spm.netgarage.dal.model.phone.PhoneModel;
import com.spm.netgarage.dal.repository.phone.PhoneRepository;
import com.spm.netgarage.domain.phone.PhoneDataAdapter;

@Component
public class PhoneAdapterMongoImpl implements PhoneDataAdapter {
	
	private PhoneRepository phoneRepository;
	
	@Autowired
	public PhoneAdapterMongoImpl(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}

	//save a phone entry
	@Override
	public String save(PhoneModel phoneModel) {
		//save a phone 
		return phoneRepository.save(phoneModel).getId();
	}

	//returns all phone entries
	@Override
	public List<PhoneModel> getAll() {
		return phoneRepository.findAll();
	}

	//returns a phone by id
	@Override
	public PhoneModel getById(String id) {
		return phoneRepository.findById(id).get();
	}


	@Override
	public String updateById(String id, PhoneModel phoneModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	//returns entries by  brand and model
	@Override
	public List<PhoneModel> getByBrandModel(String brandModel) {
		return phoneRepository.findByBrandmodel(brandModel);
	}

	//returns entries by  brand
	@Override
	public List<PhoneModel> getByBrand(String brand) {
		return phoneRepository.findByBrand(brand);
	}

	//returns entries by OS
	@Override
	public List<PhoneModel> getByOs(String os) {
		return phoneRepository.findByOs(os);
	}

	//returns entries by chipset
	@Override
	public List<PhoneModel> getByChipset(String chipset) {
		return phoneRepository.findByChipset(chipset);
	}



}
