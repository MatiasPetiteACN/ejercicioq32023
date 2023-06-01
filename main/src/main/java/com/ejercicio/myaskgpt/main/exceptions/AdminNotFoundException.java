package com.ejercicio.myaskgpt.main.exceptions;


public class AdminNotFoundException extends Exception {

	private static final long serialVersionUID = -8650856448862927173L;

	public AdminNotFoundException (String message) {
		super(message);
	}
}
