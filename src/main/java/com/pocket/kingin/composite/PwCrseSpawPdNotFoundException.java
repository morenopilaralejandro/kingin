package com.pocket.kingin.composite;

public class PwCrseSpawPdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PwCrseSpawPdNotFoundException(PwCrseSpawPdId id) {
		super("Could not find PwCrseSpawPd composite key(pdId, pwCrseId, pwGrpId, step): " 
				+ id.getPdId() + ", "
				+ id.getPwCrseId() + ", "
				+ id.getPwGrpId() + ", "
				+ id.getStep());
	}
}
