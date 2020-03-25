/**
 * 
 */
package com.ecomm.application.model;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Data
public class Address {
	
	private String houseNumber;
	private String location;
	private String district;
	private String state;
	private long zip;
}
