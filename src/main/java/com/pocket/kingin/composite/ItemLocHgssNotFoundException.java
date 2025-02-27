package com.pocket.kingin.composite;

public class ItemLocHgssNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemLocHgssNotFoundException(ItemLocHgssId id) {
		super("Could not find ItemLocHgss composite key(itemId, zoneId, itemObtId): " 
				+ id.getItemId() + ", "
				+ id.getZoneId() + ", "
				+ id.getItemObtId());
	}
}
