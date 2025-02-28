package com.pocket.kingin.domain;

public class UsrNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsrNotFoundException(Long id) {
		super("Could not find Usr " + id);
	}
}
