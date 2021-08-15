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
        return null;
    }

    public List<LaptopBrand> getAllLaptopBrand() {
        return null;
    }

    public List<LaptopBrand> getLaptopBrandById(String id) {
        return null;
    }

    public LaptopBrand updateLaptopBrand(LaptopBrand laptopBrand) {
        return null;
    }

    public ResponseEntity<?> deleteLaptopBrandById(String id) {
        return null;
    }
}
