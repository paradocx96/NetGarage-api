package com.spm.netgarage.dal.adapter.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spm.netgarage.dal.model.phone.PhoneBrandModel;
import com.spm.netgarage.dal.repository.phone.PhoneBrandRepository;
import com.spm.netgarage.dal.repository.phone.PhoneRepository;
import com.spm.netgarage.domain.phone.PhoneBrandDataAdapter;

@Component
public class PhoneBrandAdapterMongoImpl implements PhoneBrandDataAdapter {
	
	private PhoneBrandRepository phoneBrandRepository;
	
	@Autowired
	public PhoneBrandAdapterMongoImpl(PhoneBrandRepository phoneBrandRepository) {
		this.phoneBrandRepository = phoneBrandRepository;
	}

	
	//saves brand
	@Override
	public String save(PhoneBrandModel phoneBrandModel) {
		return phoneBrandRepository.save(phoneBrandModel).getId();
	}

	//get all brand entries
	@Override
	public List<PhoneBrandModel> getAll() {
		return phoneBrandRepository.findAll();
	}

	//get brand by id
	@Override
	public PhoneBrandModel getById(String id) {
		return phoneBrandRepository.findById(id).get();
	}

	//get by brand name
	@Override
	public PhoneBrandModel getByName(String name) {
		return phoneBrandRepository.findByName(name);
	}

	//update brand
	@Override
	public String update(PhoneBrandModel phoneBrandModel) {
		return phoneBrandRepository.save(phoneBrandModel).getId();
	}

	//delete a brand by id
	@Override
	public String delete(String id) {
		phoneBrandRepository.deleteById(id);
		return id;
	}

}
