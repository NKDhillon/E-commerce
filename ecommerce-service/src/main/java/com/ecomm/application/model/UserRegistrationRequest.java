/**
 * 
 */
package com.ecomm.application.model;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Data
public class UserRegistrationRequest {
	
	private String name;
	private String emailId;
	private String password;
	private long telephoneNumber;
	
}
