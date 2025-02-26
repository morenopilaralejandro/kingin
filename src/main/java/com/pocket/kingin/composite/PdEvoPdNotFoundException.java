package com.pocket.kingin.composite;

public class PdEvoPdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdEvoPdNotFoundException(PdEvoPdId id) {
		super("Could not find PdEvoPd composite key(pdIdSta, pdIdEnd): " 
				+ id.getPdIdSta() + ", "
				+ id.getPdIdEnd());
	}
}
