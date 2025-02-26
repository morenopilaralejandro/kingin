package com.pocket.kingin.composite;

public class PdYielStatNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdYielStatNotFoundException(PdYielStatId id) {
		super("Could not find PdYielStat composite key(pdId, statId): " 
				+ id.getPdId() + ", "
				+ id.getStatId());
	}
}
