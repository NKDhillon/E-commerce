/**
 * 
 */
package com.ecomm.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.application.model.Product;

/**
 * @author Navneet Kaur
 */

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	Product findByProductId(int i);
	void deleteByProductId(int i);
}
