package com.spm.netgarage.api.laptop;

import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.domain.laptop.LaptopDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopApi {

    private final LaptopDataAdapter laptopDataAdapter;

    @Autowired
    public LaptopApi(LaptopDataAdapter laptopDataAdapter) {
        this.laptopDataAdapter = laptopDataAdapter;
    }

    public Laptop saveLaptop(Laptop laptop) {
        return null;
    }

    public List<Laptop> getAllLaptop() {
        return null;
    }

    public List<Laptop> getLaptopById(String id) {
        return null;
    }

    public Laptop updateLaptop(Laptop laptop) {
        return null;
    }

    public ResponseEntity<?> deleteLaptopById(String id) {
        return null;
    }

    public List<Laptop> getLaptopByStatus(String status) {
        return null;
    }

    public Laptop updateLaptopStatus(Laptop laptop) {
        return null;
    }
}
