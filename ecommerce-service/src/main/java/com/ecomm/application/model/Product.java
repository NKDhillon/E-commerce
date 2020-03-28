/**
 * 
 */
package com.ecomm.application.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Data
public class Product {

	@Id
	private String Id;
	private int productId;
	private int price;
	private int quantity;
	private String productName;
	private String category;
	private String productVendor;
	private String warranty;
	
}
