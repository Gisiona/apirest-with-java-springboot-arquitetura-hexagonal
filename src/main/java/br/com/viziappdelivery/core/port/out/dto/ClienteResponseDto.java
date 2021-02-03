package br.com.viziappdelivery.core.port.out.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter @Builder @Data
public class ClienteResponseDto {

	@JsonProperty("codigo")
	private String codigoCliente;
	
	@JsonProperty("nome")
	private String nomeCliente;
	
	@JsonProperty("ddd")
	private int dddTelefone;
	
	@JsonProperty("numero_telefone")
	private Long numeroTelefone;
	
	@JsonProperty("email_contato")
	private String emailCliente;
}
