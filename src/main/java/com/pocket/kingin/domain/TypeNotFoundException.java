package com.pocket.kingin.domain;

public class TypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TypeNotFoundException(Long id) {
		super("Could not find Type " + id);
	}
}
