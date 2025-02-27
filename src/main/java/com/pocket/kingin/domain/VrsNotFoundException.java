package com.pocket.kingin.domain;

public class VrsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VrsNotFoundException(Long id) {
		super("Could not find Vrs " + id);
	}
}
