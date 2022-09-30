package com.example.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.client.mapper.request.GuiaArrecadacaoQrCodesRequestDTO;
import com.example.client.mapper.response.GerarQrCodePagamentoPixResponseDTO;
import com.example.client.mapper.response.GuiaArrecadacaoQrCodeResponseDTO;
import com.example.client.service.ArrecadacaoQRcodeService;

/**
 * 
 * @author emanuel.sousa
 *
 */

@RestController
@RequestMapping(value = "/arrecadacao-qrcodes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArrecadacaoQRcodesContoller {

	private static final Logger log = LoggerFactory.getLogger(ArrecadacaoQRcodesContoller.class);

	@Autowired
	private ArrecadacaoQRcodeService arrecadacaoQRcodeService;
	
	@GetMapping
	public ResponseEntity<GuiaArrecadacaoQrCodeResponseDTO> buscarArrecadacaoQrCodePagamentoPix(
			@RequestParam(value = "numeroConvenio") String numeroConvenio, 
			@RequestParam(value = "codigoGuiaRecebimento") String codigoGuiaRecebimento) {
		log.info("GET /arrecadacao-qrcodes - {};{}", numeroConvenio, codigoGuiaRecebimento);
		var resposta = arrecadacaoQRcodeService.buscarArrecadacaoQrCodePagamentoPix(numeroConvenio, codigoGuiaRecebimento);
		return resposta != null ? ResponseEntity.ok().body(resposta) : ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/{txid}")
	public ResponseEntity<GuiaArrecadacaoQrCodeResponseDTO> buscarArrecadacaoQrCodePagamentoPixPorID(
			@PathVariable String txid,
			@RequestParam(value = "numeroConvenio") String numeroConvenio) {
		log.info("GET /arrecadacao-qrcodes/{} - {}", txid, numeroConvenio);
		var resposta = arrecadacaoQRcodeService.buscarArrecadacaoQrCodePagamentoPixPorId(txid, numeroConvenio);
		return resposta != null ? ResponseEntity.ok().body(resposta) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<GerarQrCodePagamentoPixResponseDTO> criarQrCodePagamentoInstantaneoPix(@RequestBody GuiaArrecadacaoQrCodesRequestDTO requestDTO) {
		log.info("POST /arrecadacao-qrcodes - body:{}", requestDTO);
		var resposta = arrecadacaoQRcodeService.criarQrCodePagamentoInstantaneoPix(requestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	}
	
}
