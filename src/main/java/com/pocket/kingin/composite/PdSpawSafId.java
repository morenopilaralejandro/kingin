package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdSpawSafId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "zone_id")
	private Long zoneId;
	
	@Column(name = "enc_id")
	private Long encId;
	
	@Column(name = "lv_min")
	private Long lvMin;

	public PdSpawSafId() {}

	public PdSpawSafId(Long pdId, Long zoneId, Long encId, Long lvMin) {
		super();
		this.pdId = pdId;
		this.zoneId = zoneId;
		this.encId = encId;
		this.lvMin = lvMin;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public Long getEncId() {
		return encId;
	}

	public void setEncId(Long encId) {
		this.encId = encId;
	}

	public Long getLvMin() {
		return lvMin;
	}

	public void setLvMin(Long lvMin) {
		this.lvMin = lvMin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdSpawSafId [pdId=" + pdId + ", zoneId=" + zoneId + ", encId=" + encId + ", lvMin=" + lvMin + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(encId, lvMin, pdId, zoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdSpawSafId other = (PdSpawSafId) obj;
		return Objects.equals(encId, other.encId) && Objects.equals(lvMin, other.lvMin)
				&& Objects.equals(pdId, other.pdId) && Objects.equals(zoneId, other.zoneId);
	}
	
}
