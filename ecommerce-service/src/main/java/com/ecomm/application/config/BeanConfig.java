/**
 * 
 */
package com.ecomm.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecomm.application.cart.service.CartService;
import com.ecomm.application.cart.service.CartServiceImpl;
import com.ecomm.application.product.service.ProductService;
import com.ecomm.application.product.service.ProductServiceImpl;
import com.ecomm.application.user.service.UserService;
import com.ecomm.application.user.service.UserServiceImpl;

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
