package com.ejercicio.myaskgpt.main.exceptions;


public class QuestionNotFoundException extends Exception {

	private static final long serialVersionUID = 3644870092081606900L;

	public QuestionNotFoundException (String message) {
		super(message);
	}
}
