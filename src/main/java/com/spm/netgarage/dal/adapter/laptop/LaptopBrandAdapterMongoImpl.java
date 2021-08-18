package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopBrandModel;
import com.spm.netgarage.dal.repository.laptop.LaptopBrandRepository;
import com.spm.netgarage.domain.laptop.LaptopBrand;
import com.spm.netgarage.domain.laptop.LaptopBrandDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class LaptopBrandAdapterMongoImpl implements LaptopBrandDataAdapter {

    private final LaptopBrandRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopBrandAdapterMongoImpl(LaptopBrandRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public LaptopBrand save(LaptopBrand laptopBrand) {
        LaptopBrandModel laptopBrandModel = new LaptopBrandModel();

        laptopBrandModel.setName(laptopBrand.getName());
        laptopBrandModel.setUser(laptopBrand.getUser());
        laptopBrandModel.setDatetime(LocalDateTime.now());

        laptopBrandModel = repository.save(laptopBrandModel);
        laptopBrand.setId(laptopBrandModel.getId());

        return laptopBrand;
    }

    @Override
    public List<LaptopBrand> getAll() {
        List<LaptopBrandModel> laptopBrandModels = repository.findAll();
        List<LaptopBrand> laptopBrands = new ArrayList<>();

        for (LaptopBrandModel laptopBrandModel : laptopBrandModels) {
            LaptopBrand laptopBrand = new LaptopBrand();

            laptopBrand.setId(laptopBrandModel.getId());
            laptopBrand.setName(laptopBrandModel.getName());
            laptopBrand.setUser(laptopBrandModel.getUser());
            laptopBrand.setDatetime(laptopBrandModel.getDatetime());

            laptopBrands.add(laptopBrand);
        }
        return laptopBrands;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        return null;
    }

    @Override
    public LaptopBrand update(LaptopBrand laptopBrand) {
        return null;
    }

    @Override
    public List<LaptopBrand> getById(String id) {
        return null;
    }
}
