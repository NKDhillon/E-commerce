/**
 * 
 */
package com.ecomm.application.model;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Data
public class Product {

	private int price;
	private int quantity;
	private String productName;
	private String productType;
	private String productVendor;
	
}
