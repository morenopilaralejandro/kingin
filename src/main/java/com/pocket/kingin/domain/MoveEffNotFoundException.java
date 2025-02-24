package com.pocket.kingin.domain;

public class MoveEffNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveEffNotFoundException(Long id) {
		super("Could not find MoveEff " + id);
	}
}
