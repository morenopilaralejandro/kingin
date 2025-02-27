package com.pocket.kingin.domain;

public class PwCrseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PwCrseNotFoundException(Long id) {
		super("Could not find PwCrse " + id);
	}
}
