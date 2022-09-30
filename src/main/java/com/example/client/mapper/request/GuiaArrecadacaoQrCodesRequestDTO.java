package com.example.client.mapper.request;

import java.util.List;

import com.example.client.mapper.response.ListaInforAdicionalResponseDTO;

/**
 * 
 * @author emanuel.sousa
 *
 */
public class GuiaArrecadacaoQrCodesRequestDTO {

	private int numeroConvenio;
	private String indicadorCodigoBarras;
	private String codigoGuiaRecebimento;
	private String emailDevedor;
	private int codigoPaisTelefoneDevedor;
	private int dddTelefoneDevedor;
	private String numeroTelefoneDevedor;
	private String codigoSolicitacaoBancoCentralBrasil;
	private String descricaoSolicitacaoPagamento;
	private float valorOriginalSolicitacao; // exemplo: 19.98
	private String cpfDevedor;
	private String nomeDevedor;
	private int quantidadeSegundoExpiracao;
	private List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional;

	public GuiaArrecadacaoQrCodesRequestDTO() {
	}

	public GuiaArrecadacaoQrCodesRequestDTO(int numeroConvenio, String indicadorCodigoBarras,
			String codigoGuiaRecebimento, String emailDevedor, int codigoPaisTelefoneDevedor, int dddTelefoneDevedor,
			String numeroTelefoneDevedor, String codigoSolicitacaoBancoCentralBrasil,
			String descricaoSolicitacaoPagamento, float valorOriginalSolicitacao, String cpfDevedor, String nomeDevedor,
			int quantidadeSegundoExpiracao, List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional) {
		this.numeroConvenio = numeroConvenio;
		this.indicadorCodigoBarras = indicadorCodigoBarras;
		this.codigoGuiaRecebimento = codigoGuiaRecebimento;
		this.emailDevedor = emailDevedor;
		this.codigoPaisTelefoneDevedor = codigoPaisTelefoneDevedor;
		this.dddTelefoneDevedor = dddTelefoneDevedor;
		this.numeroTelefoneDevedor = numeroTelefoneDevedor;
		this.codigoSolicitacaoBancoCentralBrasil = codigoSolicitacaoBancoCentralBrasil;
		this.descricaoSolicitacaoPagamento = descricaoSolicitacaoPagamento;
		this.valorOriginalSolicitacao = valorOriginalSolicitacao;
		this.cpfDevedor = cpfDevedor;
		this.nomeDevedor = nomeDevedor;
		this.quantidadeSegundoExpiracao = quantidadeSegundoExpiracao;
		this.listaInformacaoAdicional = listaInformacaoAdicional;
	}

	public int getNumeroConvenio() {
		return numeroConvenio;
	}

	public String getIndicadorCodigoBarras() {
		return indicadorCodigoBarras;
	}

	public String getCodigoGuiaRecebimento() {
		return codigoGuiaRecebimento;
	}

	public String getEmailDevedor() {
		return emailDevedor;
	}

	public int getCodigoPaisTelefoneDevedor() {
		return codigoPaisTelefoneDevedor;
	}

	public int getDddTelefoneDevedor() {
		return dddTelefoneDevedor;
	}

	public String getNumeroTelefoneDevedor() {
		return numeroTelefoneDevedor;
	}

	public String getCodigoSolicitacaoBancoCentralBrasil() {
		return codigoSolicitacaoBancoCentralBrasil;
	}

	public String getDescricaoSolicitacaoPagamento() {
		return descricaoSolicitacaoPagamento;
	}

	public float getValorOriginalSolicitacao() {
		return valorOriginalSolicitacao;
	}

	public String getCpfDevedor() {
		return cpfDevedor;
	}

	public String getNomeDevedor() {
		return nomeDevedor;
	}

	public int getQuantidadeSegundoExpiracao() {
		return quantidadeSegundoExpiracao;
	}

	public List<ListaInforAdicionalResponseDTO> getListaInformacaoAdicional() {
		return listaInformacaoAdicional;
	}

	public void setNumeroConvenio(int numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}

	public void setIndicadorCodigoBarras(String indicadorCodigoBarras) {
		this.indicadorCodigoBarras = indicadorCodigoBarras;
	}

	public void setCodigoGuiaRecebimento(String codigoGuiaRecebimento) {
		this.codigoGuiaRecebimento = codigoGuiaRecebimento;
	}

	public void setEmailDevedor(String emailDevedor) {
		this.emailDevedor = emailDevedor;
	}

	public void setCodigoPaisTelefoneDevedor(int codigoPaisTelefoneDevedor) {
		this.codigoPaisTelefoneDevedor = codigoPaisTelefoneDevedor;
	}

	public void setDddTelefoneDevedor(int dddTelefoneDevedor) {
		this.dddTelefoneDevedor = dddTelefoneDevedor;
	}

	public void setNumeroTelefoneDevedor(String numeroTelefoneDevedor) {
		this.numeroTelefoneDevedor = numeroTelefoneDevedor;
	}

	public void setCodigoSolicitacaoBancoCentralBrasil(String codigoSolicitacaoBancoCentralBrasil) {
		this.codigoSolicitacaoBancoCentralBrasil = codigoSolicitacaoBancoCentralBrasil;
	}

	public void setDescricaoSolicitacaoPagamento(String descricaoSolicitacaoPagamento) {
		this.descricaoSolicitacaoPagamento = descricaoSolicitacaoPagamento;
	}

	public void setValorOriginalSolicitacao(float valorOriginalSolicitacao) {
		this.valorOriginalSolicitacao = valorOriginalSolicitacao;
	}

	public void setCpfDevedor(String cpfDevedor) {
		this.cpfDevedor = cpfDevedor;
	}

	public void setNomeDevedor(String nomeDevedor) {
		this.nomeDevedor = nomeDevedor;
	}

	public void setQuantidadeSegundoExpiracao(int quantidadeSegundoExpiracao) {
		this.quantidadeSegundoExpiracao = quantidadeSegundoExpiracao;
	}

	public void setListaInformacaoAdicional(List<ListaInforAdicionalResponseDTO> listaInformacaoAdicional) {
		this.listaInformacaoAdicional = listaInformacaoAdicional;
	}

}
