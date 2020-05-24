/**
 * 
 */
package com.ecomm.application.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.application.model.Product;
import com.ecomm.application.pg.repo.ProductRepository;

/**
 * @author Navneet Kaur
 */

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;
	
	@Override
	public String addProduct(List<Product> product) {
		for (Product item : product) {
			if (repository.findByProductId(item.getProductId()) != null) {
				Product prod = repository.findByProductId(item.getProductId());
				prod.setQuantity(prod.getQuantity() + item.getQuantity());
				repository.save(prod);
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
				Product prod = repository.findByProductId(item.getProductId());
				if(prod.getQuantity()>item.getQuantity()) {
					prod.setQuantity(prod.getQuantity() - item.getQuantity());
				} else {
					prod.setQuantity(0);
				}
				repository.save(prod);
			}
		}
	}

	@Override
	public List<Product> viewProduct() {
		return repository.findAll();
	}

}
