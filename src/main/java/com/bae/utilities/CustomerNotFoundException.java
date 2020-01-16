package com.bae.utilities;

import javax.persistence.EntityNotFoundException;

public class CustomerNotFoundException extends EntityNotFoundException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
	
}
