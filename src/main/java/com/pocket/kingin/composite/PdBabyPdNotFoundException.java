package com.pocket.kingin.composite;

public class PdBabyPdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdBabyPdNotFoundException(PdBabyPdId id) {
		super("Could not find PdBabyPd composite key(pdIdPare, pdIdBaby): " 
				+ id.getPdIdPare() + ", "
				+ id.getPdIdBaby());
	}
}
