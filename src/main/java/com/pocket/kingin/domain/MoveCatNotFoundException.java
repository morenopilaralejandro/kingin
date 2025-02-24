package com.pocket.kingin.domain;

public class MoveCatNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveCatNotFoundException(Long id) {
		super("Could not find MoveCat " + id);
	}
}
