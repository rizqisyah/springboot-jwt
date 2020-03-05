package com.example.demo.security.auth.jwt;

public interface TokenExtractor {
	public String extract(String payload);
}
