package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.repository.laptop.LaptopGraphicRepository;
import com.spm.netgarage.domain.laptop.LaptopGraphic;
import com.spm.netgarage.domain.laptop.LaptopGraphicDataAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LaptopGraphicAdapterMongoImpl implements LaptopGraphicDataAdapter {

    private final LaptopGraphicRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopGraphicAdapterMongoImpl(LaptopGraphicRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public LaptopGraphic save(LaptopGraphic laptopGraphic) {
        return null;
    }

    @Override
    public List<LaptopGraphic> getAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public LaptopGraphic update(LaptopGraphic laptopGraphic) {
        return null;
    }

    @Override
    public List<LaptopGraphic> getById(String id) {
        return null;
    }
}
