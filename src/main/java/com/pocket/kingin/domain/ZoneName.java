package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone_name")
public class ZoneName implements InternatName {
	@Column(name = "zone_name_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long zoneNameId;
	@Column(name = "zone_name_code", unique = true)
	private String zoneNameCode;
	@Column(name = "zone_name_name_en")
	private String zoneNameEn;
	@Column(name = "zone_name_name_ja")
	private String zoneNameJa;

	public ZoneName() {}
	
	public ZoneName(Long zoneNameId, String zoneNameCode, String zoneNameEn, String zoneNameJa) {
		super();
		this.zoneNameId = zoneNameId;
		this.zoneNameCode = zoneNameCode;
		this.zoneNameEn = zoneNameEn;
		this.zoneNameJa = zoneNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.zoneNameEn);
		map.put("ja", this.zoneNameJa);
		return map;
	}

	public Long getZoneNameId() {
		return zoneNameId;
	}

	public void setZoneNameId(Long zoneNameId) {
		this.zoneNameId = zoneNameId;
	}

	public String getZoneNameCode() {
		return zoneNameCode;
	}

	public void setZoneNameCode(String zoneNameCode) {
		this.zoneNameCode = zoneNameCode;
	}

	public String getZoneNameEn() {
		return zoneNameEn;
	}

	public void setZoneNameEn(String zoneNameEn) {
		this.zoneNameEn = zoneNameEn;
	}

	public String getZoneNameJa() {
		return zoneNameJa;
	}

	public void setZoneNameJa(String zoneNameJa) {
		this.zoneNameJa = zoneNameJa;
	}

	@Override
	public String toString() {
		return "ZoneName [zoneNameId=" + zoneNameId + ", zoneNameCode=" + zoneNameCode + ", zoneNameEn=" + zoneNameEn + ", zoneNameJa="
				+ zoneNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(zoneNameCode, zoneNameId, zoneNameEn, zoneNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoneName other = (ZoneName) obj;
		return Objects.equals(zoneNameCode, other.zoneNameCode) && Objects.equals(zoneNameId, other.zoneNameId)
				&& Objects.equals(zoneNameEn, other.zoneNameEn) && Objects.equals(zoneNameJa, other.zoneNameJa);
	}

}
