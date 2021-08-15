package com.spm.netgarage.domain.laptop;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopOSDataAdapter {

    LaptopOS save(LaptopOS laptopOS);

    List<LaptopOS> getAll();

    ResponseEntity<?> deleteById(String id);

    LaptopOS update(LaptopOS laptopOS);

    List<LaptopOS> getById(String id);
}
