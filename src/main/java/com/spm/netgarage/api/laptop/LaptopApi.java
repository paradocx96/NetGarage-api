package com.spm.netgarage.api.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopModel;
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
        return laptopDataAdapter.save(laptop);
    }

    public List<Laptop> getAllLaptop() {
        return laptopDataAdapter.getAll();
    }

    public List<Laptop> getLaptopById(String id) {
        return laptopDataAdapter.getById(id);
    }

    public Laptop updateLaptop(Laptop laptop) {
        return laptopDataAdapter.update(laptop);
    }

    public ResponseEntity<?> deleteLaptopById(String id) {
        return laptopDataAdapter.deleteById(id);
    }

    public List<Laptop> getLaptopByStatus(String status) {
        return laptopDataAdapter.getByStatus(status);
    }

    public Laptop updateLaptopStatus(Laptop laptop) {
        return laptopDataAdapter.updateStatus(laptop);
    }

    public LaptopModel getLaptopObjectById(String id) {
        return laptopDataAdapter.getObjectById(id);
    }

    public Laptop updateLaptopImage(Laptop laptop) {
        return laptopDataAdapter.updateImage(laptop);
    }

    public ResponseEntity<?> deleteAllLaptop(List<String> ids) {
        return laptopDataAdapter.deleteAll(ids);
    }

    public List<Laptop> getLaptopByBrandActivated(String brand) {
        return laptopDataAdapter.findByBrand(brand);
    }

    public List<Laptop> getLaptopByRamCapacityActivated(String ramcapacity) {
        return laptopDataAdapter.findByRamcapacity(ramcapacity);
    }
}
