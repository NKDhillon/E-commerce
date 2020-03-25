/**
 * 
 */
package com.ecomm.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecomm.application.auth.service.AuthService;
import com.ecomm.application.auth.service.AuthServiceImpl;
import com.ecomm.application.cart.service.CartService;
import com.ecomm.application.cart.service.CartServiceImpl;
import com.ecomm.application.product.service.ProductService;
import com.ecomm.application.product.service.productServiceImpl;

/**
 * @author Navneet Kaur
 */

@Configuration
public class BeanConfig {

	@Bean
	public AuthService getAuthService() {
		return new AuthServiceImpl();
	}

	@Bean
	public CartService getCartService() {
		return new CartServiceImpl();
	}

	@Bean
	public ProductService getProductService() {
		return new productServiceImpl();
	}
	
}
