package com.pocket.kingin.domain;

public class ItemObtNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemObtNotFoundException(Long id) {
		super("Could not find ItemObt " + id);
	}
}
