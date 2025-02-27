package com.pocket.kingin.domain;

public class ArtiTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ArtiTypeNotFoundException(Long id) {
		super("Could not find ArtiType " + id);
	}
}
