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
	
	public String addToCart(OrderObject orderObject);

	public List<CartObject> getFromCart(String username);

	public List<CartObject> deleteFromCart(CartObject cartObject);
}