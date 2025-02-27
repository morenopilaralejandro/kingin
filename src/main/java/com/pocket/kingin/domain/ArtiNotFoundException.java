package com.pocket.kingin.domain;

public class ArtiNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ArtiNotFoundException(Long id) {
		super("Could not find Arti " + id);
	}
}
