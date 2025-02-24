package com.pocket.kingin.domain;

public class GndrNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GndrNotFoundException(Long id) {
		super("Could not find Gndr " + id);
	}
}
