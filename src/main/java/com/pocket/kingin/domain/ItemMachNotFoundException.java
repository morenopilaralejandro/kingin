package com.pocket.kingin.domain;

public class ItemMachNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemMachNotFoundException(Long id) {
		super("Could not find ItemMach " + id);
	}
}
