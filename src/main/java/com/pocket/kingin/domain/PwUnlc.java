package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatDesc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pw_unlc")
public class PwUnlc implements InternatDesc {
	@Column(name = "pw_unlc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long pwUnlcId;
	@Column(name = "pw_unlc_code", unique = true)
	private String pwUnlcCode;
	@Column(name = "pw_unlc_desc_en")
	private String pwUnlcDescEn;
	@Column(name = "pw_unlc_desc_ja")
	private String pwUnlcDescJa;

	public PwUnlc() {}
	
	public PwUnlc(Long pwUnlcId, String pwUnlcCode, String pwUnlcDescEn, String pwUnlcDescJa) {
		super();
		this.pwUnlcId = pwUnlcId;
		this.pwUnlcCode = pwUnlcCode;
		this.pwUnlcDescEn = pwUnlcDescEn;
		this.pwUnlcDescJa = pwUnlcDescJa;
	}

	@Override
	public Map<String, String> getInternatDesc() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.pwUnlcDescEn);
		map.put("ja", this.pwUnlcDescJa);
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

	public String getPwUnlcDescEn() {
		return pwUnlcDescEn;
	}

	public void setPwUnlcDescEn(String pwUnlcDescEn) {
		this.pwUnlcDescEn = pwUnlcDescEn;
	}

	public String getPwUnlcDescJa() {
		return pwUnlcDescJa;
	}

	public void setPwUnlcDescJa(String pwUnlcDescJa) {
		this.pwUnlcDescJa = pwUnlcDescJa;
	}

	@Override
	public String toString() {
		return "PwUnlc [pwUnlcId=" + pwUnlcId + ", pwUnlcCode=" + pwUnlcCode + ", pwUnlcDescEn=" + pwUnlcDescEn
				+ ", pwUnlcDescJa=" + pwUnlcDescJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pwUnlcCode, pwUnlcDescEn, pwUnlcDescJa, pwUnlcId);
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
		return Objects.equals(pwUnlcCode, other.pwUnlcCode) && Objects.equals(pwUnlcDescEn, other.pwUnlcDescEn)
				&& Objects.equals(pwUnlcDescJa, other.pwUnlcDescJa) && Objects.equals(pwUnlcId, other.pwUnlcId);
	}

}
