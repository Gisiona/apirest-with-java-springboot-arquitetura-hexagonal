package br.com.viziappdelivery.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viziappdelivery.adapter.out.persistence.adapter.ClientePersistenceAdapter;
import br.com.viziappdelivery.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClienteService {
	
	@Autowired
	private ClientePersistenceAdapter clienteAdapter;
		
	public ClienteDomain cadastrar(ClienteDomain clienteDomain) {
		return clienteAdapter.cadastrar(clienteDomain);
	}

}
