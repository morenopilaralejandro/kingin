package com.pocket.kingin.domain;

public class MoveTutoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveTutoNotFoundException(Long id) {
		super("Could not find MoveTuto " + id);
	}
}
