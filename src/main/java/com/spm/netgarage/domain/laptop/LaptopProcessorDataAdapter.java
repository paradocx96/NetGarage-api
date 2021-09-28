package com.spm.netgarage.domain.laptop;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopProcessorDataAdapter {

    LaptopProcessor save(LaptopProcessor laptopProcessor);

    List<LaptopProcessor> getAll();

    ResponseEntity<?> deleteById(String id);

    LaptopProcessor update(LaptopProcessor laptopProcessor);

    List<LaptopProcessor> getById(String id);

    boolean findByName(String name);
}
