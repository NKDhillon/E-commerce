 /**
  *
*/
package com.ecomm.application.pg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.application.model.CartObject;

/**
 * @author Navneet Kaur
*/

@Repository
public interface OrderRepository extends JpaRepository<CartObject, Long> {
	
	public CartObject findByEmailId(String emailId);
	
	public List<CartObject> findByOrderId(String string);

	/**
	 * @param productId
	 * @return
	 */
	public List<CartObject> findByProductId(int productId);
	
}
