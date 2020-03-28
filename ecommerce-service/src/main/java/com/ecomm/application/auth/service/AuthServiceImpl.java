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
import com.ecomm.application.repo.AuthRepository;

/**
 * @author Navneet Kaur
 */

public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository repository;

	@Override
	public String login(Credential credential) {
		if(repository.findByEmailId(credential.getUsername())!=null) {
			if(repository.findByEmailId(credential.getUsername()).getPassword()!=null){
				if (credential.getUsername().equals(repository.findByEmailId(credential.getUsername()).getEmailId())
						&& credential.getPassword().equals(repository.findByEmailId(credential.getUsername()).getPassword()))
					return "SUCCESS : Logged In successfully";
				else
					return "FAIL : Incorrect Credentials";
			} else
				return "Incorrect Password";
		} else
			return "Incorrect Username";
	}

	@Override
	public String logout() {
		return "LOGOUT";
	}

	@Override
	public String updateCredentials(UpdateCredentialRequest UpdateCredentialRequest) {
		
		if (repository.findByEmailId(UpdateCredentialRequest.getEmailId())!=null
				&& UpdateCredentialRequest.getEmailId()
				.equals(repository.findByEmailId(UpdateCredentialRequest.getEmailId()).getEmailId())
				&& UpdateCredentialRequest.getOldPassword()
						.equals(repository.findByEmailId(UpdateCredentialRequest.getEmailId()).getPassword())) {
			UserRegistrationRequest user = repository.findByEmailId(UpdateCredentialRequest.getEmailId());
			user.setPassword(UpdateCredentialRequest.getNewPassword());
			repository.delete(repository.findByEmailId(UpdateCredentialRequest.getEmailId()));
			repository.save(user);
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
		List<UserRegistrationRequest> allUsers = new LinkedList<UserRegistrationRequest>();
		for(UserRegistrationRequest user : repository.findAll()) {
			user.setPassword("*****");
			allUsers.add(user);
		}
		return allUsers;
	}

}
