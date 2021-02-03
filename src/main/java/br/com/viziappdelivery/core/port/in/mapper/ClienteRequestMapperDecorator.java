package br.com.viziappdelivery.core.port.in.mapper;

import org.springframework.stereotype.Component;

import br.com.viziappdelivery.core.port.in.dto.ClienteFormDto;
import br.com.viziappdelivery.domain.ClienteDomain;

@Component
public abstract class ClienteRequestMapperDecorator implements ClienteRequestMapper {

	public ClienteDomain toClienteDomain(ClienteFormDto clienteRequest) {
		return ClienteDomain.builder()
				.nomeCliente(clienteRequest.getNomeCliente())
				.emailCliente(clienteRequest.getEmailCliente())
				.dddTelefone(clienteRequest.getDddTelefone())
				.numeroTelefone(clienteRequest.getNumeroTelefone())
				.build();
	}
	
}
