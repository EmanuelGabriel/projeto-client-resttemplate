package com.example.client.mapper.response;

/**
 * 
 * @author emanuel.sousa
 *
 */
public class GerarQrCodePagamentoPixResponseDTO {

	private String timestampCriacaoSolicitacao;
	private String estadoSolicitacao;
	private String codigoConciliacaoSolicitante;
	private int numeroVersaoSolicitacaoPagamento;
	private String linkQrCode;
	private String qrCode;

	public GerarQrCodePagamentoPixResponseDTO() {
		super();
	}

	public GerarQrCodePagamentoPixResponseDTO(String timestampCriacaoSolicitacao, String estadoSolicitacao,
			String codigoConciliacaoSolicitante, int numeroVersaoSolicitacaoPagamento, String linkQrCode,
			String qrCode) {
		super();
		this.timestampCriacaoSolicitacao = timestampCriacaoSolicitacao;
		this.estadoSolicitacao = estadoSolicitacao;
		this.codigoConciliacaoSolicitante = codigoConciliacaoSolicitante;
		this.numeroVersaoSolicitacaoPagamento = numeroVersaoSolicitacaoPagamento;
		this.linkQrCode = linkQrCode;
		this.qrCode = qrCode;
	}

	public String getTimestampCriacaoSolicitacao() {
		return timestampCriacaoSolicitacao;
	}

	public String getEstadoSolicitacao() {
		return estadoSolicitacao;
	}

	public String getCodigoConciliacaoSolicitante() {
		return codigoConciliacaoSolicitante;
	}

	public int getNumeroVersaoSolicitacaoPagamento() {
		return numeroVersaoSolicitacaoPagamento;
	}

	public String getLinkQrCode() {
		return linkQrCode;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setTimestampCriacaoSolicitacao(String timestampCriacaoSolicitacao) {
		this.timestampCriacaoSolicitacao = timestampCriacaoSolicitacao;
	}

	public void setEstadoSolicitacao(String estadoSolicitacao) {
		this.estadoSolicitacao = estadoSolicitacao;
	}

	public void setCodigoConciliacaoSolicitante(String codigoConciliacaoSolicitante) {
		this.codigoConciliacaoSolicitante = codigoConciliacaoSolicitante;
	}

	public void setNumeroVersaoSolicitacaoPagamento(int numeroVersaoSolicitacaoPagamento) {
		this.numeroVersaoSolicitacaoPagamento = numeroVersaoSolicitacaoPagamento;
	}

	public void setLinkQrCode(String linkQrCode) {
		this.linkQrCode = linkQrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}
