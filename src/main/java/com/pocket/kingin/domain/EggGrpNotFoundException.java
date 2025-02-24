package com.pocket.kingin.domain;

public class EggGrpNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EggGrpNotFoundException(Long id) {
		super("Could not find EggGrp " + id);
	}
}
