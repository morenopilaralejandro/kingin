package com.pocket.kingin.composite;

public class GearFougPdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GearFougPdNotFoundException(GearFougPdId id) {
		super("Could not find GearFougPd composite key(gearCallId, pdId, ordr): " 
				+ id.getGearCallId() + ", "
				+ id.getPdId() + ", "
				+ id.getOrdr());
	}
}
