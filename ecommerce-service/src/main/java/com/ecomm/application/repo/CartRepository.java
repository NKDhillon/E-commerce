/**
 * 
 */
package com.ecomm.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.application.model.CartObject;

/**
 * @author Navneet Kaur
 */

@Repository
public interface CartRepository extends MongoRepository<CartObject, String> {

}
