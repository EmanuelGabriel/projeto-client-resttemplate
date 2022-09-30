package com.example.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityClientOauthConfig { //extends WebSecurityConfigurerAdapter {

	/**
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/oauth/**", "/oauth2/**", "/login/**", "/api.sandbox.bb/**").permitAll()
		.anyRequest()
		.permitAll();
		
		// .antMatchers("/").permitAll();
	} **/
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();

		return http.build();

	}
	
	
	

}
