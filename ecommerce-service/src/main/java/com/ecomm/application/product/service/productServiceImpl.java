/**
 * 
 */
package com.ecomm.application.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.application.model.Product;
import com.ecomm.application.repo.ProductRepository;

/**
 * @author Navneet Kaur
 */

public class productServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;
	
	@Override
	public void addProduct(List<Product> product) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void deleteProduct(List<Product> product) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Product> viewProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
