package br.com.viziappdelivery.core.port.out.exception;

public class ValidationFieldException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int status;
	private String campo;
	private String mensagem;
	
	
	public ValidationFieldException(int status, String campo, String mensagem) {
		super();
		this.status = status;
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
}
