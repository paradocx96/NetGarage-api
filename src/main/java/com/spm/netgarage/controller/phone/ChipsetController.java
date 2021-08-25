package com.spm.netgarage.controller.phone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spm.netgarage.api.phone.ChipsetApi;
import com.spm.netgarage.dto.phone.ChipsetDto;

@RestController
@RequestMapping("/api/phone/chipset/")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class ChipsetController {

	private ChipsetApi chipsetApi;

	@Autowired
	public ChipsetController(ChipsetApi chipsetApi) {
		this.chipsetApi = chipsetApi;
	}

	@PostMapping("addChipset")
	public String addChipset(@RequestBody ChipsetDto chipsetDto) {
		return chipsetApi.addChipset(chipsetDto);
	}

	@GetMapping("getAllChipsets")
	public List<ChipsetDto> getAllChipsets() {
		return chipsetApi.getAllChipsets();
	}

	@GetMapping("getChipsetById/{id}")
	public ChipsetDto getChipsetById(@PathVariable String id) {
		return chipsetApi.getChipsetById(id);
	}

	@DeleteMapping("deleteChipset/{id}")
	public String deleteChipset(@PathVariable String id) {
		return chipsetApi.deleteChipset(id);
	}

	@PutMapping("updateChipset")
	public String updateChipset(@RequestBody ChipsetDto chipsetDto) {
		return chipsetApi.updateChipsetEntry(chipsetDto);
	}

	@GetMapping("isChipsetAvailable/{brandAndModel}") 
	public boolean isChipsetAvailable(@PathVariable String brandAndModel) { 
		return chipsetApi.isChipsetAvailable(brandAndModel); }
	 

}
