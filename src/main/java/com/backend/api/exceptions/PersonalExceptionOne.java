package com.backend.api.exceptions;

public class PersonalExceptionOne extends RuntimeException {

	public PersonalExceptionOne(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * if (true) {
	 * 	throw new PersonalExceptionOne("mensaje");
	 * }
	 * 
	 * */

}
