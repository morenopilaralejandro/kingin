package com.pocket.kingin.domain;

public class EvoCondNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EvoCondNotFoundException(Long id) {
		super("Could not find EvoCond " + id);
	}
}
