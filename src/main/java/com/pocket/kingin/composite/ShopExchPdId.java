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
	
	@Column(name = "pd_id")
	private Long pdId;

	public ShopExchPdId() {}

	public ShopExchPdId(Long shopId, Long pdId) {
		super();
		this.shopId = shopId;
		this.pdId = pdId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ShopExchPdId [shopId=" + shopId + ", pdId=" + pdId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pdId, shopId);
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
		return Objects.equals(pdId, other.pdId) && Objects.equals(shopId, other.shopId);
	}

}
