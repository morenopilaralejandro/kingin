package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdSpawHgssId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "zone_id")
	private Long zoneId;
	
	@Column(name = "enc_id")
	private Long encId;
	
	@Column(name = "is_hg")
	private Boolean isHg;
	
	@Column(name = "is_ss")
	private Boolean isSs;
	
	@Column(name = "lv_min")
	private Long lvMin;
	
	public PdSpawHgssId() {}

	public PdSpawHgssId(Long pdId, Long zoneId, Long encId, Boolean isHg, Boolean isSs, Long lvMin) {
		super();
		this.pdId = pdId;
		this.zoneId = zoneId;
		this.encId = encId;
		this.isHg = isHg;
		this.isSs = isSs;
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

	public Boolean getIsHg() {
		return isHg;
	}

	public void setIsHg(Boolean isHg) {
		this.isHg = isHg;
	}

	public Boolean getIsSs() {
		return isSs;
	}

	public void setIsSs(Boolean isSs) {
		this.isSs = isSs;
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
		return "PdSpawHgssId [pdId=" + pdId + ", zoneId=" + zoneId + ", encId=" + encId + ", isHg=" + isHg + ", isSs="
				+ isSs + ", lvMin=" + lvMin + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(encId, isHg, isSs, lvMin, pdId, zoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdSpawHgssId other = (PdSpawHgssId) obj;
		return Objects.equals(encId, other.encId) && Objects.equals(isHg, other.isHg)
				&& Objects.equals(isSs, other.isSs) && Objects.equals(lvMin, other.lvMin)
				&& Objects.equals(pdId, other.pdId) && Objects.equals(zoneId, other.zoneId);
	}
	
}
