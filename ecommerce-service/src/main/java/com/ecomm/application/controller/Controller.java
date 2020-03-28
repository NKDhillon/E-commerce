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

import com.ecomm.application.auth.service.AuthService;
import com.ecomm.application.cart.service.CartService;
import com.ecomm.application.model.CartObject;
import com.ecomm.application.model.Credential;
import com.ecomm.application.model.Product;
import com.ecomm.application.model.UpdateCredentialRequest;
import com.ecomm.application.model.UserRegistrationRequest;
import com.ecomm.application.product.service.ProductService;

/**
 * @author Navneet Kaur
 */

@RestController
@RequestMapping("/ecomm")
public class Controller {

	@Autowired
	AuthService authService;

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@PostMapping("/user/register")
	public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
		String response = authService.register(userRegistrationRequest);
		if(response.contains("Registered"))
			return new ResponseEntity<String>(response, HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/user/login")
	public ResponseEntity<String> login(@RequestBody Credential credential) {
		String response = authService.login(credential);
		if(response.equals("SUCCESS"))
			return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(response, HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/user/viewAll")
	public ResponseEntity<List<UserRegistrationRequest>> viewAll(){
		return new ResponseEntity<List<UserRegistrationRequest>>(authService.viewAll(),HttpStatus.OK);
	}

	@GetMapping("/logout/{username}")
	public ResponseEntity<String> login(@PathVariable String username) {
		String response = authService.logout();
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PutMapping("/user/updateCredentials")
	public ResponseEntity<String> updateCredentials(@RequestBody UpdateCredentialRequest updateCredentialRequest) {
		String response = authService.updateCredentials(updateCredentialRequest);
		
		if(response.contains("Updated"))
			return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(response, HttpStatus.UNAUTHORIZED);
		
	}

	@GetMapping("/cart/add")
	public ResponseEntity<List<CartObject>> addToCart(@RequestBody CartObject cartObject) {
		List<CartObject> responseList = new LinkedList<CartObject>();
		responseList = cartService.addToCart(cartObject);
		return new ResponseEntity<List<CartObject>>(responseList, HttpStatus.OK);
	}

	@GetMapping("/cart/get")
	public ResponseEntity<List<CartObject>> addToCart(@PathVariable String username) {
		List<CartObject> responseList = new LinkedList<CartObject>();
		responseList = cartService.getFromCart();
		return new ResponseEntity<List<CartObject>>(responseList, HttpStatus.OK);
	}

	@DeleteMapping("/cart/delete")
	public ResponseEntity<List<CartObject>> deleteFromCart(@RequestBody CartObject cartObject) {
		List<CartObject> responseList = new LinkedList<CartObject>();
		responseList = cartService.deleteFromCart(cartObject);
		return new ResponseEntity<List<CartObject>>(responseList, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/product/add")
	public ResponseEntity addProductList(@RequestBody List<Product> productList) {
		productService.addProduct(productList);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/product/delete")
	public ResponseEntity deleteProductList(@RequestBody List<Product> productList) {
		productService.deleteProduct(productList);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/product/view")
	public ResponseEntity<List<Product>> viewProductList() {
		List<Product> responseList = new LinkedList<Product>();
		responseList = productService.viewProduct();
		return new ResponseEntity<List<Product>>(responseList, HttpStatus.OK);
	}
}