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

import com.spm.netgarage.api.phone.OSApi;
import com.spm.netgarage.dto.phone.OSDto;

@RestController
@RequestMapping("/api/phone/os")
@CrossOrigin(origins ="*",allowedHeaders = "*",exposedHeaders = "*")
public class OSController {

	private OSApi osApi;
	
	@Autowired
	public OSController(OSApi osApi) {
		this.osApi =  osApi;
	}
	
	@PostMapping("addOS")
	public OSDto addOS (@RequestBody OSDto osDto) {
		System.out.println("Controller OSDTO name: " + osDto.getName());
		return osApi.addOS(osDto);
	}
	
	@GetMapping("getAllOS")
	public List<OSDto> getAllOSes(){
		return osApi.getAllOS();
	}
	
	@GetMapping("getOSById/{id}")
	public OSDto getOSById(@PathVariable String id) {
		return osApi.findOSById(id);
	}
	
	@PutMapping("update")
	public String updateOS(@RequestBody OSDto osDto) {
		return osApi.updateOS(osDto);
	}
	
	@DeleteMapping("deleteOS/{id}")
	public String deleteOS( @PathVariable String id) {
		return osApi.deleteOS(id);
	}
	
	@GetMapping("isOsNameAvailable/{name}")
	public boolean isOsNameAvailable(@PathVariable String name) {
		return osApi.isNameAvailable(name);
	}
}
