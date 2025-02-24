package com.pocket.kingin.domain;

public class MoveMthdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveMthdNotFoundException(Long id) {
		super("Could not find MoveMthd " + id);
	}
}
