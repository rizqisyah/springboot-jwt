package com.example.demo.security.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

public class AuthMethodNotSupportedException extends AuthenticationServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5602924882727492382L;

	public AuthMethodNotSupportedException(String msg) {
		super(msg);
	}

}
