package com.pocket.kingin.domain;

public class EvoFamNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EvoFamNotFoundException(Long id) {
		super("Could not find EvoFam " + id);
	}
}
