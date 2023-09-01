package com.ngonidzashemusiiwa.demo.project.demonstrationproject.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
				
				//1. All requests should be authenticated
				http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
				
				//2.if a request is not authenticated, a web page will be shown
				http.httpBasic(withDefaults()); //making the pop up show up requesting authentication
		        
		        //3. Disable CSRF
				http.csrf().disable();		
				return http.build();
	}

}
