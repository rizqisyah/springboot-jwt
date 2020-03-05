package com.example.demo.security.auth.jwt;

public interface TokenVerifier {
	
	public boolean verify(String jti);
}
