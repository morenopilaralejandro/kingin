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
@Table(name = "abil_eff_type")
public class AbilEffType implements InternatName {
	@Column(name = "abil_eff_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long abilEffTypeId;
	@Column(name = "abil_eff_type_code", unique = true)
	private String abilEffTypeCode;
	@Column(name = "abil_eff_type_name_en")
	private String abilEffTypeNameEn;
	@Column(name = "abil_eff_type_name_ja")
	private String abilEffTypeNameJa;

	public AbilEffType() {}
	
	public AbilEffType(Long abilEffTypeId, String abilEffTypeCode, String abilEffTypeNameEn, String abilEffTypeNameJa) {
		super();
		this.abilEffTypeId = abilEffTypeId;
		this.abilEffTypeCode = abilEffTypeCode;
		this.abilEffTypeNameEn = abilEffTypeNameEn;
		this.abilEffTypeNameJa = abilEffTypeNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.abilEffTypeNameEn);
		map.put("ja", this.abilEffTypeNameJa);
		return map;
	}

	public Long getAbilEffTypeId() {
		return abilEffTypeId;
	}

	public void setAbilEffTypeId(Long abilEffTypeId) {
		this.abilEffTypeId = abilEffTypeId;
	}

	public String getAbilEffTypeCode() {
		return abilEffTypeCode;
	}

	public void setAbilEffTypeCode(String abilEffTypeCode) {
		this.abilEffTypeCode = abilEffTypeCode;
	}

	public String getAbilEffTypeNameEn() {
		return abilEffTypeNameEn;
	}

	public void setAbilEffTypeNameEn(String abilEffTypeNameEn) {
		this.abilEffTypeNameEn = abilEffTypeNameEn;
	}

	public String getAbilEffTypeNameJa() {
		return abilEffTypeNameJa;
	}

	public void setAbilEffTypeNameJa(String abilEffTypeNameJa) {
		this.abilEffTypeNameJa = abilEffTypeNameJa;
	}

	@Override
	public String toString() {
		return "AbilEffType [abilEffTypeId=" + abilEffTypeId + ", abilEffTypeCode=" + abilEffTypeCode + ", abilEffTypeNameEn=" + abilEffTypeNameEn + ", abilEffTypeNameJa="
				+ abilEffTypeNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilEffTypeCode, abilEffTypeId, abilEffTypeNameEn, abilEffTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbilEffType other = (AbilEffType) obj;
		return Objects.equals(abilEffTypeCode, other.abilEffTypeCode) && Objects.equals(abilEffTypeId, other.abilEffTypeId)
				&& Objects.equals(abilEffTypeNameEn, other.abilEffTypeNameEn) && Objects.equals(abilEffTypeNameJa, other.abilEffTypeNameJa);
	}

}
