package com.pocket.kingin.domain;

public class StatNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StatNotFoundException(Long id) {
		super("Could not find Stat " + id);
	}
}
