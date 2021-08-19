package com.spm.netgarage.dal.repository.laptop;

import com.spm.netgarage.dal.model.laptop.LaptopModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LaptopRepository extends MongoRepository<LaptopModel, String> {

    List<LaptopModel> findByStatus(String status);
}
