/**
 * 
 */
package com.ecomm.application.model;

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
