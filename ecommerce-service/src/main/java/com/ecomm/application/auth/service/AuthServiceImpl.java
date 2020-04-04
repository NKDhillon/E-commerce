/**
 * 
 */
package com.ecomm.application.auth.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.application.model.Credential;
import com.ecomm.application.model.UpdateCredentialRequest;
import com.ecomm.application.model.UserRegistrationRequest;
import com.ecomm.application.pg.repo.UserRepository;
import com.ecomm.application.util.Constants;

/**
 * @author Navneet Kaur
 */

public class AuthServiceImpl implements AuthService {

	
	@Autowired
	UserRepository userRepository;

	@Override
	public String login(Credential credential) {
		if(userRepository.findByEmailId(credential.getUsername())!=null) {
			if(userRepository.findByEmailId(credential.getUsername()).getPassword()!=null){
				if (credential.getUsername().equals(userRepository.findByEmailId(credential.getUsername()).getEmailId())
						&& credential.getPassword().equals(userRepository.findByEmailId(credential.getUsername()).getPassword()))
					return Constants.LOGGED_IN;
				else
					return Constants.INCORRECT_CREDENTIALS;
			} else
				return Constants.INCORRECT_PASSWORD;
		} else
			return Constants.INCORRECT_USER;
	}

	@Override
	public String logout() {
		return Constants.LOGOUT;
	}

	@Override
	public String updateCredentials(UpdateCredentialRequest UpdateCredentialRequest) {
		
		if (userRepository.findByEmailId(UpdateCredentialRequest.getEmailId())!=null
				&& UpdateCredentialRequest.getEmailId()
				.equals(userRepository.findByEmailId(UpdateCredentialRequest.getEmailId()).getEmailId())
				&& UpdateCredentialRequest.getOldPassword()
						.equals(userRepository.findByEmailId(UpdateCredentialRequest.getEmailId()).getPassword())) {
			UserRegistrationRequest user = userRepository.findByEmailId(UpdateCredentialRequest.getEmailId());
			user.setPassword(UpdateCredentialRequest.getNewPassword());
			userRepository.delete(userRepository.findByEmailId(UpdateCredentialRequest.getEmailId()));
			userRepository.save(user);
			return Constants.UPDATE_SUCCESS;
		} else
			return Constants.INCORRECT_CREDENTIALS;
	}

	@Override
	public String register(UserRegistrationRequest userRegistrationRequest) {
		if (userRepository.findByEmailId(userRegistrationRequest.getEmailId()) != null)
			return userRegistrationRequest.getEmailId() + Constants.ALREADY_REGISTERED;
		else
			userRepository.save(userRegistrationRequest);
		return Constants.REGISTER_SUCCESS;
	}

	@Override
	public List<UserRegistrationRequest> viewAll() {
		List<UserRegistrationRequest> allUsers = new LinkedList<UserRegistrationRequest>();
		for(UserRegistrationRequest user : userRepository.findAll()) {
			user.setPassword(Constants.STARS);
			allUsers.add(user);
		}
		return allUsers ;
	}

}
