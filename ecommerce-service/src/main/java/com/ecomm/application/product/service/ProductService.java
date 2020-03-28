/**
 * 
 */
package com.ecomm.application.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.application.model.Product;

/**
 * @author Navneet Kaur
 */

@Service
public interface ProductService {

	public String addProduct(List<Product> product);

	public void deleteProduct(List<Product> product);

	public List<Product> viewProduct();
	
}
