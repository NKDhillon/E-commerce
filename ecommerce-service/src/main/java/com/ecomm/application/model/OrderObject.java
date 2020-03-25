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
public class OrderObject {
	
	private List<CartObject> myOrder;
	private Address address;
	private String email;
	private String telephoneNumber;
}
