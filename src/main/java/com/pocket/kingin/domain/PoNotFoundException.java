package com.pocket.kingin.domain;

public class PoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PoNotFoundException(Long id) {
		super("Could not find Po " + id);
	}
}
