package com.spm.netgarage.dal.repository.phone;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.phone.OSModel;

public interface OSRepository extends MongoRepository<OSModel, String>{
	
	public OSModel findByName (String name);

}
