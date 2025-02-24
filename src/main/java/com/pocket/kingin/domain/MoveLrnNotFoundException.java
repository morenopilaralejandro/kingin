package com.pocket.kingin.domain;

public class MoveLrnNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveLrnNotFoundException(Long id) {
		super("Could not find MoveLrn " + id);
	}
}
