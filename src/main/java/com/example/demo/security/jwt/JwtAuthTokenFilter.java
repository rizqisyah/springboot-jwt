package com.example.demo.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.exception.CustomException;
import com.example.demo.service.impl.UserDetailsServiceImpl;

// We should use OncePerRequestFilter since we are doing a database call, there is no point in doing this more than once
public class JwtAuthTokenFilter extends OncePerRequestFilter {

	@Autowired
    private JwtTokenProvider tokenProvider;
 
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
 
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                    HttpServletResponse response, 
                    FilterChain filterChain) 
                        throws ServletException, IOException {
        try {
          
            String jwt = getJwt(request);
            if (jwt!=null && tokenProvider.validateJwtToken(jwt)) {
                String username = tokenProvider.getUserNameFromJwtToken(jwt);
 
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication 
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
 
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
        }
 
        filterChain.doFilter(request, response);
    }
 
    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
          
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
          return authHeader.replace("Bearer ","");
        }
 
        return null;
    }
}