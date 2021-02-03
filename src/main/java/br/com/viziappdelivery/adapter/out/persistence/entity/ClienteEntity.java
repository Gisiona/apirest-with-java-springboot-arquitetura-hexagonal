package br.com.viziappdelivery.adapter.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @Builder @Data @Entity @Table(name = "tb_clientes")
public class ClienteEntity {

	@Id
	private UUID codigo;
	private String nome;
	private int ddd;
	private Long whatsapp;
	private String email;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;
}
