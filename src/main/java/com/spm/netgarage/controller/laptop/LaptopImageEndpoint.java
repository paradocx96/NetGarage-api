package com.spm.netgarage.controller.laptop;

import com.spm.netgarage.dal.adapter.laptop.LaptopImageMongoImpl;
import com.spm.netgarage.dal.model.laptop.LaptopImageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

}