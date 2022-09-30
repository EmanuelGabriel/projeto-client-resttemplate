package com.example.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client.registration.sandboxbb")
public class ApiFactoryOauth2ClientProperties {

	private String clientId;
	private String clientSecret;
	private String authorizationGrantType;
	private String scope;

	public ApiFactoryOauth2ClientProperties() {
	}

	public ApiFactoryOauth2ClientProperties(String clientId, String clientSecret, String authorizationGrantType,
			String scope) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authorizationGrantType = authorizationGrantType;
		this.scope = scope;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getAuthorizationGrantType() {
		return authorizationGrantType;
	}

	public String getScope() {
		return scope;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setAuthorizationGrantType(String authorizationGrantType) {
		this.authorizationGrantType = authorizationGrantType;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
