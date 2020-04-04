/**
 * 
 */
package com.ecomm.application.pg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.application.model.UserRegistrationRequest;

/**
 * @author Navneet Kaur
*/

@Repository
public interface UserRepository extends JpaRepository<UserRegistrationRequest, Long> {
	
	public UserRegistrationRequest findByEmailId(String emailId);
	
}
