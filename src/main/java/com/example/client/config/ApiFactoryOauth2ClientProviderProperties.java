package com.example.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.sandboxbb")
public class ApiFactoryOauth2ClientProviderProperties {

	private String tokenUri;

	public ApiFactoryOauth2ClientProviderProperties() {
	}

	public ApiFactoryOauth2ClientProviderProperties(String tokenUri) {
		this.tokenUri = tokenUri;
	}

	public String getTokenUri() {
		return tokenUri;
	}

	public void setTokenUri(String tokenUri) {
		this.tokenUri = tokenUri;
	}

}
