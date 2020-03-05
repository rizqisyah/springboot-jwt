package com.example.demo.common;

import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@Configuration
public class InMemoryDatabaseConfig {
	 @Bean
	    public ServletRegistrationBean h2servletRegistration() {
	        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	        registration.addUrlMappings("/console/*");
	        return registration;
	    }
}
