package com.megas.wsrepeteco.services.exceptions;

public class UsersNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public UsersNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsersNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
