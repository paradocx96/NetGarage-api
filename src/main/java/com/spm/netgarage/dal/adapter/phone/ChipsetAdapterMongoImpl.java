package com.spm.netgarage.dal.adapter.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.spm.netgarage.dal.model.phone.ChipsetModel;
import com.spm.netgarage.dal.repository.phone.ChipsetRepository;
import com.spm.netgarage.domain.phone.ChipsetDataAdapter;

@Component
public class ChipsetAdapterMongoImpl implements ChipsetDataAdapter {
	
	private ChipsetRepository chipsetRepository;
	//private MongoTemplate mongoTemplate;
	
	@Autowired
	public ChipsetAdapterMongoImpl(ChipsetRepository chipsetRepository) {
		this.chipsetRepository = chipsetRepository;
		//this.mongoTemplate = mongoTemplate;
	}

	//save a chipset entry
	@Override
	public String save(ChipsetModel chipset) {
		ChipsetModel addedChipset = chipsetRepository.save(chipset);
		System.out.println("Added chipset model: ");
		System.out.println(addedChipset.toString());
		return addedChipset.getId();
	}

	//returns all chipset entries
	@Override
	public List<ChipsetModel> getAll() {
		System.out.println("Returning all chipset entries from chipsetRepository");
		return chipsetRepository.findAll();
	}

	//returns chipset on given id
	@Override
	public ChipsetModel getById(String id) {
		System.out.println("Returning chipset for id : " + id);
		return chipsetRepository.findById(id).get();
	}

	//update chipset
	@Override
	public String updateById(String id, ChipsetModel chipset) {
		System.out.println("Updating chipset with id : " + chipset.getId());
		ChipsetModel addedChipset = chipsetRepository.save(chipset);
		return addedChipset.getId();
	}

	//delete chipset by id
	@Override
	public String delete(String id) {
		System.out.println("Deleting chipset entry with id : " + id);
		chipsetRepository.deleteById(id);
		return id;
	}

	
	//returns the chipset on the given brand and model
	@Override
	public List<ChipsetModel> getByBrandAndModel(String brandAndModel) {
		List<ChipsetModel> chipsetModelList = new ArrayList<>();
		chipsetModelList =  chipsetRepository.findByBrandmodel(brandAndModel);
		return chipsetModelList;
	}

	@Override
	public ChipsetModel getSingleByBrandAndModel(String brandAndModel) {
		// TODO Auto-generated method stub
		return chipsetRepository.findByBrandmodel(brandAndModel).get(0);
	}

}
