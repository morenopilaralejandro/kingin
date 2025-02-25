package com.pocket.kingin.composite;

public class MoveRememberedTutoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MoveRememberedTutoNotFoundException(MoveRememberedTutoId id) {
		super("Could not find MoveRememberedTuto composite key(moveId, moveTutoId): " 
				+ id.getMoveId() + ", "
				+ id.getMoveTutoId());
	}
}
