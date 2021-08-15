package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.api.laptop.LaptopApi;
import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.dto.laptop.LaptopDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopEndpoint {

    private final LaptopApi laptopApi;

    @Autowired
    public LaptopEndpoint(LaptopApi laptopApi) {
        this.laptopApi = laptopApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop addLaptop(@RequestBody LaptopDto laptopDto) {
        return null;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getAllLaptop() {
        return null;
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopById(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopById(@PathVariable String id) {
        return null;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptop(@RequestBody LaptopDto laptopDto, @PathVariable String id) {
        return null;
    }

    @PutMapping("/update-status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptopStatus(@RequestBody LaptopDto laptopDto, @PathVariable String id) {
        return null;
    }

    @GetMapping("/get-by-status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Laptop> getLaptopByStatus(@PathVariable String status) {
        return null;
    }

}