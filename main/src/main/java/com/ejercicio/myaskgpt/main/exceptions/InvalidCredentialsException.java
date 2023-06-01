package com.ejercicio.myaskgpt.main.exceptions;


public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 8716702868153926996L;

	public InvalidCredentialsException (String message) {
		super(message);
	}
}
