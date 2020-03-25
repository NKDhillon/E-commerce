/**
 * 
 */
package com.ecomm.application.model;

import lombok.Data;

import org.springframework.data.annotation.Id;

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
