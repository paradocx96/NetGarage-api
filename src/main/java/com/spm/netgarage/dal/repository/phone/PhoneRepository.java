package com.spm.netgarage.dal.repository.phone;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.phone.PhoneModel;

public interface PhoneRepository extends MongoRepository<PhoneModel, String> {
	
	public PhoneModel findByBrandmodel(String brandModel);
	public PhoneModel findByBrand(String brand);
	public PhoneModel findByOs(String os);
	public PhoneModel findByChipset(String chipset);

}
