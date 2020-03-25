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
public class UpdateCredentialRequest {
	
	private String email;
	private String oldPassword;
	private String newPassword;
	
}
