package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.repository.laptop.LaptopBrandRepository;
import com.spm.netgarage.domain.laptop.LaptopBrand;
import com.spm.netgarage.domain.laptop.LaptopBrandDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public List<LaptopBrand> getAll() {
        return null;
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
