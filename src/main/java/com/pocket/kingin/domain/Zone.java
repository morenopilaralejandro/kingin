package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone")
public class Zone implements InternatName {
	@Column(name = "zone_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long zoneId;
	@Column(name = "zone_code", unique = true)
	private String zoneCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_name_id", referencedColumnName = "zone_name_id")
	private ZoneName zoneName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_main_id", referencedColumnName = "zone_id")
	private Zone zoneMain;

	public Zone() {}
	
	public Zone(Long zoneId, String zoneCode, ZoneName zoneName, Zone zoneMain) {
		super();
		this.zoneId = zoneId;
		this.zoneCode = zoneCode;
		this.zoneName = zoneName;
		this.zoneMain = zoneMain;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.zoneName.getZoneNameEn());
		map.put("ja", this.zoneName.getZoneNameJa());
		return map;
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public ZoneName getZoneName() {
		return zoneName;
	}

	public void setZoneName(ZoneName zoneName) {
		this.zoneName = zoneName;
	}

	public Zone getZoneMain() {
		return zoneMain;
	}

	public void setZoneMain(Zone zoneMain) {
		this.zoneMain = zoneMain;
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", zoneCode=" + zoneCode + ", zoneName=" + zoneName + ", zoneMain=" + zoneMain
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(zoneCode, zoneId, zoneMain, zoneName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zone other = (Zone) obj;
		return Objects.equals(zoneCode, other.zoneCode) && Objects.equals(zoneId, other.zoneId)
				&& Objects.equals(zoneMain, other.zoneMain) && Objects.equals(zoneName, other.zoneName);
	}
	
}
