package com.firstWebApp.myWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String name, String password) {
		boolean isValidUsername = name.equalsIgnoreCase("Viswa");
		boolean isValidPassword = password.equalsIgnoreCase("Trichy");
		
		
		return isValidUsername && isValidPassword;
	}

}
