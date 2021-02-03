package br.com.viziappdelivery.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter @Builder @Data
public class ClienteDomain {

	private String codigoCliente;
	private String nomeCliente;
	private int dddTelefone;
	private Long numeroTelefone;
	private String emailCliente;
}
