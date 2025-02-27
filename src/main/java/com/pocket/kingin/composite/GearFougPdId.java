package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GearFougPdId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "gear_call_id")
	private Long gearCallId;
	
	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "ordr")
	private Long ordr;

	public GearFougPdId() {}

	public GearFougPdId(Long gearCallId, Long pdId, Long ordr) {
		super();
		this.gearCallId = gearCallId;
		this.pdId = pdId;
		this.ordr = ordr;
	}

	public Long getGearCallId() {
		return gearCallId;
	}

	public void setGearCallId(Long gearCallId) {
		this.gearCallId = gearCallId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getOrdr() {
		return ordr;
	}

	public void setOrdr(Long ordr) {
		this.ordr = ordr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GearFougPdId [gearCallId=" + gearCallId + ", pdId=" + pdId + ", ordr=" + ordr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gearCallId, ordr, pdId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GearFougPdId other = (GearFougPdId) obj;
		return Objects.equals(gearCallId, other.gearCallId) && Objects.equals(ordr, other.ordr)
				&& Objects.equals(pdId, other.pdId);
	}
	
}
