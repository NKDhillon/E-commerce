/**
 * 
 */
package com.ecomm.application.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.application.model.CartObject;
import com.ecomm.application.model.OrderObject;
import com.ecomm.application.model.Product;
import com.ecomm.application.pg.repo.OrderRepository;
import com.ecomm.application.pg.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Navneet Kaur
 */
@Slf4j
public class CartServiceImpl implements CartService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public String addToCart(OrderObject orderObject) {
		log.info("***********************Inside add to Cart method of CartServiceImplementation");
		String response = "Successfully Added the items to Cart";
	//	orderObject.setOrderId(orderObject.getEmailId());
		if (orderRepository.findByOrderId(orderObject.getOrderId()) != null) {
			for (Product product : orderObject.getProducts()) {
				if (orderRepository.findByProductId(product.getProductId()) != null) {
					List<CartObject> cartObjects = orderRepository.findByProductId(product.getProductId());
					for(CartObject cartObject : cartObjects) {
					cartObject.setQuantity(cartObject.getQuantity() + product.getQuantity());
					orderRepository.save(cartObject);
					log.info("******************"+orderRepository.findAll().toString());
					}
				} else {
					CartObject cartObject = new CartObject();
					cartObject.setEmailId(orderObject.getEmailId());
					cartObject.setOrderId(orderObject.getOrderId());
					cartObject.setProductId(product.getProductId());
					cartObject.setProductName(product.getProductName());
					cartObject.setQuantity(product.getQuantity());
					orderRepository.save(cartObject);
					log.info("******************"+orderRepository.findAll().toString());
				}
			}
		} else {
			for (Product product : orderObject.getProducts()) {
				CartObject cartObject = new CartObject();
				cartObject.setEmailId(orderObject.getEmailId());
				cartObject.setOrderId(orderObject.getOrderId());
				cartObject.setProductId(product.getProductId());
				cartObject.setProductName(product.getProductName());
				cartObject.setQuantity(product.getQuantity());
				orderRepository.save(cartObject);
				log.info("******************"+orderRepository.findAll().toString());
			}
		}
		return response;
	}

	@Override
	public List<CartObject> getFromCart(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartObject> deleteFromCart(CartObject cartObject) {
		// TODO Auto-generated method stub
		return null;
	}

}
