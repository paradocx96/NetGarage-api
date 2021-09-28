package com.spm.netgarage.api.laptop;

import com.spm.netgarage.domain.laptop.LaptopOS;
import com.spm.netgarage.domain.laptop.LaptopOSDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopOSApi {

    private final LaptopOSDataAdapter laptopOSDataAdapter;

    @Autowired
    public LaptopOSApi(LaptopOSDataAdapter laptopOSDataAdapter) {
        this.laptopOSDataAdapter = laptopOSDataAdapter;
    }

    public LaptopOS saveLaptopOS(LaptopOS laptopOS) {
        return laptopOSDataAdapter.save(laptopOS);
    }

    public List<LaptopOS> getAllLaptopOS() {
        return laptopOSDataAdapter.getAll();
    }

    public List<LaptopOS> getLaptopOSById(String id) {
        return laptopOSDataAdapter.getById(id);
    }

    public LaptopOS updateLaptopOS(LaptopOS laptopOS) {
        return laptopOSDataAdapter.update(laptopOS);
    }

    public ResponseEntity<?> deleteLaptopOSById(String id) {
        return laptopOSDataAdapter.deleteById(id);
    }

    public boolean checkAvailable(String name) {
        return laptopOSDataAdapter.findByName(name);
    }
}