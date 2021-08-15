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
        return null;
    }

    public List<LaptopOS> getAllLaptopOS() {
        return null;
    }

    public List<LaptopOS> getLaptopOSById(String id) {
        return null;
    }

    public LaptopOS updateLaptopOS(LaptopOS laptopOS) {
        return null;
    }

    public ResponseEntity<?> deleteLaptopOSById(String id) {
        return null;
    }
}
