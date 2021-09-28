package com.spm.netgarage.dal.repository.phone;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.phone.ChipsetModel;

public interface ChipsetRepository extends MongoRepository<ChipsetModel, String> {
	
	public List<ChipsetModel> findByBrandmodel(String brandmodel);;

}
