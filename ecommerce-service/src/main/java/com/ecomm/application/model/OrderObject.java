/**
 * 
 */
package com.ecomm.application.model;

import java.util.List;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Data
public class OrderObject{
	
	private String emailId;
	private String orderId;
	private List<Product> products;
	
}
