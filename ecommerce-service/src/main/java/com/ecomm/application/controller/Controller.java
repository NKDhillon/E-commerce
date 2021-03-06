/**
 * 
 */
package com.ecomm.application.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.application.cart.service.CartService;
import com.ecomm.application.model.CartObject;
import com.ecomm.application.model.Credential;
import com.ecomm.application.model.OrderObject;
import com.ecomm.application.model.Product;
import com.ecomm.application.model.UpdateCredentialRequest;
import com.ecomm.application.model.UserRegistrationRequest;
import com.ecomm.application.product.service.ProductService;
import com.ecomm.application.user.service.UserService;
import com.ecomm.application.util.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Navneet Kaur
 */

@RestController
@Slf4j
@RequestMapping("/ecomm")
public class Controller {

	@Autowired
	UserService authService;

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@PostMapping("/user/register")
	public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
		log.info("*****	Inside User Registration API for EmailId:= {},	Name:= {},	TelephoneNumber:= {}",	userRegistrationRequest.getEmailId(),	userRegistrationRequest.getName(),	userRegistrationRequest.getTelephoneNumber());
		String response = authService.register(userRegistrationRequest);
		if(response.contains(Constants.REGISTERED))
			return new ResponseEntity<String>(response, HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<String> login(@RequestBody Credential credential) {
		log.info("*****	Inside User LOGIN API for username := {},	UserType := {} ",  credential.getUsername(), credential.getUserType());
		String response = authService.login(credential);
		if(response.contains(Constants.SUCCESS))
			return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(response, HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/user/viewAll")
	public ResponseEntity<List<UserRegistrationRequest>> viewAll(){
		log.info("*****	Inside View-All User API");
		return new ResponseEntity<List<UserRegistrationRequest>>(authService.viewAll(),HttpStatus.OK);
	}

	@GetMapping("/user/logout/{username}")
	public ResponseEntity<String> logout(@PathVariable String username) {
		log.info("*****	Inside User Logout API for Username:= {}",	username);
		String response = authService.logout();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PutMapping("/user/updateCredentials")
	public ResponseEntity<String> updateCredentials(@RequestBody UpdateCredentialRequest updateCredentialRequest) {
		log.info("*****	Inside User Credential-Update API for EmailId:= {}",	updateCredentialRequest.getEmailId());
		String response = authService.updateCredentials(updateCredentialRequest);		
		if(response.contains(Constants.UPDATED))
			return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(response, HttpStatus.UNAUTHORIZED);
		
	}

	@PostMapping("/cart/add")
	public ResponseEntity<String> addToCart(@RequestBody OrderObject orderObject) {
		log.info("*****	Inside Add Product to Cart API for EmailId:= {}", orderObject.getEmailId());	
		return new ResponseEntity<String>(cartService.addToCart(orderObject), HttpStatus.CREATED);
	}

	@GetMapping("/cart/get/{username}")
	public ResponseEntity<List<CartObject>> getFromCart(@PathVariable String username) {
		log.info("*****	Inside Get From Cart API for User: ={}", username); 
		List<CartObject> responseList = new LinkedList<CartObject>();
		responseList = cartService.getFromCart(username);
		return new ResponseEntity<List<CartObject>>(responseList, HttpStatus.OK);
	}

	@DeleteMapping("/cart/delete")
	public ResponseEntity<String> deleteFromCart(@RequestBody CartObject cartObject) {
 		log.info("*****	Inside Delete_From_Cart API"); 
		return new ResponseEntity<String>(cartService.deleteFromCart(cartObject), HttpStatus.OK);
	}
	
	@DeleteMapping("/cart/deleteAll/{username}")
	public ResponseEntity<String> deleteAllFromCart(@PathVariable String username) {
		log.info("*****	Inside Delete_All_From_Cart API"); 
		return new ResponseEntity<String>(cartService.deleteAllFromCart(username), HttpStatus.OK);
	}

	@PostMapping("/product/add")
	public ResponseEntity<String> addProductList(@RequestBody List<Product> productList) {
		for (int i = 0; i < productList.size(); i++)
			log.info("*****	Inside Add Product List API for ProductId:= {},	ProductName:= {}, ProductVendor:= {}, ProductQuantity:= {}",
					productList.get(i).getProductId(), productList.get(i).getProductName(),
					productList.get(i).getProductVendor(), productList.get(i).getQuantity());
		String response = productService.addProduct(productList);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/product/delete")
	public ResponseEntity deleteProductList(@RequestBody List<Product> productList) {
		for (int i = 0; i < productList.size(); i++)
		log.info("*****	Inside Delete Product List API for ProductId:= {}, ProductQuantity:= {}",
				productList.get(i).getProductId(),  productList.get(i).getQuantity());
		productService.deleteProduct(productList);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/product/viewAll")
	public ResponseEntity<List<Product>> viewProductList() {
		log.info("*****	Inside view Product List API"); 
		List<Product> responseList = new LinkedList<Product>();
		responseList = productService.viewProduct();
		return new ResponseEntity<List<Product>>(responseList, HttpStatus.OK);
	}
}