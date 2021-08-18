package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopProcessorModel;
import com.spm.netgarage.dal.repository.laptop.LaptopProcessorRepository;
import com.spm.netgarage.domain.laptop.LaptopProcessor;
import com.spm.netgarage.domain.laptop.LaptopProcessorDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        LaptopProcessorModel laptopProcessorModel = new LaptopProcessorModel();
        laptopProcessorModel.setName(laptopProcessor.getName());
        laptopProcessorModel.setUser(laptopProcessor.getUser());
        laptopProcessorModel.setDatetime(LocalDateTime.now());
        laptopProcessorModel = repository.save(laptopProcessorModel);
        laptopProcessor.setId(laptopProcessorModel.getId());

        return laptopProcessor;
    }

    @Override
    public List<LaptopProcessor> getAll() {
        List<LaptopProcessorModel> laptopProcessorModels = repository.findAll();
        List<LaptopProcessor> laptopProcessorList = new ArrayList<>();

        for (LaptopProcessorModel laptopProcessorModel : laptopProcessorModels) {
            LaptopProcessor laptopProcessor = new LaptopProcessor();

            laptopProcessor.setId(laptopProcessorModel.getId());
            laptopProcessor.setName(laptopProcessorModel.getName());
            laptopProcessor.setUser(laptopProcessorModel.getUser());
            laptopProcessor.setDatetime(laptopProcessorModel.getDatetime());

            laptopProcessorList.add(laptopProcessor);
        }
        return laptopProcessorList;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        return null;
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
