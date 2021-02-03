package br.com.viziappdelivery.core.port.out.mapper;

import org.springframework.stereotype.Component;

import br.com.viziappdelivery.core.port.out.dto.ClienteResponseDto;
import br.com.viziappdelivery.domain.ClienteDomain;

@Component
public abstract class ClienteResponseMapperDecorator implements ClienteResponseMapper {

	public ClienteResponseDto toClienteResponseDto(ClienteDomain clienteDomain) {
		return ClienteResponseDto.builder()
				.codigoCliente(clienteDomain.getCodigoCliente().toString())
				.nomeCliente(clienteDomain.getNomeCliente())
				.emailCliente(clienteDomain.getEmailCliente())
				.dddTelefone(clienteDomain.getDddTelefone())
				.numeroTelefone(clienteDomain.getNumeroTelefone())
				.build();
	}
}
