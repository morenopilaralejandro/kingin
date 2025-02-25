package com.pocket.kingin.domain;

public class ShopNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ShopNotFoundException(Long id) {
		super("Could not find Shop " + id);
	}
}
