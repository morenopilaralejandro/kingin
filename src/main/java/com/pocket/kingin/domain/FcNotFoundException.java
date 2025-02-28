package com.pocket.kingin.domain;

public class FcNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FcNotFoundException(Long id) {
		super("Could not find Fc " + id);
	}
}
