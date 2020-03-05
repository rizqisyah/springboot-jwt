package com.example.demo.service.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestDTO {
    private String username;
    private String password;

    @JsonCreator
    public LoginRequestDTO(@JsonProperty("username") String username, 
    		@JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
