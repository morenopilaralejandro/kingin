package com.pocket.kingin.domain;

public class AbilEffTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AbilEffTypeNotFoundException(Long id) {
		super("Could not find AbilEffType " + id);
	}
}
