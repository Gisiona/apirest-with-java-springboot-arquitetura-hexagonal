package br.com.viziappdelivery.adapter.in.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.viziappdelivery.core.port.in.dto.ClienteFormDto;
import br.com.viziappdelivery.core.port.processor.ClienteProcessor;

@RestController
@ResponseBody
@RequestMapping("/cliente")
public class ClienteController {

	private ClienteProcessor processor;
	
	@Autowired
	public ClienteController(ClienteProcessor _processor) {
		this.processor = _processor;
	}
	
	
	@GetMapping
	public String health() {
		return "200 OK";
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteFormDto requestCliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(requestCliente);
		//return ResponseEntity.status(HttpStatus.CREATED).body(processor.cadastrar(requestCliente));		
	}
	
}
