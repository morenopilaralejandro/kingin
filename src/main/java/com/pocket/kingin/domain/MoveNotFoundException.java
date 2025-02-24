package com.pocket.kingin.domain;

public class MoveNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveNotFoundException(Long id) {
		super("Could not find Move " + id);
	}
}
