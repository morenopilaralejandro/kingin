package com.pocket.kingin.composite;

public class PdLinaEvoFamNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdLinaEvoFamNotFoundException(PdLinaEvoFamId id) {
		super("Could not find PdLinaEvoFam composite key(pdId, evoFamId): " 
				+ id.getPdId() + ", "
				+ id.getEvoFamId());
	}
}
