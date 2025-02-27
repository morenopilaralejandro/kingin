package com.pocket.kingin.domain;

public class GearCallNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GearCallNotFoundException(Long id) {
		super("Could not find GearCall " + id);
	}
}
