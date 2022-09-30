package com.example.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;


/**
 * 
 * @author emanuel.sousa
 *
 */

@Configuration
public class OAuthClientConfig {

	@Autowired
	private ApiFactoryOauth2ClientProperties oauth2ClientProperties;
	
	@Autowired
	private ApiFactoryOauth2ClientProviderProperties oauth2ClientProviderProperties;
	
	@Autowired
	private ApiFactoryClientRegistrationIdProperties apiFactoryClientRegistrationIdProperties;
	
    // Criar o registro do cliente API SANDBOX BB
    @Bean
    ClientRegistration clientRegistration() {
    	
        return ClientRegistration
                .withRegistrationId(apiFactoryClientRegistrationIdProperties.getRegistrationId()) // "sandboxbb"
                .tokenUri(oauth2ClientProviderProperties.getTokenUri()) //token_uri
                .clientId(oauth2ClientProperties.getClientId()) // client_id
                .clientSecret(oauth2ClientProperties.getClientSecret()) // client_secret
                .scope(oauth2ClientProperties.getScope()) // scope
                .authorizationGrantType(new AuthorizationGrantType(oauth2ClientProperties.getAuthorizationGrantType())) // authorizationGrantType
                .build();
    }

    // Crie o repositório de registro do cliente
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(ClientRegistration clientRegistration) {
        return new InMemoryClientRegistrationRepository(clientRegistration);
    }

    // Criar o serviço de cliente autorizado
    @Bean
    public OAuth2AuthorizedClientService auth2AuthorizedClientService(ClientRegistrationRepository clientRegistrationRepository) {
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
    }

    // Crie o gerenciador de cliente e o gerenciador de serviço autorizados usando o beans criados e configurados acima
    @Bean
    public AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientServiceAndManager (
            ClientRegistrationRepository clientRegistrationRepository,
            OAuth2AuthorizedClientService authorizedClientService) {

        OAuth2AuthorizedClientProvider authorizedClientProvider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .clientCredentials()
                        .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(
                        clientRegistrationRepository, authorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

        return authorizedClientManager;
    }
  

}
