package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.api.laptop.LaptopBrandApi;
import com.spm.netgarage.domain.laptop.LaptopBrand;
import com.spm.netgarage.dto.laptop.LaptopBrandDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop-brand")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopBrandEndpoint {

    private final LaptopBrandApi laptopBrandApi;

    @Autowired
    public LaptopBrandEndpoint(LaptopBrandApi laptopBrandApi) {
        this.laptopBrandApi = laptopBrandApi;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LaptopBrand addLaptopBrand(@RequestBody LaptopBrandDto laptopBrandDto) {
        return null;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopBrand> getAllLaptopBrand() {
        return null;
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopBrand> getLaptopBrandById(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopBrandById(@PathVariable String id) {
        return null;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LaptopBrand updateLaptopBrand(@RequestBody LaptopBrandDto laptopBrandDto, @PathVariable String id) {
        return null;
    }
}
