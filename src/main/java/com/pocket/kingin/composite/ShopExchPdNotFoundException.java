package com.pocket.kingin.composite;

public class ShopExchPdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ShopExchPdNotFoundException(ShopExchPdId id) {
		super("Could not find ShopExchPd composite key(shopId): " 
				+ id.getShopId());
	}
}
