package com.pocket.kingin.domain;

public class ItemFossNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemFossNotFoundException(Long id) {
		super("Could not find ItemFoss " + id);
	}
}
