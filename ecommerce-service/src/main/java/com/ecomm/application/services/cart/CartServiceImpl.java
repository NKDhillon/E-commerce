/**
 * 
 */
package com.ecomm.application.services.cart;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.application.model.CartObject;
import com.ecomm.application.model.OrderObject;
import com.ecomm.application.pg.repo.OrderRepository;
import com.ecomm.application.pg.repo.ProductRepository;
import com.ecomm.application.services.product.ProductService;
import com.ecomm.application.util.Constants;

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

	@Autowired
	ProductService productService;

	@Override
	public String addToCart(OrderObject orderObject) {
		log.info("***** Inside add to Cart method of CartServiceImplementation");
		List<CartObject> oldCartObjects = orderRepository.findByEmailId(orderObject.getEmailId());
		List<CartObject> commonObjects = new LinkedList<CartObject>();
		if (oldCartObjects.isEmpty()) {
			log.info("***** Inside Cart is all empty with no products added to the cart");
			for (CartObject cartObject : orderObject.getCartObject()) {
				cartObject.setPrice(cartObject.getPrice() * cartObject.getQuantity());
				orderRepository.save(cartObject);
			}
		} else {
			log.info("***** Inside Something already exists in the Cart : " + oldCartObjects.toString());
			for (CartObject cartObject : orderObject.getCartObject()) {
				for (int i = 0; i < oldCartObjects.size(); i++) {
					if (cartObject.getProductId() == (oldCartObjects.get(i).getProductId())
							&& cartObject.getEmailId().equalsIgnoreCase(oldCartObjects.get(i).getEmailId())) {
						log.info("***** Inside particular Product exist in the Cart with ProductId := {}",
								oldCartObjects.get(i).getProductId());
						oldCartObjects.get(i)
								.setQuantity(oldCartObjects.get(i).getQuantity() + cartObject.getQuantity());
						oldCartObjects.get(i).setPrice(oldCartObjects.get(i).getQuantity() * cartObject.getPrice());
						commonObjects.add(cartObject);
					}
				}
			}
			orderObject.getCartObject().removeAll(commonObjects);
			for (CartObject cartObj : orderObject.getCartObject()) {
				log.info("***** Particular Product do not exist in the Cart with ProductId := {}",
						cartObj.getProductId());
				oldCartObjects.add(cartObj);
			}

			log.info("***** Updated CartObjects to for user " + orderObject.getEmailId() + ":\n"
					+ oldCartObjects.toString());
			for (CartObject obj : oldCartObjects) {
				log.info("***** Updating Cart : " + obj.toString());
				orderRepository.save(obj);
			}
		}
		return Constants.SUCCESS;
	}

	@Override
	public List<CartObject> getFromCart(String username) {
		return orderRepository.findByEmailId(username);
	}

	@Override
	public String deleteFromCart(CartObject cartObject) {
		orderRepository.delete(cartObject);
		return Constants.SUCCESS;
	}

	public String deleteAllFromCart(String username) {
		orderRepository.deleteInBatch(orderRepository.findByEmailId(username));
		return Constants.SUCCESS;
	}

}
