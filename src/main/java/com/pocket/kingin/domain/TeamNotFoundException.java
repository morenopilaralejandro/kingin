package com.pocket.kingin.domain;

public class TeamNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TeamNotFoundException(Long id) {
		super("Could not find Team " + id);
	}
}
