package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopBrandModel;
import com.spm.netgarage.dal.model.laptop.LaptopImageModel;
import com.spm.netgarage.dal.repository.laptop.LaptopImageRepository;

import com.spm.netgarage.domain.laptop.LaptopBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class LaptopImageMongoImpl {

    private final LaptopImageRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopImageMongoImpl(LaptopImageRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

//    String id,
//    String lid,
//    List<String> link,
//    String user,
//    LocalDateTime datetime

    public LaptopImageModel save(LaptopImageModel laptopImageModel) {

        LaptopImageModel imageModel = new LaptopImageModel();

        imageModel.setLid(laptopImageModel.getLid());
        imageModel.setLink(laptopImageModel.getLink());
        imageModel.setUser(laptopImageModel.getUser());
        imageModel.setDatetime(LocalDateTime.now());

        imageModel = repository.save(imageModel);
        laptopImageModel.setId(imageModel.getId());
        laptopImageModel.setDatetime(imageModel.getDatetime());

        return laptopImageModel;
    }

    public List<LaptopImageModel> getAll() {
        return repository.findAll();
    }
}
