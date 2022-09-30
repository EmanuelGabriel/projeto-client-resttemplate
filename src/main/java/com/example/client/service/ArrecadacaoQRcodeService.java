package com.example.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.client.config.ApiFactoryProperties;
import com.example.client.mapper.request.GuiaArrecadacaoQrCodesRequestDTO;
import com.example.client.mapper.response.GerarQrCodePagamentoPixResponseDTO;
import com.example.client.mapper.response.GuiaArrecadacaoQrCodeResponseDTO;
import com.example.client.service.exception.FalhaRecursoException;
import com.example.client.utils.JSONUtil;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Service
public class ArrecadacaoQRcodeService {

	private static final Logger log = LoggerFactory.getLogger(ArrecadacaoQRcodeService.class);
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApiFactoryProperties apiFactoryProperties;
	
	/**
	 * 
	 * @param numeroConvenio
	 * @param codigoGuiaRecebimento
	 * @return GuiaArrecadacaoQrCodeResponseDTO
	 */
	public GuiaArrecadacaoQrCodeResponseDTO buscarArrecadacaoQrCodePagamentoPix(String numeroConvenio, String codigoGuiaRecebimento) {
		log.info("Consultar um QR Code de pagamentos instantâneos (PIX) por guia de recebimento (com ou sem código de barras) - {};{}", numeroConvenio, codigoGuiaRecebimento);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + tokenService.getToken());
		var request = new HttpEntity<>(headers);
		
		var url = apiFactoryProperties.getUriBase() + "/arrecadacao-qrcodes?gw-dev-app-key=" + apiFactoryProperties.getChaveGwDevApp() + "&"
				+ "numeroConvenio=" + numeroConvenio + "&codigoGuiaRecebimento=" + codigoGuiaRecebimento;
		log.info("URL: {}", url);
		
		String response = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
		log.info("response: " + response);
		
		GuiaArrecadacaoQrCodeResponseDTO dto = JSONUtil.convertJsonToJava(response, GuiaArrecadacaoQrCodeResponseDTO.class);
		
		return dto;
	}
	
	
	public GuiaArrecadacaoQrCodeResponseDTO buscarArrecadacaoQrCodePagamentoPixPorId(String txid, String numeroConvenio) {
		log.info("Consultar um QR Code de pagamentos instantâneos (PIX) por guia de recebimento (com ou sem código de barras) por ID - {};{}", txid, numeroConvenio);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + tokenService.getToken());
		var request = new HttpEntity<>(headers);
		
		var uri = apiFactoryProperties.getUriBase() + "/arrecadacao-qrcodes/" + txid +  "?gw-dev-app-key=" + apiFactoryProperties.getChaveGwDevApp() + "&" + "numeroConvenio=" + numeroConvenio;
		log.info("URI: {}", uri);
		
		String response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class).getBody();
		log.info("response: " + response);
		
		GuiaArrecadacaoQrCodeResponseDTO dto = JSONUtil.convertJsonToJava(response, GuiaArrecadacaoQrCodeResponseDTO.class);

		return dto;
	}
	
	public GerarQrCodePagamentoPixResponseDTO criarQrCodePagamentoInstantaneoPix(GuiaArrecadacaoQrCodesRequestDTO requestDTO) {
        log.info("Gera um QR Code de pagamento instantâneo (PIX) para uma guia de arrecadação (com ou sem código de barras) - request: {}", requestDTO);

        try {
        	
        	HttpHeaders headers = new HttpHeaders();
    		headers.add("Authorization", "Bearer " + tokenService.getToken());
    		HttpEntity<GuiaArrecadacaoQrCodesRequestDTO> httpEntityRequest = new HttpEntity<>(requestDTO, headers);

            var url = apiFactoryProperties.getUriBase() + "/arrecadacao-qrcodes?gw-dev-app-key=" + apiFactoryProperties.getChaveGwDevApp();
            log.info("URL: {}", url);

            // var guiaArrecadacaoQrCodesEntityResponseDTO = mapper.map(requestDTO, GuiaArrecadacaoQrCodesEntityResponseDTO.class);

            GerarQrCodePagamentoPixResponseDTO dto = restTemplate.exchange(url, HttpMethod.POST, httpEntityRequest, GerarQrCodePagamentoPixResponseDTO.class).getBody();

            return dto;

        } catch (Exception e) {
            throw new FalhaRecursoException(e.getMessage());
        }
    }
	
}
