package com.pocket.kingin.composite;

public class PdDimoGndrNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdDimoGndrNotFoundException(PdDimoGndrId id) {
		super("Could not find PdDimoGndr composite key(pdId, gndrId): " 
				+ id.getPdId() + ", "
				+ id.getGndrId());
	}
}
