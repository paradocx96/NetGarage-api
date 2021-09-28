package com.spm.netgarage.dal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.UserFeedback;

public interface UserFeedbackMongoRepository extends MongoRepository<UserFeedback, String>{

	Optional<UserFeedback> findByDeviceID(String id);
	
}
