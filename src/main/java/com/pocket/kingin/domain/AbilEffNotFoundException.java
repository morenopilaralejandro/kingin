package com.pocket.kingin.domain;

public class AbilEffNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AbilEffNotFoundException(Long id) {
		super("Could not find AbilEff " + id);
	}
}
