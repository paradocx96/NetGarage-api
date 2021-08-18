package com.spm.netgarage.api.laptop;

import com.spm.netgarage.domain.laptop.LaptopProcessor;
import com.spm.netgarage.domain.laptop.LaptopProcessorDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopProcessorApi {

    private final LaptopProcessorDataAdapter laptopProcessorDataAdapter;

    @Autowired
    public LaptopProcessorApi(LaptopProcessorDataAdapter laptopProcessorDataAdapter) {
        this.laptopProcessorDataAdapter = laptopProcessorDataAdapter;
    }

    public LaptopProcessor saveLaptopProcessor(LaptopProcessor laptopProcessor) {
        return laptopProcessorDataAdapter.save(laptopProcessor);
    }

    public List<LaptopProcessor> getAllLaptopProcessor() {
        return laptopProcessorDataAdapter.getAll();
    }

    public List<LaptopProcessor> getLaptopProcessorById(String id) {
        return laptopProcessorDataAdapter.getById(id);
    }

    public LaptopProcessor updateLaptopProcessor(LaptopProcessor laptopProcessor) {
        return laptopProcessorDataAdapter.update(laptopProcessor);
    }

    public ResponseEntity<?> deleteLaptopProcessorById(String id) {
        return laptopProcessorDataAdapter.deleteById(id);
    }
}