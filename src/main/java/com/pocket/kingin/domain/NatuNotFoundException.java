package com.pocket.kingin.domain;

public class NatuNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NatuNotFoundException(Long id) {
		super("Could not find Natu " + id);
	}
}
