/**
 * 
 */
package com.ecomm.application.product.service;

import java.util.List;

import com.ecomm.application.model.Product;

/**
 * @author Navneet Kaur
 */

public interface ProductService {

	/**
	 * @param productList
	 * @return
	 */
	String addProduct(List<Product> productList);

	/**
	 * @return
	 */
	List<Product> viewProduct();

	/**
	 * @param productList
	 */
	void deleteProduct(List<Product> productList);

}
