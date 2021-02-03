package br.com.viziappdelivery.core.port.processor;

import org.springframework.stereotype.Component;

import br.com.viziappdelivery.core.port.in.dto.ClienteFormDto;
import br.com.viziappdelivery.core.port.in.mapper.ClienteRequestMapper;
import br.com.viziappdelivery.core.port.out.dto.ClienteResponseDto;
import br.com.viziappdelivery.core.port.out.mapper.ClienteResponseMapper;
import br.com.viziappdelivery.core.service.ClienteService;
import br.com.viziappdelivery.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClienteProcessor {

	
	private ClienteService clienteService;
	
	
	private ClienteRequestMapper requestMapper;
	
	
	private ClienteResponseMapper responseMapper;
	
	public ClienteResponseDto cadastrar(ClienteFormDto request) {
		ClienteDomain domain = clienteService.cadastrar(requestMapper.toClienteDomain(request));
		return responseMapper.toClienteResponseDto(domain);
	}
}
