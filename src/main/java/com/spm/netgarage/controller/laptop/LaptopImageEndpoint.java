package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.dal.adapter.laptop.LaptopImageMongoImpl;
import com.spm.netgarage.dal.model.laptop.LaptopImageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop-image")
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class LaptopImageEndpoint {

    private final LaptopImageMongoImpl imageMongo;

    @Autowired
    public LaptopImageEndpoint(LaptopImageMongoImpl imageMongo) {
        this.imageMongo = imageMongo;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LaptopImageModel addLaptopImage(@RequestBody LaptopImageModel laptopImageModel) {
        return imageMongo.save(laptopImageModel);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<LaptopImageModel> getAllLaptopImage() {
        return imageMongo.getAll();
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LaptopImageModel getLaptopImageById(@PathVariable String id) {
        return imageMongo.getById(id);
    }

    @GetMapping("/get-by-lid/{lid}")
    @ResponseStatus(HttpStatus.OK)
    public LaptopImageModel getLaptopImageByLid(@PathVariable String lid) {
        return imageMongo.getByLid(lid);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public LaptopImageModel updateLaptopImageByLid(@RequestBody LaptopImageModel laptopImageModel) {
        return imageMongo.updateByLid(laptopImageModel);
    }

    @PutMapping("/update-main")
    @ResponseStatus(HttpStatus.OK)
    public LaptopImageModel updateLaptopMainImageByLid(@RequestBody LaptopImageModel laptopImageModel) {
        return imageMongo.updateMainLinkByLid(laptopImageModel);
    }

    @DeleteMapping("/delete/{lid}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteLaptopImageByLid(@PathVariable String lid) {
        return imageMongo.deleteByLid(lid);
    }
}