/**
 * 
 */
package com.ecomm.application.cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.application.model.CartObject;

/**
 * @author Navneet Kaur
 */

@Service
public interface CartService {
	
	public List<CartObject> addToCart(CartObject cartObject);

	public List<CartObject> getFromCart();

	public List<CartObject> deleteFromCart(CartObject cartObject);
}