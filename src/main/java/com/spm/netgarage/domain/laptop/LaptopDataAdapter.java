package com.spm.netgarage.domain.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopModel;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LaptopDataAdapter {

    Laptop save(Laptop laptop);

    List<Laptop> getAll();

    ResponseEntity<?> deleteById(String id);

    Laptop update(Laptop laptop);

    List<Laptop> getById(String id);

    Laptop updateStatus(Laptop laptop);

    List<Laptop> getByStatus(String status);

    LaptopModel getObjectById(String id);

    Laptop updateImage(Laptop laptop);

    ResponseEntity<?> deleteAll(List<String> ids);
}
