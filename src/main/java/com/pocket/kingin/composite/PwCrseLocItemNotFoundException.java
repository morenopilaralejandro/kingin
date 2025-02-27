package com.pocket.kingin.composite;

public class PwCrseLocItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PwCrseLocItemNotFoundException(PwCrseLocItemId id) {
		super("Could not find PwCrseLocItem composite key(itemId, pwCrseId, step): " 
				+ id.getItemId() + ", "
				+ id.getPwCrseId() + ", "
				+ id.getStep());
	}
}
