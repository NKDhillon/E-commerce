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
public class UserRegistrationRequest {
	
	@Id
	private String userId;
	private String emailId;
	private String name;
	private String password;
	private long telephoneNumber;
	
}
