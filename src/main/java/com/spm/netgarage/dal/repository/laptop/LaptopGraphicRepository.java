package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopGraphicModel;

import com.spm.netgarage.domain.laptop.LaptopGraphic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopGraphicRepository extends MongoRepository<LaptopGraphicModel, String> {

    LaptopGraphic findByName(String name);
}
