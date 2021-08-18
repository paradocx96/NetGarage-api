package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopOSModel;
import com.spm.netgarage.dal.repository.laptop.LaptopOSRepository;
import com.spm.netgarage.domain.laptop.LaptopOS;
import com.spm.netgarage.domain.laptop.LaptopOSDataAdapter;

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
        LaptopOSModel laptopOSModel = new LaptopOSModel();
        laptopOSModel.setName(laptopOS.getName());
        laptopOSModel.setUser(laptopOS.getUser());
        laptopOSModel.setDatetime(LocalDateTime.now());
        laptopOSModel = repository.save(laptopOSModel);
        laptopOS.setId(laptopOSModel.getId());

        return laptopOS;
    }

    @Override
    public List<LaptopOS> getAll() {
        List<LaptopOSModel> laptopOSModels = repository.findAll();
        List<LaptopOS> laptopOSList = new ArrayList<>();

        for (LaptopOSModel laptopOSModel : laptopOSModels) {
            LaptopOS laptopOS = new LaptopOS();

            laptopOS.setId(laptopOSModel.getId());
            laptopOS.setName(laptopOSModel.getName());
            laptopOS.setUser(laptopOSModel.getUser());
            laptopOS.setDatetime(laptopOSModel.getDatetime());

            laptopOSList.add(laptopOS);
        }
        return laptopOSList;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        LaptopOSModel laptopOSModel = null;
        laptopOSModel = repository.findById(id).get();

        if (laptopOSModel != null) {
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
    public LaptopOS update(LaptopOS laptopOS) {
        LaptopOSModel laptopOSModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(laptopOS.getId())),
                new Update()
                        .set("name", laptopOS.getName())
                        .set("user", laptopOS.getUser()),
                LaptopOSModel.class
        );
        laptopOS.setDatetime(laptopOSModel.getDatetime());

        return laptopOS;
    }

    @Override
    public List<LaptopOS> getById(String id) {
        return null;
    }
}
