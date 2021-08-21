//Name : Malwatta H.G.
//ID : IT19240848

package com.spm.netgarage.dal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spm.netgarage.dal.model.User;


//create new user repository to find data in the database
public interface UserMongoRepository extends MongoRepository<User, String> {
	
	Boolean existsByUsername(String username);

	Optional<User> findByUsername(String username);

	Boolean existsByEmail(String email);
	
}
