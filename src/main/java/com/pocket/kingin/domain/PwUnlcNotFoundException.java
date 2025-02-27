package com.pocket.kingin.domain;

public class PwUnlcNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PwUnlcNotFoundException(Long id) {
		super("Could not find PwUnlc " + id);
	}
}
