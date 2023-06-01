package com.ejercicio.myaskgpt.main.exceptions;


public class NoAccessException extends Exception {

	private static final long serialVersionUID = 5158184833428976480L;

	public NoAccessException (String message) {
		super(message);
	}
}
