package com.spm.netgarage.dal.repository;

import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spm.netgarage.dal.model.UserFeedback;

@Repository
public interface UserFeedbackMongoRepository extends MongoRepository<UserFeedback, String>{

	List<UserFeedback> findBydeviceID(String id);
	
}
