package com.spm.netgarage.api.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spm.netgarage.dal.model.phone.ChipsetModel;
import com.spm.netgarage.domain.phone.ChipsetDataAdapter;
import com.spm.netgarage.dto.phone.ChipsetDto;

@Service
public class ChipsetApi {
	
	private final ChipsetDataAdapter chipsetDataAdapter;
	
	@Autowired
	public ChipsetApi(ChipsetDataAdapter chipsetDataAdapter) {
		this.chipsetDataAdapter = chipsetDataAdapter;
	}

	//adds a chipset entry
	public String addChipset(ChipsetDto chipsetDto) {
		//initialize chipset model
		ChipsetModel chipsetModel = new ChipsetModel();
		chipsetModel.setBrandmodel(chipsetDto.getBrandmodel());
		chipsetModel.setCpu(chipsetDto.getCpu());
		chipsetModel.setGpu(chipsetDto.getGpu());
		chipsetModel.setLithography(chipsetDto.getLithography());
		
		return chipsetDataAdapter.save(chipsetModel);
		
	}
	
	//gets all chipset entries
	public List<ChipsetDto> getAllChipsets(){
		
		//initialize chipsetModelList
		List<ChipsetModel> chipsetModelList = new ArrayList<>();
		
		//get the chipsetModel list
		chipsetModelList = chipsetDataAdapter.getAll();
		//initialize chipsetDtoList
		List<ChipsetDto> chipsetDtoList = new ArrayList<>();
		
		//iterate through the model list
		for(ChipsetModel chipsetModel : chipsetModelList) {
			//initialize chipset DTO
			ChipsetDto chipsetDto = new ChipsetDto();
			//set the data to the dto
			chipsetDto.setId(chipsetModel.getId());
			chipsetDto.setBrandmodel(chipsetModel.getBrandmodel());
			chipsetDto.setCpu(chipsetModel.getCpu());
			chipsetDto.setGpu(chipsetModel.getGpu());
			chipsetDto.setLithography(chipsetModel.getLithography());
			
			//add the item to chipset DTO
			chipsetDtoList.add(chipsetDto);
		}
		
		//return the DTO list
		return chipsetDtoList;
		//return chipsetDataAdapter.getAll();
	}
	
	public ChipsetDto getChipsetById(String id) {
		
		//get the chipset model by id
		ChipsetModel chipsetModel = chipsetDataAdapter.getById(id);
		//initialize chipset dto
		ChipsetDto chipsetDto = new ChipsetDto();
		
		//set the data to the dto
		chipsetDto.setId(chipsetModel.getId());
		chipsetDto.setBrandmodel(chipsetModel.getBrandmodel());
		chipsetDto.setCpu(chipsetModel.getCpu());
		chipsetDto.setGpu(chipsetModel.getGpu());
		chipsetDto.setLithography(chipsetModel.getLithography());
		
		//return the set dto
		return chipsetDto;
	}
	
	
	public String updateChipsetEntry(ChipsetDto chipsetDto) {
		
		ChipsetModel chipsetModel = new ChipsetModel();
		
		chipsetModel.setId(chipsetDto.getId());
		chipsetModel.setBrandmodel(chipsetDto.getBrandmodel());
		chipsetModel.setCpu(chipsetDto.getCpu());
		chipsetModel.setGpu(chipsetDto.getGpu());
		chipsetModel.setLithography(chipsetDto.getLithography());
		
		return chipsetDataAdapter.updateById(chipsetDto.getId(), chipsetModel);
		
	}
	
	//delete a chipset entry
	public String deleteChipset(String id) {
		return chipsetDataAdapter.delete(id);
	}
	
	//checks the availability of the chipset
	public boolean isChipsetAvailable(String brandAndModel) {
		
		
		ChipsetModel chipsetModel = new ChipsetModel();
		//get the chipsetModel for the brandAndModel
		chipsetModel = 	chipsetDataAdapter.getByBrandAndModel(brandAndModel);
		
		//if the model id is empty return true
		if(chipsetModel == null) {
			return true;
		}
		else {
			//id is not empty
			//the name is taken
			//return false
			return false;
		}
	}
	
	//get chipset by brand and model
	public ChipsetDto getChipseByBrandModel(String brandModel) {
		
		ChipsetDto chipsetDto = new ChipsetDto();
		ChipsetModel chipsetModel = new ChipsetModel();
		
		chipsetModel = chipsetDataAdapter.getByBrandAndModel(brandModel);
		
		chipsetDto.setId(chipsetModel.getId());
		chipsetDto.setBrandmodel(chipsetModel.getBrandmodel());
		chipsetDto.setCpu(chipsetModel.getCpu());
		chipsetDto.setGpu(chipsetModel.getGpu());
		chipsetDto.setLithography(chipsetModel.getLithography());
		
		return chipsetDto;
	}
}
