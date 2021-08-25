package com.spm.netgarage.dal.repository.phone;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.phone.ChipsetModel;

public interface ChipsetRepository extends MongoRepository<ChipsetModel, String> {
	
	public ChipsetModel findByBrandmodel(String brandAndModel);

}
