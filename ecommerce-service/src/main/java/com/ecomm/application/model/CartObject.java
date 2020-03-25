/**
 * 
 */
package com.ecomm.application.model;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Data
public class CartObject {
	
	private String objectName;
	private String objectType;
	private String email;
	private int price;
	private int quantity;
	
}
