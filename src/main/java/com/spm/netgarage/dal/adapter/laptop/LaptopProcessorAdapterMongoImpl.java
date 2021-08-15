package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.repository.laptop.LaptopProcessorRepository;
import com.spm.netgarage.domain.laptop.LaptopProcessor;
import com.spm.netgarage.domain.laptop.LaptopProcessorDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LaptopProcessorAdapterMongoImpl implements LaptopProcessorDataAdapter {

    private final LaptopProcessorRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopProcessorAdapterMongoImpl(LaptopProcessorRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public LaptopProcessor save(LaptopProcessor laptopProcessor) {
        return null;
    }

    @Override
    public List<LaptopProcessor> getAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public LaptopProcessor update(LaptopProcessor laptopProcessor) {
        return null;
    }

    @Override
    public List<LaptopProcessor> getById(String id) {
        return null;
    }
}
