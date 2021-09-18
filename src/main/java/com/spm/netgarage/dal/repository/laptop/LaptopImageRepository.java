package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopImageModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopImageRepository extends MongoRepository<LaptopImageModel,String> {

    LaptopImageModel findByLid(String lid);

    LaptopImageModel getByLid(String lid);

    LaptopImageModel deleteByLid(String lid);
}
