package com.spm.netgarage.dal.repository.phone;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.phone.PhoneModel;

public interface PhoneRepository extends MongoRepository<PhoneModel, String> {
	
	public List<PhoneModel> findByBrand(String brand);
	public List<PhoneModel> findByBrandmodel(String brandmodel);
	public List<PhoneModel> findByOs(String os);
	public List<PhoneModel> findByChipset(String chipset);
	public List<PhoneModel> findByPublishstatus(String publishstatus);

}
