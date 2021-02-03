package br.com.viziappdelivery.adapter.out.persistence.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import br.com.viziappdelivery.adapter.out.persistence.entity.ClienteEntity;
import br.com.viziappdelivery.domain.ClienteDomain;

@Mapper
@DecoratedWith(ClientePersistenceMapperDecorator.class)
public interface ClientePersistenceMapper {

	public ClienteEntity toEntity(ClienteDomain clienteDomain);
	public ClienteDomain toDomain(ClienteEntity clienteEntity);
}
