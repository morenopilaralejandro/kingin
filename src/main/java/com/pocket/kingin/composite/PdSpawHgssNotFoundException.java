package com.pocket.kingin.composite;

public class PdSpawHgssNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdSpawHgssNotFoundException(PdSpawHgssId id) {
		super("Could not find PdSpawHgss composite key(pdId, zoneId, encId, isHg, isSs, lvMin): " 
				+ id.getPdId() + ", "
				+ id.getZoneId() + ", "
				+ id.getEncId() + ", "
				+ id.getIsHg() + ", "
				+ id.getIsSs() + ", "
				+ id.getLvMin());
	}
	
}
