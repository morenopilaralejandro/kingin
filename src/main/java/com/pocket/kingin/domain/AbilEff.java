package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatDesc;

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
@Table(name = "abil_eff")
public class AbilEff implements InternatDesc {
	@Column(name = "abil_eff_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long abilEffId;
	@Column(name = "abil_eff_code", unique = true)
	private String abilEffCode;
	@Column(name = "abil_eff_name_en")
	private String abilEffDescEn;
	@Column(name = "abil_eff_name_ja")
	private String abilEffDescJa;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "abil_eff_type_id", referencedColumnName = "abil_eff_type_id")
	private AbilEffType abilEffType;

    public AbilEff() {}

	public AbilEff(Long abilEffId, String abilEffCode, String abilEffDescEn, String abilEffDescJa,
			AbilEffType abilEffType) {
		super();
		this.abilEffId = abilEffId;
		this.abilEffCode = abilEffCode;
		this.abilEffDescEn = abilEffDescEn;
		this.abilEffDescJa = abilEffDescJa;
		this.abilEffType = abilEffType;
	}

	@Override
	public Map<String, String> getInternatDesc() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.abilEffDescEn);
		map.put("ja", this.abilEffDescJa);
		return map;
	}

	public Long getAbilEffId() {
		return abilEffId;
	}

	public void setAbilEffId(Long abilEffId) {
		this.abilEffId = abilEffId;
	}

	public String getAbilEffCode() {
		return abilEffCode;
	}

	public void setAbilEffCode(String abilEffCode) {
		this.abilEffCode = abilEffCode;
	}

	public String getAbilEffDescEn() {
		return abilEffDescEn;
	}

	public void setAbilEffDescEn(String abilEffDescEn) {
		this.abilEffDescEn = abilEffDescEn;
	}

	public String getAbilEffDescJa() {
		return abilEffDescJa;
	}

	public void setAbilEffDescJa(String abilEffDescJa) {
		this.abilEffDescJa = abilEffDescJa;
	}

	public AbilEffType getAbilEffType() {
		return abilEffType;
	}

	public void setAbilEffType(AbilEffType abilEffType) {
		this.abilEffType = abilEffType;
	}

	@Override
	public String toString() {
		return "AbilEff [abilEffId=" + abilEffId + ", abilEffCode=" + abilEffCode + ", abilEffDescEn=" + abilEffDescEn
				+ ", abilEffDescJa=" + abilEffDescJa + ", abilEffType=" + abilEffType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilEffCode, abilEffDescEn, abilEffDescJa, abilEffId, abilEffType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbilEff other = (AbilEff) obj;
		return Objects.equals(abilEffCode, other.abilEffCode) && Objects.equals(abilEffDescEn, other.abilEffDescEn)
				&& Objects.equals(abilEffDescJa, other.abilEffDescJa) && Objects.equals(abilEffId, other.abilEffId)
				&& Objects.equals(abilEffType, other.abilEffType);
	}
	
}
