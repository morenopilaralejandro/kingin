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
@Table(name = "pw_unlc")
public class PwUnlc implements InternatName {
	@Column(name = "pw_unlc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long pwUnlcId;
	@Column(name = "pw_unlc_code", unique = true)
	private String pwUnlcCode;
	@Column(name = "pw_unlc_name_en")
	private String pwUnlcNameEn;
	@Column(name = "pw_unlc_name_ja")
	private String pwUnlcNameJa;

	public PwUnlc() {}
	
	public PwUnlc(Long pwUnlcId, String pwUnlcCode, String pwUnlcNameEn, String pwUnlcNameJa) {
		super();
		this.pwUnlcId = pwUnlcId;
		this.pwUnlcCode = pwUnlcCode;
		this.pwUnlcNameEn = pwUnlcNameEn;
		this.pwUnlcNameJa = pwUnlcNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.pwUnlcNameEn);
		map.put("ja", this.pwUnlcNameJa);
		return map;
	}

	public Long getPwUnlcId() {
		return pwUnlcId;
	}

	public void setPwUnlcId(Long pwUnlcId) {
		this.pwUnlcId = pwUnlcId;
	}

	public String getPwUnlcCode() {
		return pwUnlcCode;
	}

	public void setPwUnlcCode(String pwUnlcCode) {
		this.pwUnlcCode = pwUnlcCode;
	}

	public String getPwUnlcNameEn() {
		return pwUnlcNameEn;
	}

	public void setPwUnlcNameEn(String pwUnlcNameEn) {
		this.pwUnlcNameEn = pwUnlcNameEn;
	}

	public String getPwUnlcNameJa() {
		return pwUnlcNameJa;
	}

	public void setPwUnlcNameJa(String pwUnlcNameJa) {
		this.pwUnlcNameJa = pwUnlcNameJa;
	}

	@Override
	public String toString() {
		return "PwUnlc [pwUnlcId=" + pwUnlcId + ", pwUnlcCode=" + pwUnlcCode + ", pwUnlcNameEn=" + pwUnlcNameEn + ", pwUnlcNameJa="
				+ pwUnlcNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pwUnlcCode, pwUnlcId, pwUnlcNameEn, pwUnlcNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwUnlc other = (PwUnlc) obj;
		return Objects.equals(pwUnlcCode, other.pwUnlcCode) && Objects.equals(pwUnlcId, other.pwUnlcId)
				&& Objects.equals(pwUnlcNameEn, other.pwUnlcNameEn) && Objects.equals(pwUnlcNameJa, other.pwUnlcNameJa);
	}

}
