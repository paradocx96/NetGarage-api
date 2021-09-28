package com.spm.netgarage.dal.adapter.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopBrandModel;
import com.spm.netgarage.dal.repository.laptop.LaptopBrandRepository;
import com.spm.netgarage.domain.laptop.LaptopBrand;
import com.spm.netgarage.domain.laptop.LaptopBrandDataAdapter;
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
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LaptopBrandAdapterMongoImpl implements LaptopBrandDataAdapter {

    public static final Logger LOGGER = Logger.getLogger(LaptopBrandAdapterMongoImpl.class.getName());

    private final LaptopBrandRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LaptopBrandAdapterMongoImpl(LaptopBrandRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public LaptopBrand save(LaptopBrand laptopBrand) {
        LaptopBrandModel laptopBrandModel = new LaptopBrandModel();

        laptopBrandModel.setName(laptopBrand.getName());
        laptopBrandModel.setUser(laptopBrand.getUser());
        laptopBrandModel.setDatetime(LocalDateTime.now());

        laptopBrandModel = repository.save(laptopBrandModel);
        laptopBrand.setId(laptopBrandModel.getId());
        laptopBrand.setDatetime(laptopBrandModel.getDatetime());

        return laptopBrand;
    }

    @Override
    public List<LaptopBrand> getAll() {
        List<LaptopBrandModel> laptopBrandModels = repository.findAll();
        List<LaptopBrand> laptopBrands = new ArrayList<>();

        for (LaptopBrandModel laptopBrandModel : laptopBrandModels) {
            LaptopBrand laptopBrand = new LaptopBrand();

            laptopBrand.setId(laptopBrandModel.getId());
            laptopBrand.setName(laptopBrandModel.getName());
            laptopBrand.setUser(laptopBrandModel.getUser());
            laptopBrand.setDatetime(laptopBrandModel.getDatetime());

            laptopBrands.add(laptopBrand);
        }
        return laptopBrands;
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        LaptopBrandModel laptopBrandModel = null;
        laptopBrandModel = repository.findById(id).get();

        if (laptopBrandModel != null) {
            try {
                repository.deleteById(id);
            } catch (NoSuchElementException exception) {
                exception.printStackTrace();
            }
            return ResponseEntity.ok(new MessageResponseDto("Deleted successfully!"));
        } else {
            return ResponseEntity.ok(new MessageResponseDto("Doesn't Exist!"));
        }
    }

    @Override
    public LaptopBrand update(LaptopBrand laptopBrand) {
        LaptopBrandModel laptopBrandModel = mongoTemplate.findAndModify(
                Query.query(Criteria.where("id").is(laptopBrand.getId())),
                new Update()
                        .set("name", laptopBrand.getName())
                        .set("user", laptopBrand.getUser()),
                LaptopBrandModel.class
        );
        laptopBrand.setDatetime(laptopBrandModel.getDatetime());

        return laptopBrand;
    }

    @Override
    public List<LaptopBrand> getById(String id) {
        LaptopBrandModel laptopBrandModel = new LaptopBrandModel();
        laptopBrandModel = repository.findById(id).get();
        List<LaptopBrand> laptopBrandList = new ArrayList<>();
        LaptopBrand laptopBrand = new LaptopBrand();

        laptopBrand.setId(laptopBrandModel.getId());
        laptopBrand.setName(laptopBrandModel.getName());
        laptopBrand.setUser(laptopBrandModel.getUser());
        laptopBrand.setDatetime(laptopBrandModel.getDatetime());

        laptopBrandList.add(laptopBrand);

        return laptopBrandList;
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
