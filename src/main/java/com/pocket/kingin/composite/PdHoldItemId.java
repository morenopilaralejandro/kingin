package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdHoldItemId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "item_id")
	private Long itemId;

	public PdHoldItemId() {}

	public PdHoldItemId(Long pdId, Long itemId) {
		super();
		this.pdId = pdId;
		this.itemId = itemId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdHoldItemId [pdId=" + pdId + ", itemId=" + itemId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, pdId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdHoldItemId other = (PdHoldItemId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(pdId, other.pdId);
	}
	
}
