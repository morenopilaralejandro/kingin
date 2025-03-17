package com.pocket.kingin.composite;

public class PdEvokTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdEvokTypeNotFoundException(PdEvokTypeId id) {
		super("Could not find PdEvokTypeId composite key(pdId, typeId): " 
				+ id.getPdId() + ", "
				+ id.getTypeId());
	}
}
