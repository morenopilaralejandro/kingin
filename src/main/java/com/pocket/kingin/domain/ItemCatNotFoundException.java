package com.pocket.kingin.domain;

public class ItemCatNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemCatNotFoundException(Long id) {
		super("Could not find ItemCat " + id);
	}
}
