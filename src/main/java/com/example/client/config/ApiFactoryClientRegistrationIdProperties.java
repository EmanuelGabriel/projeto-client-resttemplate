package com.example.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Component
@ConfigurationProperties(prefix = "registrationclientid")
public class ApiFactoryClientRegistrationIdProperties {

	private String registrationId;

	public ApiFactoryClientRegistrationIdProperties() {
	}

	public ApiFactoryClientRegistrationIdProperties(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

}
