/**
 * 
 */
package com.ecomm.application.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.application.model.Credential;
import com.ecomm.application.model.UpdateCredentialRequest;
import com.ecomm.application.model.UserRegistrationRequest;
import com.ecomm.application.repo.AuthRepository;

/**
 * @author Navneet Kaur
 */

public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository repository;

	@Override
	public String login(Credential credential) {
		if (credential.getUsername().equals(repository.findByEmailId(credential.getUsername()).getEmailId())
				&& credential.getPassword().equals(repository.findByEmailId(credential.getPassword()).getPassword()))
			return "SUCCESS : Logged In successfully";
		else
			return "FAIL : Incorrect Credentials";
	}

	@Override
	public String logout() {
		return "LOGOUT";
	}

	@Override
	public String updateCredentials(UpdateCredentialRequest UpdateCredentialRequest) {
		if (UpdateCredentialRequest.getEmail()
				.equals(repository.findByEmailId(UpdateCredentialRequest.getEmail()).getEmailId())
				&& UpdateCredentialRequest.getOldPassword()
						.equals(repository.findByEmailId(UpdateCredentialRequest.getEmail()).getPassword())) {
			repository.findByEmailId(UpdateCredentialRequest.getEmail())
					.setPassword(UpdateCredentialRequest.getNewPassword());
			return "Updated Successfully";
		} else
			return "Incorrect Credetials";
	}

	@Override
	public String register(UserRegistrationRequest userRegistrationRequest) {
		if (repository.findByEmailId(userRegistrationRequest.getEmailId()) != null)
			return userRegistrationRequest.getEmailId() + " already registered, Please  try login";
		else
			repository.save(userRegistrationRequest);
		return "Registered successfully";
	}

	@Override
	public List<UserRegistrationRequest> viewAll() {
		return repository.findAll();
	}

}
