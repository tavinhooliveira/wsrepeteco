package com.megas.wsrepeteco.services.exceptions;

public class UsersExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public UsersExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public UsersExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
