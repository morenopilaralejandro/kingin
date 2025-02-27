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
@Table(name = "gear_time")
public class GearTime implements InternatName {
	@Column(name = "gear_time_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long gearTimeId;
	@Column(name = "gear_time_code", unique = true)
	private String gearTimeCode;
	@Column(name = "gear_time_name_en")
	private String gearTimeNameEn;
	@Column(name = "gear_time_name_ja")
	private String gearTimeNameJa;

	public GearTime() {}
	
	public GearTime(Long gearTimeId, String gearTimeCode, String gearTimeNameEn, String gearTimeNameJa) {
		super();
		this.gearTimeId = gearTimeId;
		this.gearTimeCode = gearTimeCode;
		this.gearTimeNameEn = gearTimeNameEn;
		this.gearTimeNameJa = gearTimeNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.gearTimeNameEn);
		map.put("ja", this.gearTimeNameJa);
		return map;
	}

	public Long getGearTimeId() {
		return gearTimeId;
	}

	public void setGearTimeId(Long gearTimeId) {
		this.gearTimeId = gearTimeId;
	}

	public String getGearTimeCode() {
		return gearTimeCode;
	}

	public void setGearTimeCode(String gearTimeCode) {
		this.gearTimeCode = gearTimeCode;
	}

	public String getGearTimeNameEn() {
		return gearTimeNameEn;
	}

	public void setGearTimeNameEn(String gearTimeNameEn) {
		this.gearTimeNameEn = gearTimeNameEn;
	}

	public String getGearTimeNameJa() {
		return gearTimeNameJa;
	}

	public void setGearTimeNameJa(String gearTimeNameJa) {
		this.gearTimeNameJa = gearTimeNameJa;
	}

	@Override
	public String toString() {
		return "GearTime [gearTimeId=" + gearTimeId + ", gearTimeCode=" + gearTimeCode + ", gearTimeNameEn=" + gearTimeNameEn + ", gearTimeNameJa="
				+ gearTimeNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gearTimeCode, gearTimeId, gearTimeNameEn, gearTimeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GearTime other = (GearTime) obj;
		return Objects.equals(gearTimeCode, other.gearTimeCode) && Objects.equals(gearTimeId, other.gearTimeId)
				&& Objects.equals(gearTimeNameEn, other.gearTimeNameEn) && Objects.equals(gearTimeNameJa, other.gearTimeNameJa);
	}

}
