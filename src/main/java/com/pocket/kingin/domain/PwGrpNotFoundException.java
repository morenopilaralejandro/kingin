package com.pocket.kingin.domain;

public class PwGrpNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PwGrpNotFoundException(Long id) {
		super("Could not find PwGrp " + id);
	}
}
