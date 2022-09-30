package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author emanuel.sousa
 *
 */


//@Configuration
//@EnableScheduling
@SpringBootApplication
public class DemoApplication {
	
	//private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	//@Value("${chave.gw.dev.app-key}")
	//private String chaveDevAppKey;
	
	//@Autowired
	//private TokenService tokenService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Injetar o serviço de cliente autorizado API SANDBOX BB e o gerente de cliente autorizado da classe OAuthClientConfiguration
	//@Autowired
	//private AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientServiceAndManager;

	/**
	 * GET https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes
	 * rodar job a cada 30 segundos
	 */
	//@Scheduled(fixedRate = 30000)
	/**
	private void getArrecadaoQRCodeTeste() {
		
		var token = tokenService.getToken();

		// Adicione o JWT aos cabeçalhos RestTemplate
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		var request = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();

		String numeroConvenio = "78806";
		String codigoGuiaRecebimento = "83660000000199800053846101173758000000000022";

		var uri = "https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes" 
				+ "?gw-dev-app-key=" + chaveDevAppKey
				+ "&" 
				+ "numeroConvenio=" + numeroConvenio + "&codigoGuiaRecebimento=" + codigoGuiaRecebimento;

		LOG.info("URI: {}", uri);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		String resultado = response.getBody();
		LOG.info("Response/Job: " + resultado);
		
	} **/
	
	/**
	 * GET https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes
	 * Rodar Job a cada 1 minuto
	 */
	//@Scheduled(fixedRate = 60000)
	/**
	private void getArrecadacaoQrCodes() {
		
		// Crie uma solicitação OAuth2 para o provedor API SANDBOX BB
		OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest.withClientRegistrationId("sandboxbb")
			.principal("API SANDBOX BB")
			.build();

		// Execute a solicitação de autorização real usando o serviço de cliente autorizado e o cliente autorizado Gerente. 
		// É aqui que o JWT é recuperado dos servidores API SANDBOX BB.
		OAuth2AuthorizedClient authorizedClient = this.authorizedClientServiceAndManager.authorize(authorizeRequest);

		// Obtenha o token do objeto de cliente autorizado
		OAuth2AccessToken accessToken = Objects.requireNonNull(authorizedClient).getAccessToken();

		LOG.info("Issued: " + accessToken.getIssuedAt().toString() + ", Expira:" + accessToken.getExpiresAt().toString());
		LOG.info("Scopes: " + accessToken.getScopes().toString());
		LOG.info("Token: " + accessToken.getTokenValue());

		////////////////////////////////////////////////////
		//  PASSO 2: Use o JWT e ligue para o serviço
		////////////////////////////////////////////////////

		// Adicione o JWT aos cabeçalhos RestTemplate
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken.getTokenValue());
		var request = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();

		String numeroConvenio = "78806";
		String codigoGuiaRecebimento = "83660000000199800053846101173758000000000022";

		var uri = "https://api.sandbox.bb.com.br/pix-bb/v1/arrecadacao-qrcodes" 
				+ "?gw-dev-app-key=" + chaveDevAppKey
				+ "&" 
				+ "numeroConvenio=" + numeroConvenio + "&codigoGuiaRecebimento=" + codigoGuiaRecebimento;
		
		LOG.info("URI: {}", uri);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

		String resultado = response.getBody();
		LOG.info("Response/Job: " + resultado);


	}**/
	
	
}
