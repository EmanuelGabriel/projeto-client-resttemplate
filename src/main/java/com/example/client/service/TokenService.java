package com.example.client.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import com.example.client.config.ApiFactoryClientRegistrationIdProperties;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Component
public class TokenService {

	private static final Logger LOG = LoggerFactory.getLogger(TokenService.class);
	
	@Autowired
	private AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientServiceAndManager;
	
	@Autowired
	private ApiFactoryClientRegistrationIdProperties apiFactoryClientRegistrationIdProperties;
	
	/**
	 * @author emanuel.sousa
	 * retornar token gerado
	 * @return String
	 */
	public String getToken() throws ClientAuthorizationException {
		
		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
				.withClientRegistrationId(apiFactoryClientRegistrationIdProperties.getRegistrationId())
				.principal(apiFactoryClientRegistrationIdProperties.getRegistrationId())
				.build();

		OAuth2AuthorizedClient authorizedClient = this.authorizedClientServiceAndManager.authorize(authorizeRequest);

		OAuth2AccessToken accessToken = Objects.requireNonNull(authorizedClient).getAccessToken();

		LOG.info("Issued: " + accessToken.getIssuedAt().toString() + ", Expira:" + accessToken.getExpiresAt().toString());
		LOG.info("Scopes: " + accessToken.getScopes().toString());
		LOG.info("Token: " + accessToken.getTokenValue());

		return accessToken.getTokenValue();
	}
}
