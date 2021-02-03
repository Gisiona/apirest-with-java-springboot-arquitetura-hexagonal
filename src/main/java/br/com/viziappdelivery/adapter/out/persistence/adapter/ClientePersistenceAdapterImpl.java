package br.com.viziappdelivery.adapter.out.persistence.adapter;

import org.springframework.stereotype.Component;

import br.com.viziappdelivery.adapter.out.persistence.entity.ClienteEntity;
import br.com.viziappdelivery.adapter.out.persistence.mapper.ClientePersistenceMapper;
import br.com.viziappdelivery.adapter.out.persistence.repository.ClienteRepository;
import br.com.viziappdelivery.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClientePersistenceAdapterImpl implements ClientePersistenceAdapter{

	
	private ClienteRepository clienteRepository;
	

	private ClientePersistenceMapper persistenceMapper;
	
	@Override
	public ClienteDomain cadastrar(ClienteDomain clienteDomain) {
		ClienteEntity entity = persistenceMapper.toEntity(clienteDomain);
		ClienteEntity entityResponse = clienteRepository.saveAndFlush(entity);
		return persistenceMapper.toDomain(entityResponse);
	}

}
