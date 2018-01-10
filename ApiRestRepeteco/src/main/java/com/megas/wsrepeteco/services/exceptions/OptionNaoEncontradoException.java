package com.megas.wsrepeteco.services.exceptions;

public class OptionNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public OptionNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public OptionNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
