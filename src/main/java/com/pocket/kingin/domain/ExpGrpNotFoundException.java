package com.pocket.kingin.domain;

public class ExpGrpNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExpGrpNotFoundException(Long id) {
		super("Could not find ExpGrp " + id);
	}
}
