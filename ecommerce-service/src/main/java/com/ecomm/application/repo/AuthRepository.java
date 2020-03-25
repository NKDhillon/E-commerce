/**
 * 
 */
package com.ecomm.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.application.model.UserRegistrationRequest;

/**
 * @author Navneet Kaur
 */

@Repository
public interface AuthRepository extends MongoRepository<UserRegistrationRequest, String> {
	
	public UserRegistrationRequest findByEmailId(String emailId);
	
}
