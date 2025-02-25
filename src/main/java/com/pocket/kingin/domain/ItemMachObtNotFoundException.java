package com.pocket.kingin.domain;

public class ItemMachObtNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemMachObtNotFoundException(Long id) {
		super("Could not find ItemMachObt " + id);
	}
}
