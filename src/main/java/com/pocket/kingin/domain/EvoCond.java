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
@Table(name = "evo_cond")
public class EvoCond implements InternatName {
	@Column(name = "evo_cond_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long evoCondId;
	@Column(name = "evo_cond_code", unique = true)
	private String evoCondCode;
	@Column(name = "evo_cond_desc_en")
	private String evoCondDescEn;
	@Column(name = "evo_cond_desc_ja")
	private String evoCondDescJa;

	public EvoCond() {}
	
	public EvoCond(Long evoCondId, String evoCondCode, String evoCondNameEn, String evoCondNameJa) {
		super();
		this.evoCondId = evoCondId;
		this.evoCondCode = evoCondCode;
		this.evoCondDescEn = evoCondNameEn;
		this.evoCondDescJa = evoCondNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.evoCondDescEn);
		map.put("ja", this.evoCondDescJa);
		return map;
	}

	public Long getEvoCondId() {
		return evoCondId;
	}

	public void setEvoCondId(Long evoCondId) {
		this.evoCondId = evoCondId;
	}

	public String getEvoCondCode() {
		return evoCondCode;
	}

	public void setEvoCondCode(String evoCondCode) {
		this.evoCondCode = evoCondCode;
	}

	public String getEvoCondDescEn() {
		return evoCondDescEn;
	}

	public void setEvoCondDescEn(String evoCondDescEn) {
		this.evoCondDescEn = evoCondDescEn;
	}

	public String getEvoCondDescJa() {
		return evoCondDescJa;
	}

	public void setEvoCondDescJa(String evoCondDescJa) {
		this.evoCondDescJa = evoCondDescJa;
	}

	@Override
	public String toString() {
		return "EvoCond [evoCondId=" + evoCondId + ", evoCondCode=" + evoCondCode + ", evoCondDescEn=" + evoCondDescEn
				+ ", evoCondDescJa=" + evoCondDescJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(evoCondCode, evoCondDescEn, evoCondDescJa, evoCondId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvoCond other = (EvoCond) obj;
		return Objects.equals(evoCondCode, other.evoCondCode) && Objects.equals(evoCondDescEn, other.evoCondDescEn)
				&& Objects.equals(evoCondDescJa, other.evoCondDescJa) && Objects.equals(evoCondId, other.evoCondId);
	}

}
