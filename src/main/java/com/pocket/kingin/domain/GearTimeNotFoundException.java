package com.pocket.kingin.domain;

public class GearTimeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GearTimeNotFoundException(Long id) {
		super("Could not find GearTime " + id);
	}
}
