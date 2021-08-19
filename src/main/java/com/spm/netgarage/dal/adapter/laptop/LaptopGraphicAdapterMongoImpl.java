package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopGraphicModel;
import com.spm.netgarage.dal.repository.laptop.LaptopGraphicRepository;
import com.spm.netgarage.domain.laptop.LaptopGraphic;
import com.spm.netgarage.domain.laptop.LaptopGraphicDataAdapter;
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
        LaptopGraphicModel laptopGraphicModel = new LaptopGraphicModel();

        laptopGraphicModel.setName(laptopGraphic.getName());
        laptopGraphicModel.setUser(laptopGraphic.getUser());
        laptopGraphicModel.setDatetime(LocalDateTime.now());

        laptopGraphicModel = repository.save(laptopGraphicModel);
        laptopGraphic.setId(laptopGraphicModel.getId());
        laptopGraphic.setDatetime(laptopGraphicModel.getDatetime());

        return laptopGraphic;
    }

    @Override
    public List<LaptopGraphic> getAll() {
        List<LaptopGraphicModel> laptopGraphicModels = repository.findAll();
        List<LaptopGraphic> laptopGraphics = new ArrayList<>();

        for (LaptopGraphicModel laptopGraphicModel : laptopGraphicModels) {
            LaptopGraphic laptopGraphic = new LaptopGraphic();

            laptopGraphic.setId(laptopGraphicModel.getId());
            laptopGraphic.setName(laptopGraphicModel.getName());
            laptopGraphic.setUser(laptopGraphicModel.getUser());
            laptopGraphic.setDatetime(laptopGraphicModel.getDatetime());

            laptopGraphics.add(laptopGraphic);
        }
        return laptopGraphics;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        LaptopGraphicModel laptopGraphicModel = null;
        laptopGraphicModel = repository.findById(id).get();

        if (laptopGraphicModel != null) {
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
    public LaptopGraphic update(LaptopGraphic laptopGraphic) {
        LaptopGraphicModel laptopGraphicModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(laptopGraphic.getId())),
                new Update()
                        .set("name", laptopGraphic.getName())
                        .set("user", laptopGraphic.getUser()),
                LaptopGraphicModel.class
        );
        laptopGraphic.setDatetime(laptopGraphicModel.getDatetime());

        return laptopGraphic;
    }

    @Override
    public List<LaptopGraphic> getById(String id) {
        LaptopGraphicModel laptopGraphicModel = new LaptopGraphicModel();
        laptopGraphicModel = repository.findById(id).get();
        List<LaptopGraphic> laptopGraphicList = new ArrayList<>();
        LaptopGraphic LaptopGraphic = new LaptopGraphic();

        LaptopGraphic.setId(laptopGraphicModel.getId());
        LaptopGraphic.setName(laptopGraphicModel.getName());
        LaptopGraphic.setUser(laptopGraphicModel.getUser());
        LaptopGraphic.setDatetime(laptopGraphicModel.getDatetime());

        laptopGraphicList.add(LaptopGraphic);

        return laptopGraphicList;
    }
}
