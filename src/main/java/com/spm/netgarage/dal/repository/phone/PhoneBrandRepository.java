package com.spm.netgarage.dal.repository.phone;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.phone.PhoneBrandModel;

public interface PhoneBrandRepository extends MongoRepository<PhoneBrandModel, String> {
	
	public PhoneBrandModel findByName(String name);

}
