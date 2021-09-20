package com.spm.netgarage.api.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopModel;
import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.domain.laptop.LaptopDataAdapter;
import com.spm.netgarage.domain.laptop.LaptopGenerateReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class LaptopApi {

    private final LaptopDataAdapter laptopDataAdapter;
    private final LaptopGenerateReport laptopGenerateReport;

    @Autowired
    public LaptopApi(LaptopDataAdapter laptopDataAdapter, LaptopGenerateReport laptopGenerateReport) {
        this.laptopDataAdapter = laptopDataAdapter;
        this.laptopGenerateReport = laptopGenerateReport;
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

    public List<Laptop> getLaptopByProcessorNameActivated(String processorname) {
        return laptopDataAdapter.findByProcessorname(processorname);
    }

    public ResponseEntity<InputStreamResource> generateReportLaptop() {
        List<Laptop> laptopList = (List<Laptop>) getAllLaptop();
        ByteArrayInputStream byteArrayInputStream = laptopGenerateReport.laptopReport(laptopList);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Laptops.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(byteArrayInputStream));
    }
}
