package com.pocket.kingin.composite;

public class PdSpawSafNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PdSpawSafNotFoundException(PdSpawSafId id) {
		super("Could not find PdSpawSaf composite key(pdId, zoneId, enc_id, lvMin): " 
				+ id.getPdId() + ", "
				+ id.getZoneId() + ", "
				+ id.getEncId() + ", "
				+ id.getLvMin());
	}
}
