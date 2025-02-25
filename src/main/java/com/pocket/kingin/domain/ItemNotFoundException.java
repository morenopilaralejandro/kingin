package com.pocket.kingin.domain;

public class ItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(Long id) {
		super("Could not find Item " + id);
	}
}
