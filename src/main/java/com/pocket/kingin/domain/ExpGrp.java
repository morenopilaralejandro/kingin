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
@Table(name = "expGrp")
public class ExpGrp implements InternatName {
	@Column(name = "exp_grp_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long expGrpId;
	@Column(name = "exp_grp_code", unique = true)
	private String expGrpCode;
	@Column(name = "exp_grp_name_en")
	private String expGrpNameEn;
	@Column(name = "exp_grp_name_ja")
	private String expGrpNameJa;
	@Column(name = "exp_grp_final")
	private Long expGrpFinal;

	public ExpGrp() {
	}	
	
	public ExpGrp(Long expGrpId, String expGrpCode, String expGrpNameEn, String expGrpNameJa, Long expGrpFinal) {
		super();
		this.expGrpId = expGrpId;
		this.expGrpCode = expGrpCode;
		this.expGrpNameEn = expGrpNameEn;
		this.expGrpNameJa = expGrpNameJa;
		this.expGrpFinal = expGrpFinal;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.expGrpNameEn);
		map.put("ja", this.expGrpNameJa);
		return map;
	}

	public Long getExpGrpId() {
		return expGrpId;
	}

	public void setExpGrpId(Long expGrpId) {
		this.expGrpId = expGrpId;
	}

	public String getExpGrpCode() {
		return expGrpCode;
	}

	public void setExpGrpCode(String expGrpCode) {
		this.expGrpCode = expGrpCode;
	}

	public String getExpGrpNameEn() {
		return expGrpNameEn;
	}

	public void setExpGrpNameEn(String expGrpNameEn) {
		this.expGrpNameEn = expGrpNameEn;
	}

	public String getExpGrpNameJa() {
		return expGrpNameJa;
	}

	public void setExpGrpNameJa(String expGrpNameJa) {
		this.expGrpNameJa = expGrpNameJa;
	}

	public Long getExpGrpFinal() {
		return expGrpFinal;
	}

	public void setExpGrpFinal(Long expGrpFinal) {
		this.expGrpFinal = expGrpFinal;
	}

	@Override
	public String toString() {
		return "ExpGrp [expGrpId=" + expGrpId + ", expGrpCode=" + expGrpCode + ", expGrpNameEn=" + expGrpNameEn
				+ ", expGrpNameJa=" + expGrpNameJa + ", expGrpFinal=" + expGrpFinal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(expGrpCode, expGrpFinal, expGrpId, expGrpNameEn, expGrpNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpGrp other = (ExpGrp) obj;
		return Objects.equals(expGrpCode, other.expGrpCode) && Objects.equals(expGrpFinal, other.expGrpFinal)
				&& Objects.equals(expGrpId, other.expGrpId) && Objects.equals(expGrpNameEn, other.expGrpNameEn)
				&& Objects.equals(expGrpNameJa, other.expGrpNameJa);
	}

}
