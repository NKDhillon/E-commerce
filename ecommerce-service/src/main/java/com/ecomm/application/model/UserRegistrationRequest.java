/**
 * 
 */
package com.ecomm.application.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author Navneet Kaur
 */

@Entity
@Data
@Access(value = AccessType.FIELD)
public class UserRegistrationRequest implements Serializable {
	
	private static final long serialVersionUID = -2343243243242432341L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String emailId;
	private String name;
	private String password;
	private long telephoneNumber;
	
}
