package br.com.viziappdelivery.core.port.in.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ClienteFormDto {
	
	@NotBlank(message = "O nome do cliente é obrigatório e não pode ser nulo ou vazio.")
	@JsonProperty("nome")
	private String nomeCliente;
	
	@NotNull(message = "O ddd do telefone é obrigatório.")
	@JsonProperty("ddd")
	private int dddTelefone;
	
	@NotNull(message = "O número do telefone é obrigatório")	
	@JsonProperty("numero_telefone")
	private Long numeroTelefone;
	
	@NotBlank(message = "O e-mail é obrigatório e não pode ser nulo ou vazio.")
	@JsonProperty("email_contato")
	private String emailCliente;
	
}
