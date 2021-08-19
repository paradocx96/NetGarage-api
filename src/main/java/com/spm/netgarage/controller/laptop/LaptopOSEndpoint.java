package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.api.laptop.LaptopOSApi;
import com.spm.netgarage.domain.laptop.LaptopOS;
import com.spm.netgarage.dto.laptop.LaptopOSDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop-os")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopOSEndpoint {

    private final LaptopOSApi laptopOSApi;

    @Autowired
    public LaptopOSEndpoint(LaptopOSApi laptopOSApi) {
        this.laptopOSApi = laptopOSApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LaptopOS addLaptopOS(@RequestBody LaptopOSDto laptopOSDto) {
        LaptopOS laptopOS = new LaptopOS();

        laptopOS.setName(laptopOSDto.getName());
        laptopOS.setUser(laptopOSDto.getUser());

        return laptopOSApi.saveLaptopOS(laptopOS);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopOS> getAllLaptopOS() {
        return laptopOSApi.getAllLaptopOS();
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopOS> getLaptopOSById(@PathVariable String id) {
        return laptopOSApi.getLaptopOSById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopOSById(@PathVariable String id) {
        return laptopOSApi.deleteLaptopOSById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public LaptopOS updateLaptopOS(@RequestBody LaptopOSDto laptopOSDto) {
        LaptopOS laptopOS = new LaptopOS();

        laptopOS.setId(laptopOSDto.getId());
        laptopOS.setName(laptopOSDto.getName());
        laptopOS.setUser(laptopOSDto.getUser());

        return laptopOSApi.updateLaptopOS(laptopOS);
    }
}