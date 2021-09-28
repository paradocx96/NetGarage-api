package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopProcessorModel;
import com.spm.netgarage.dal.repository.laptop.LaptopProcessorRepository;
import com.spm.netgarage.domain.laptop.LaptopProcessor;
import com.spm.netgarage.domain.laptop.LaptopProcessorDataAdapter;
import com.spm.netgarage.dto.MessageResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LaptopProcessorAdapterMongoImpl implements LaptopProcessorDataAdapter {

    public static final Logger LOGGER = Logger.getLogger(LaptopProcessorAdapterMongoImpl.class.getName());

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
        laptopProcessor.setDatetime(laptopProcessorModel.getDatetime());

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
        LaptopProcessorModel laptopProcessorModel = null;
        laptopProcessorModel = repository.findById(id).get();

        if (laptopProcessorModel != null) {
            try {
                repository.deleteById(id);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return ResponseEntity.ok(new MessageResponseDto("Deleted successfully!"));
        } else {
            return ResponseEntity.ok(new MessageResponseDto("Doesn't Exist!"));
        }
    }

    @Override
    public LaptopProcessor update(LaptopProcessor laptopProcessor) {
        LaptopProcessorModel laptopProcessorModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(laptopProcessor.getId())),
                new Update()
                        .set("name", laptopProcessor.getName())
                        .set("user", laptopProcessor.getUser()),
                LaptopProcessorModel.class
        );
        laptopProcessor.setDatetime(laptopProcessorModel.getDatetime());

        return laptopProcessor;
    }

    @Override
    public List<LaptopProcessor> getById(String id) {
        LaptopProcessorModel laptopProcessorModel = new LaptopProcessorModel();
        laptopProcessorModel = repository.findById(id).get();
        List<LaptopProcessor> laptopProcessorList = new ArrayList<>();
        LaptopProcessor laptopProcessor = new LaptopProcessor();

        laptopProcessor.setId(laptopProcessorModel.getId());
        laptopProcessor.setName(laptopProcessorModel.getName());
        laptopProcessor.setUser(laptopProcessorModel.getUser());
        laptopProcessor.setDatetime(laptopProcessorModel.getDatetime());

        laptopProcessorList.add(laptopProcessor);

        return laptopProcessorList;
    }

    @Override
    public boolean findByName(String name) {
        boolean isAvailable = false;
        try {
            String value = repository.findByName(name).getName();
            if (value != null) {
                isAvailable = true;
            }
            return isAvailable;
        } catch (NullPointerException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return isAvailable;
        }
    }
}
