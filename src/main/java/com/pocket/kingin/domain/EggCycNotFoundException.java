package com.pocket.kingin.domain;

public class EggCycNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EggCycNotFoundException(Long id) {
		super("Could not find EggCyc " + id);
	}
}
