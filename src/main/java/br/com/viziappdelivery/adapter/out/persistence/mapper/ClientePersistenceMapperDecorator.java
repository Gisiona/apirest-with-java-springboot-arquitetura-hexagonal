package br.com.viziappdelivery.adapter.out.persistence.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.viziappdelivery.adapter.out.persistence.entity.ClienteEntity;
import br.com.viziappdelivery.domain.ClienteDomain;

@Component
public abstract class ClientePersistenceMapperDecorator implements ClientePersistenceMapper{

	@Override
	public ClienteEntity toEntity(ClienteDomain clienteDomain) {
		LocalDateTime data = LocalDateTime.now();
		
		return ClienteEntity
				.builder()
				.codigo(UUID.randomUUID())
				.dataAtualizacao(data)
				.dataCadastro(data)
				.nome(clienteDomain.getNomeCliente())
				.email(clienteDomain.getEmailCliente())
				.ddd(clienteDomain.getDddTelefone())
				.whatsapp(clienteDomain.getNumeroTelefone())
				.build();
	}

	@Override
	public ClienteDomain toDomain(ClienteEntity clienteEntity) {
		return ClienteDomain
				.builder()
				.codigoCliente(clienteEntity.getCodigo().toString())
				.nomeCliente(clienteEntity.getNome())
				.emailCliente(clienteEntity.getEmail())
				.dddTelefone(clienteEntity.getDdd())
				.numeroTelefone(clienteEntity.getWhatsapp())
				.build();
	}

}
