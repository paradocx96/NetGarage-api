package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopImageModel;
import com.spm.netgarage.dal.repository.laptop.LaptopImageRepository;
import com.spm.netgarage.dto.MessageResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class LaptopImageMongoImpl {

    private final LaptopImageRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopImageMongoImpl(LaptopImageRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

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

    public LaptopImageModel getById(String id) {
        return repository.findById(id).get();
    }

    public List<LaptopImageModel> getByLid(String lid) {
        return repository.findByLid(lid);
    }

    public LaptopImageModel updateByLid(LaptopImageModel laptopImageModel) {
        LaptopImageModel imageModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("lid").is(laptopImageModel.getLid())),
                new Update()
                        .set("link", laptopImageModel.getLink())
                        .set("user", laptopImageModel.getUser()),
                LaptopImageModel.class
        );
        laptopImageModel.setId(imageModel.getId());
        laptopImageModel.setDatetime(imageModel.getDatetime());

        return laptopImageModel;
    }

    public ResponseEntity<?> deleteByLid(String lid) {
        LaptopImageModel laptopImageModel = null;
        laptopImageModel = repository.getByLid(lid);

        if (laptopImageModel != null) {
            try {
                repository.deleteByLid(lid);
            } catch (NoSuchElementException exception) {
                exception.printStackTrace();
            }
            return ResponseEntity.ok(new MessageResponseDto("Deleted successfully!"));
        } else {
            return ResponseEntity.ok(new MessageResponseDto("Doesn't Exist!"));
        }
    }
}