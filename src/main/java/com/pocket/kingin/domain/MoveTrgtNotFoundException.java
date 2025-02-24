package com.pocket.kingin.domain;

public class MoveTrgtNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveTrgtNotFoundException(Long id) {
		super("Could not find MoveTrgt " + id);
	}
}
