package com.firstWebApp.myWebApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		UserDetails userDetails1 = createNewUser("Viswa", "Trichy");
		UserDetails userDetails2 = createNewUser("Akshay", "India");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}


	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwprdEncoder().encode(input);
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER", "ADMIN")
				.build();
		
		return userDetails;
		
	}
	
	
	@Bean
	public PasswordEncoder passwprdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//All URLs are protected
	//A login form is shown for unauthorized users
	//CSRF disabled (Cross site request forgery)
	//Frames allowed
	
	@Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		
	}
}	
