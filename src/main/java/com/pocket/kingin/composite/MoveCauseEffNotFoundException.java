package com.pocket.kingin.composite;

public class MoveCauseEffNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveCauseEffNotFoundException(MoveCauseEffId id) {
		super("Could not find MoveCauseEff composite key(moveId, moveEffId): " 
				+ id.getMoveId() + ", "
				+ id.getMoveEffId());
	}
}
