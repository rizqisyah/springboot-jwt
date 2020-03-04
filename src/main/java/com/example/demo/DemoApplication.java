package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;

@SpringBootApplication
public class DemoApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
