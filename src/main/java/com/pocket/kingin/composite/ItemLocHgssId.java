package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ItemLocHgssId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "zone_id")
	private Long zoneId;
	
	@Column(name = "item_obt_id")
	private Long itemObtId;

	public ItemLocHgssId() {}
	
	public ItemLocHgssId(Long itemId, Long zoneId, Long itemObtId) {
		super();
		this.itemId = itemId;
		this.zoneId = zoneId;
		this.itemObtId = itemObtId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public Long getItemObtId() {
		return itemObtId;
	}

	public void setItemObtId(Long itemObtId) {
		this.itemObtId = itemObtId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ItemLocHgssId [itemId=" + itemId + ", zoneId=" + zoneId + ", itemObtId=" + itemObtId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemObtId, zoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLocHgssId other = (ItemLocHgssId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemObtId, other.itemObtId)
				&& Objects.equals(zoneId, other.zoneId);
	}
	
}
