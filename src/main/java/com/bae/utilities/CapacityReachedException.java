package com.bae.utilities;

public class CapacityReachedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CapacityReachedException() {
		super();
	}

	public CapacityReachedException(String message) {
		super(message);
	}
}
