package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ShopExchPdId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "shop_id")
	private Long shopId;

	public ShopExchPdId() {}

	public ShopExchPdId(Long shopId) {
		super();
		this.shopId = shopId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ShopExchPdId [shopId=" + shopId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(shopId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopExchPdId other = (ShopExchPdId) obj;
		return Objects.equals(shopId, other.shopId);
	}

}
