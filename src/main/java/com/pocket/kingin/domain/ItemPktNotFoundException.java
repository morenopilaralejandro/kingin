package com.pocket.kingin.domain;

public class ItemPktNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemPktNotFoundException(Long id) {
		super("Could not find ItemPkt " + id);
	}
}
