package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopOSModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopOSRepository extends MongoRepository<LaptopOSModel, String> {
}
