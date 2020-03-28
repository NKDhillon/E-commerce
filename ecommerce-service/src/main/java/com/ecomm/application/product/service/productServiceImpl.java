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
	public String addProduct(List<Product> product) {
		for (Product item : product) {
			if (repository.findByProductId(item.getProductId()) != null) {
				item.setQuantity(repository.findByProductId(item.getProductId()).getQuantity() + item.getQuantity());
				repository.deleteByProductId(item.getProductId());
				repository.save(item);
			} else {
				repository.save(item);
			}
		}
		return product.size() + " items added successfully ";
	}

	@Override
	public void deleteProduct(List<Product> product) {
		for (Product item : product) {
			if (repository.findByProductId(item.getProductId()) != null) {
				item.setQuantity(repository.findByProductId(item.getProductId()).getQuantity() - item.getQuantity());
				repository.deleteByProductId(item.getProductId());
				repository.save(item);
			}
		}
	}

	@Override
	public List<Product> viewProduct() {
		return repository.findAll();
	}

}
