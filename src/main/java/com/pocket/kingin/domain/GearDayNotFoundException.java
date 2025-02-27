package com.pocket.kingin.domain;

public class GearDayNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GearDayNotFoundException(Long id) {
		super("Could not find GearDay " + id);
	}
}
