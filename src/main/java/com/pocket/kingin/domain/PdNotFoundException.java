package com.pocket.kingin.domain;

public class PdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdNotFoundException(Long id) {
		super("Could not find Pd " + id);
	}
}
