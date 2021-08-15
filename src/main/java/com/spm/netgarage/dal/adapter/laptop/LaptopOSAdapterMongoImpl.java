package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.repository.laptop.LaptopOSRepository;
import com.spm.netgarage.domain.laptop.LaptopOS;
import com.spm.netgarage.domain.laptop.LaptopOSDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LaptopOSAdapterMongoImpl implements LaptopOSDataAdapter {

    private final LaptopOSRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopOSAdapterMongoImpl(LaptopOSRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public LaptopOS save(LaptopOS laptopOS) {
        return null;
    }

    @Override
    public List<LaptopOS> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        return null;
    }

    @Override
    public LaptopOS update(LaptopOS laptopOS) {
        return null;
    }

    @Override
    public List<LaptopOS> getById(String id) {
        return null;
    }
}
