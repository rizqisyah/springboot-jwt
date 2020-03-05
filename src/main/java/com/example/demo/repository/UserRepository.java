package com.example.demo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u left join fetch u.roles r where u.username=:username")
	Optional<User> findByUsername(String username);
}
