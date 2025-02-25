package com.pocket.kingin.domain;

public class ZoneNameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ZoneNameNotFoundException(Long id) {
		super("Could not find ZoneName " + id);
	}
}
