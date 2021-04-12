package br.com.desafio.config.exception;

public class ExistingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExistingException(String errorMessage) {
		super(errorMessage);
	}
}