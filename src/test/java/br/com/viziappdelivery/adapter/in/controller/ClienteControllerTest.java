package br.com.viziappdelivery.adapter.in.controller;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.viziappdelivery.core.port.in.dto.ClienteFormDto;
import br.com.viziappdelivery.core.port.in.mapper.ClienteRequestMapper;
import br.com.viziappdelivery.core.port.out.dto.ClienteResponseDto;
import br.com.viziappdelivery.core.port.processor.ClienteProcessor;
import br.com.viziappdelivery.core.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMockMvc
@WebMvcTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class ClienteControllerTest {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	ClienteProcessor processor;
	
	@MockBean
	ClienteService clienteService;
	
	@MockBean
	ClienteRequestMapper requestMapper;
	
	private static String URL_API = "/cliente";

	@BeforeEach
	public void init() {
		processor = mock(ClienteProcessor.class);
		clienteService = mock(ClienteService.class);
		requestMapper = mock(ClienteRequestMapper.class);
	}
	
	@DisplayName("Deve criar um cliente com sucesso")
	@Test
	public void deve_criar_cliente_com_sucesso() throws Exception {
		
		ClienteFormDto cliente = getClienteRequestDto();
		
		log.info("Cliente: {}", cliente);
		
		String payloadJson = new ObjectMapper().writeValueAsString(cliente);
		
		log.info("Json Payoad: {}", payloadJson);
		
		BDDMockito.given(processor.cadastrar(Mockito.any(ClienteFormDto.class))).willReturn(getClienteResponseDto());
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(URL_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(payloadJson);
				
		mvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			//.andExpect( MockMvcResultMatchers.jsonPath("codigo").value("1"))
			.andExpect( MockMvcResultMatchers.jsonPath("nome").value(cliente.getNomeCliente()))
			.andExpect( MockMvcResultMatchers.jsonPath("ddd").value(cliente.getDddTelefone()))
			.andExpect( MockMvcResultMatchers.jsonPath("numero_telefone").value(cliente.getNumeroTelefone()))
			.andExpect( MockMvcResultMatchers.jsonPath("email_contato").value(cliente.getEmailCliente()));		
	}
	
	@DisplayName("Deve retornar healthcheck UP")
	@Test
	public void deve_retornar_healtcheh_up() throws Exception {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get(URL_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		mvc.perform(request)
			.andExpect(MockMvcResultMatchers.status().isOk());		
	}
	
	private ClienteResponseDto getClienteResponseDto() {
	    return ClienteResponseDto.builder()
		.codigoCliente("1")
		.nomeCliente(getClienteRequestDto().getNomeCliente())
		.dddTelefone(getClienteRequestDto().getDddTelefone())
		.numeroTelefone(getClienteRequestDto().getNumeroTelefone())
		.emailCliente(getClienteRequestDto().getEmailCliente())
		.build();
	}

	private ClienteFormDto getClienteRequestDto() {
		return ClienteFormDto
			.builder()
			.nomeCliente("Gisiona")
			.emailCliente("contato@gisiona.com.br")
			.dddTelefone(11)
			.numeroTelefone(979510575L)
			.build();
	}
}
