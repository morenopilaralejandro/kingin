package com.pocket.kingin.domain;

public class ItemTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemTypeNotFoundException(Long id) {
		super("Could not find ItemType " + id);
	}
}
