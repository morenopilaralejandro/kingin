package com.pocket.kingin.domain;

public class EncNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EncNotFoundException(Long id) {
		super("Could not find Enc " + id);
	}
}
