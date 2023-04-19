package com.viswa.rest.webservices.restfulwebservices.exception.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


  //@Configuration
  public class BasicAuthenticationSecurityConfiguration {
	
	//Filter chain
	//authenticate all reuquest
	//basis authentication
	//csrf disable
	//stateless rest api
  
	  @Bean 
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  return 
		  http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
		  	.httpBasic(withDefaults())
		  	.sessionManagement(
				  session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				  )
		  	.csrf().disable()
		  	.build();
	  
	  } 
 }
 