package com.pocket.kingin.composite;

public class PdLrnMoveNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdLrnMoveNotFoundException(PdLrnMoveId id) {
		super("Could not find PdLrnMove composite key(pdId, moveId, moveLrnId, lv): " 
				+ id.getPdId() + ", "
				+ id.getMoveId() + ", "
				+ id.getMoveLrnId() + ", "
				+ id.getLv());
	}
}
