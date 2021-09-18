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
		
		//String brandAndModelSpaceRemoved = brandAndModel.replaceAll("\\s+", "");
		
		//System.out.println("Space removed chipset brand and model : " + brandAndModelSpaceRemoved);
		
		
		
		List<ChipsetDto> chipsetDtoList = new ArrayList<>();
		chipsetDtoList = this.getAllChipsets();
		
		for(ChipsetDto chipset : chipsetDtoList) {
			if(chipset.getBrandmodel().toLowerCase().equalsIgnoreCase(brandAndModel)) {
				return false;
			}
		}
		
		return true;
	}
	
	//get chipset by brand and model
	public List<ChipsetDto> getChipseByBrandModel(String brandModel) {
		
		System.out.println("Chipset API, Getting by brand model: brandmodel:" + brandModel);
		
		//ChipsetDto chipsetDto = new ChipsetDto();
		//ChipsetModel chipsetModel = new ChipsetModel();
		
		List<ChipsetModel> chipsetModelList = new ArrayList<>();
		List<ChipsetModel> filteredChipsetModelList = new ArrayList<>();
		List<ChipsetDto> chipsetDtoList = new ArrayList<>();
		
		chipsetModelList = chipsetDataAdapter.getAll();
		
		for(ChipsetModel chipsetModel : chipsetModelList) {
			System.out.println("Chipset brand model : "+chipsetModel.getBrandmodel());
			if(chipsetModel.getBrandmodel().replaceAll("\\s+", "").equalsIgnoreCase(brandModel.replaceAll("\\s+", ""))) {
				filteredChipsetModelList.add(chipsetModel);
			}
			
			/*if(chipsetModel.getBrandmodel().toLowerCase().equals(brandModel.toLowerCase())) {
				filteredChipsetModelList.add(chipsetModel);
			}*/
		}
		
		//chipsetModelList = chipsetDataAdapter.getByBrandAndModel(brandModel);
		
		for(ChipsetModel chipsetModel : filteredChipsetModelList) {
			ChipsetDto chipsetDto = new ChipsetDto();
			
			chipsetDto.setId(chipsetModel.getId());
			chipsetDto.setBrandmodel(chipsetModel.getBrandmodel());
			chipsetDto.setCpu(chipsetModel.getCpu());
			chipsetDto.setGpu(chipsetModel.getGpu());
			chipsetDto.setLithography(chipsetModel.getLithography());
			
			chipsetDtoList.add(chipsetDto);
		}
		
		
		
		return chipsetDtoList;
	}
}
