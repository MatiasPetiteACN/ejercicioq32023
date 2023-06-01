package com.ejercicio.myaskgpt.main.exceptions;


public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -2614481601834052058L;

	public UserNotFoundException (String message) {
		super(message);
	}
}
