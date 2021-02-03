package br.com.viziappdelivery.core.port.out.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import br.com.viziappdelivery.core.port.out.dto.ClienteResponseDto;
import br.com.viziappdelivery.domain.ClienteDomain;

@Mapper
@DecoratedWith(ClienteResponseMapperDecorator.class)
public interface ClienteResponseMapper {
	public ClienteResponseDto toClienteResponseDto(ClienteDomain cliente);
}
