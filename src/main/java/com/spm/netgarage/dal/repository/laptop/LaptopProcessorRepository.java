package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopProcessorModel;

import com.spm.netgarage.domain.laptop.LaptopProcessor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopProcessorRepository extends MongoRepository<LaptopProcessorModel, String> {

    LaptopProcessor findByName(String name);
}
