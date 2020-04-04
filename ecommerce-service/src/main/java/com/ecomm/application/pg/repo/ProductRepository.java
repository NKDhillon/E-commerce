/**
 * 
 */
package com.ecomm.application.pg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.application.model.Product;

/**
 * @author Navneet Kaur
*/

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductId(int i);

	void deleteByProductId(int i);

}
