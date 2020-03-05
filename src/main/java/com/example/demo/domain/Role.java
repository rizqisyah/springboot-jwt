package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;



public enum Role {
	 
	ADMIN, PREMIUM_MEMBER, MEMBER;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
	 
}
