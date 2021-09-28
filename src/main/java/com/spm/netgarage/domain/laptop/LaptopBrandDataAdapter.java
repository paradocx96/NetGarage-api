package com.spm.netgarage.domain.laptop;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopBrandDataAdapter {

    LaptopBrand save(LaptopBrand laptopBrand);

    List<LaptopBrand> getAll();

    ResponseEntity<?> deleteById(String id);

    LaptopBrand update(LaptopBrand laptopBrand);

    List<LaptopBrand> getById(String id);

    boolean findByName(String name);
}
