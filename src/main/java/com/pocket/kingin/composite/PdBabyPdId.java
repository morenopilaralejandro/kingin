package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdBabyPdId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id_pare")
	private Long pdIdPare;
	
	@Column(name = "pd_id_baby")
	private Long pdIdBaby;
	
	@Column(name = "item_id")
	private Long itemId;

	public PdBabyPdId() {}

	public PdBabyPdId(Long pdIdPare, Long pdIdBaby, Long itemId) {
		super();
		this.pdIdPare = pdIdPare;
		this.pdIdBaby = pdIdBaby;
		this.itemId = itemId;
	}

	public Long getPdIdPare() {
		return pdIdPare;
	}

	public void setPdIdPare(Long pdIdPare) {
		this.pdIdPare = pdIdPare;
	}

	public Long getPdIdBaby() {
		return pdIdBaby;
	}

	public void setPdIdBaby(Long pdIdBaby) {
		this.pdIdBaby = pdIdBaby;
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
		return "PdBabyPdId [pdIdPare=" + pdIdPare + ", pdIdBaby=" + pdIdBaby + ", itemId=" + itemId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, pdIdBaby, pdIdPare);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdBabyPdId other = (PdBabyPdId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(pdIdBaby, other.pdIdBaby)
				&& Objects.equals(pdIdPare, other.pdIdPare);
	}
	
}
