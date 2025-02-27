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
@Table(name = "gear_day")
public class GearDay implements InternatName {
	@Column(name = "gear_day_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long gearDayId;
	@Column(name = "gear_day_code", unique = true)
	private String gearDayCode;
	@Column(name = "gear_day_name_en")
	private String gearDayNameEn;
	@Column(name = "gear_day_name_ja")
	private String gearDayNameJa;

	public GearDay() {}
	
	public GearDay(Long gearDayId, String gearDayCode, String gearDayNameEn, String gearDayNameJa) {
		super();
		this.gearDayId = gearDayId;
		this.gearDayCode = gearDayCode;
		this.gearDayNameEn = gearDayNameEn;
		this.gearDayNameJa = gearDayNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.gearDayNameEn);
		map.put("ja", this.gearDayNameJa);
		return map;
	}

	public Long getGearDayId() {
		return gearDayId;
	}

	public void setGearDayId(Long gearDayId) {
		this.gearDayId = gearDayId;
	}

	public String getGearDayCode() {
		return gearDayCode;
	}

	public void setGearDayCode(String gearDayCode) {
		this.gearDayCode = gearDayCode;
	}

	public String getGearDayNameEn() {
		return gearDayNameEn;
	}

	public void setGearDayNameEn(String gearDayNameEn) {
		this.gearDayNameEn = gearDayNameEn;
	}

	public String getGearDayNameJa() {
		return gearDayNameJa;
	}

	public void setGearDayNameJa(String gearDayNameJa) {
		this.gearDayNameJa = gearDayNameJa;
	}

	@Override
	public String toString() {
		return "GearDay [gearDayId=" + gearDayId + ", gearDayCode=" + gearDayCode + ", gearDayNameEn=" + gearDayNameEn + ", gearDayNameJa="
				+ gearDayNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gearDayCode, gearDayId, gearDayNameEn, gearDayNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GearDay other = (GearDay) obj;
		return Objects.equals(gearDayCode, other.gearDayCode) && Objects.equals(gearDayId, other.gearDayId)
				&& Objects.equals(gearDayNameEn, other.gearDayNameEn) && Objects.equals(gearDayNameJa, other.gearDayNameJa);
	}

}
