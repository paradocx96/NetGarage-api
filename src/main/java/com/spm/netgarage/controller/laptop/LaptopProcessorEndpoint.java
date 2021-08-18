package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.api.laptop.LaptopProcessorApi;
import com.spm.netgarage.domain.laptop.LaptopProcessor;
import com.spm.netgarage.dto.laptop.LaptopProcessorDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop-processor")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopProcessorEndpoint {

    private final LaptopProcessorApi laptopProcessorApi;

    @Autowired
    public LaptopProcessorEndpoint(LaptopProcessorApi laptopProcessorApi) {
        this.laptopProcessorApi = laptopProcessorApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LaptopProcessor addLaptopProcessor(@RequestBody LaptopProcessorDto laptopProcessorDto) {
        return null;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopProcessor> getAllLaptopProcessor() {
        return null;
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopProcessor> getLaptopProcessorById(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopProcessorById(@PathVariable String id) {
        return null;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LaptopProcessor updateLaptopProcessor(@RequestBody LaptopProcessorDto laptopProcessorDto, @PathVariable String id) {
        return null;
    }
}