package com.pocket.kingin.composite;

public class PdHoldItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdHoldItemNotFoundException(PdHoldItemId id) {
		super("Could not find PdHoldItem composite key(pdId, itemId): " 
				+ id.getPdId() + ", "
				+ id.getItemId());
	}
}
