package com.example.demo.svc;

import java.util.Optional;

import com.example.demo.domain.User;

public interface UserService {
	public Optional<User> getByUsername(String username);
}
