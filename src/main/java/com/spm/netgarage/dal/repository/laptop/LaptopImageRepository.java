package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopImageModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopImageRepository extends MongoRepository<LaptopImageModel,String> {

    List<LaptopImageModel> findByLid(String lid);
}
