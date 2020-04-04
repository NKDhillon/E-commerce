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
public class Product  implements Serializable {
	
	private static final long serialVersionUID = -2343243243242432341L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int productId;
	private int price;
	private int quantity;
	private String productName;
	private String category;
	private String productVendor;
	private String warranty;
	
}
