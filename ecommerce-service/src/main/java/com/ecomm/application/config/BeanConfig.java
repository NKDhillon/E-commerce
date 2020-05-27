/**
 * 
 */
package com.ecomm.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecomm.application.services.cart.CartService;
import com.ecomm.application.services.cart.CartServiceImpl;
import com.ecomm.application.services.product.ProductService;
import com.ecomm.application.services.product.ProductServiceImpl;
import com.ecomm.application.services.user.UserService;
import com.ecomm.application.services.user.UserServiceImpl;

/**
 * @author Navneet Kaur
 */

@Configuration
public class BeanConfig {

	@Bean
	public UserService getAuthService() {
		return new UserServiceImpl();
	}

	@Bean
	public CartService getCartService() {
		return new CartServiceImpl();
	}

	@Bean
	public ProductService getProductService() {
		return new ProductServiceImpl();
	}
	
}
