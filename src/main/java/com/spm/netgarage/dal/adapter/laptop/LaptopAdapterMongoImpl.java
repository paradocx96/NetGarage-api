package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.repository.laptop.LaptopRepository;
import com.spm.netgarage.domain.laptop.Laptop;
import com.spm.netgarage.domain.laptop.LaptopDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LaptopAdapterMongoImpl implements LaptopDataAdapter {

    private final LaptopRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopAdapterMongoImpl(LaptopRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Laptop save(Laptop laptop) {
        return null;
    }

    @Override
    public List<Laptop> getAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Laptop update(Laptop laptop) {
        return null;
    }

    @Override
    public List<Laptop> getById(String id) {
        return null;
    }

    @Override
    public Laptop updateStatus(Laptop laptop) {
        return null;
    }

    @Override
    public List<Laptop> getByStatus(String status) {
        return null;
    }
}
