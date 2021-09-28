package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopBrandModel;

import com.spm.netgarage.domain.laptop.LaptopBrand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopBrandRepository extends MongoRepository<LaptopBrandModel, String> {

    LaptopBrand findByName(String name);
}
