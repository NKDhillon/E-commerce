/**
 * 
 */
package com.ecomm.application.services.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecomm.application.model.Credential;
import com.ecomm.application.model.UpdateCredentialRequest;
import com.ecomm.application.model.UserRegistrationRequest;

/**
 * @author Navneet Kaur
 */

@Service
public interface UserService {

	/**
	 * @param userRegistrationRequest
	 * @return
	 */
	String register(UserRegistrationRequest userRegistrationRequest);

	/**
	 * @param credential
	 * @return
	 */
	String login(Credential credential);

	/**
	 * @return
	 */
	List<UserRegistrationRequest> viewAll();

	/**
	 * @return
	 */
	String logout();

	/**
	 * @param updateCredentialRequest
	 */
	String updateCredentials(UpdateCredentialRequest updateCredentialRequest);	
}
