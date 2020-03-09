package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
public class HelloResources {
	
	  @PreAuthorize("hasPermission(#user, 'user_full_acces')")
	  @GetMapping("/api/test/user")
	  public String userAccess() {
	    return ">>> User Contents!";
	  }
	
}
