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
@Table(name = "eggGrp")
public class EggGrp implements InternatName {
	@Column(name = "egg_grp_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long eggGrpId;
	@Column(name = "egg_grp_code", unique = true)
	private String eggGrpCode;
	@Column(name = "egg_grp_name_en")
	private String eggGrpNameEn;
	@Column(name = "egg_grp_name_ja")
	private String eggGrpNameJa;

	public EggGrp() {
	}
	
	public EggGrp(Long eggGrpId, String eggGrpCode, String eggGrpNameEn, String eggGrpNameJa) {
		super();
		this.eggGrpId = eggGrpId;
		this.eggGrpCode = eggGrpCode;
		this.eggGrpNameEn = eggGrpNameEn;
		this.eggGrpNameJa = eggGrpNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.eggGrpNameEn);
		map.put("ja", this.eggGrpNameJa);
		return map;
	}

	public Long getEggGrpId() {
		return eggGrpId;
	}

	public void setEggGrpId(Long eggGrpId) {
		this.eggGrpId = eggGrpId;
	}

	public String getEggGrpCode() {
		return eggGrpCode;
	}

	public void setEggGrpCode(String eggGrpCode) {
		this.eggGrpCode = eggGrpCode;
	}

	public String getEggGrpNameEn() {
		return eggGrpNameEn;
	}

	public void setEggGrpNameEn(String eggGrpNameEn) {
		this.eggGrpNameEn = eggGrpNameEn;
	}

	public String getEggGrpNameJa() {
		return eggGrpNameJa;
	}

	public void setEggGrpNameJa(String eggGrpNameJa) {
		this.eggGrpNameJa = eggGrpNameJa;
	}

	@Override
	public String toString() {
		return "EggGrp [eggGrpId=" + eggGrpId + ", eggGrpCode=" + eggGrpCode + ", eggGrpNameEn=" + eggGrpNameEn + ", eggGrpNameJa="
				+ eggGrpNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(eggGrpCode, eggGrpId, eggGrpNameEn, eggGrpNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EggGrp other = (EggGrp) obj;
		return Objects.equals(eggGrpCode, other.eggGrpCode) && Objects.equals(eggGrpId, other.eggGrpId)
				&& Objects.equals(eggGrpNameEn, other.eggGrpNameEn) && Objects.equals(eggGrpNameJa, other.eggGrpNameJa);
	}

}
