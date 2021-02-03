package br.com.viziappdelivery.core.port.in.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import br.com.viziappdelivery.core.port.in.dto.ClienteFormDto;
import br.com.viziappdelivery.domain.ClienteDomain;

@Mapper
@DecoratedWith(ClienteRequestMapperDecorator.class)
public interface ClienteRequestMapper {
	
	public ClienteDomain toClienteDomain(ClienteFormDto clienteDto);
}
