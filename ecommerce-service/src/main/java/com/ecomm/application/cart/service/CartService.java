/**
 * 
 */
package com.ecomm.application.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.application.model.CartObject;
import com.ecomm.application.model.OrderObject;

/**
 * @author Navneet Kaur
 */

@Service
public interface CartService {

	/**
	 * @param orderObject
	 * @return
	 */
	public String addToCart(OrderObject orderObject);

	/**
	 * @param username
	 * @return
	 */
	public List<CartObject> getFromCart(String username);

	/**
	 * @param cartObject
	 * @return
	 */
	public String deleteFromCart(CartObject cartObject);

	/**
	 * @param username
	 * @return
	 */
	public String deleteAllFromCart(String username);

}