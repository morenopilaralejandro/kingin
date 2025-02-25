package com.pocket.kingin.domain;

public class CurrNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CurrNotFoundException(Long id) {
		super("Could not find Curr " + id);
	}
}
