package com.spm.netgarage.api.laptop;

import com.spm.netgarage.domain.laptop.LaptopBrand;
import com.spm.netgarage.domain.laptop.LaptopBrandDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopBrandApi {

    private final LaptopBrandDataAdapter laptopBrandDataAdapter;

    @Autowired
    public LaptopBrandApi(LaptopBrandDataAdapter laptopBrandDataAdapter) {
        this.laptopBrandDataAdapter = laptopBrandDataAdapter;
    }

    public LaptopBrand saveLaptopBrand(LaptopBrand laptopBrand) {
        return laptopBrandDataAdapter.save(laptopBrand);
    }

    public List<LaptopBrand> getAllLaptopBrand() {
        return laptopBrandDataAdapter.getAll();
    }

    public List<LaptopBrand> getLaptopBrandById(String id) {
        return laptopBrandDataAdapter.getById(id);
    }

    public LaptopBrand updateLaptopBrand(LaptopBrand laptopBrand) {
        return laptopBrandDataAdapter.update(laptopBrand);
    }

    public ResponseEntity<?> deleteLaptopBrandById(String id) {
        return laptopBrandDataAdapter.deleteById(id);
    }

    public boolean checkBrandAvailable(String brand) {
        return laptopBrandDataAdapter.findByName(brand);
    }
}