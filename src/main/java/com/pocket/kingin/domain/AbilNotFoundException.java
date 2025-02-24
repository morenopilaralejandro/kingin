package com.pocket.kingin.domain;

public class AbilNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AbilNotFoundException(Long id) {
		super("Could not find Abil " + id);
	}
}
