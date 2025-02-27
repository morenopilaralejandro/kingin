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
@Table(name = "pw_grp")
public class PwGrp implements InternatName {
	@Column(name = "pw_grp_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long pwGrpId;
	@Column(name = "pw_grp_code", unique = true)
	private String pwGrpCode;
	@Column(name = "pw_grp_name_en")
	private String pwGrpNameEn;
	@Column(name = "pw_grp_name_ja")
	private String pwGrpNameJa;

	public PwGrp() {}
	
	public PwGrp(Long pwGrpId, String pwGrpCode, String pwGrpNameEn, String pwGrpNameJa) {
		super();
		this.pwGrpId = pwGrpId;
		this.pwGrpCode = pwGrpCode;
		this.pwGrpNameEn = pwGrpNameEn;
		this.pwGrpNameJa = pwGrpNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.pwGrpNameEn);
		map.put("ja", this.pwGrpNameJa);
		return map;
	}

	public Long getPwGrpId() {
		return pwGrpId;
	}

	public void setPwGrpId(Long pwGrpId) {
		this.pwGrpId = pwGrpId;
	}

	public String getPwGrpCode() {
		return pwGrpCode;
	}

	public void setPwGrpCode(String pwGrpCode) {
		this.pwGrpCode = pwGrpCode;
	}

	public String getPwGrpNameEn() {
		return pwGrpNameEn;
	}

	public void setPwGrpNameEn(String pwGrpNameEn) {
		this.pwGrpNameEn = pwGrpNameEn;
	}

	public String getPwGrpNameJa() {
		return pwGrpNameJa;
	}

	public void setPwGrpNameJa(String pwGrpNameJa) {
		this.pwGrpNameJa = pwGrpNameJa;
	}

	@Override
	public String toString() {
		return "PwGrp [pwGrpId=" + pwGrpId + ", pwGrpCode=" + pwGrpCode + ", pwGrpNameEn=" + pwGrpNameEn + ", pwGrpNameJa="
				+ pwGrpNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pwGrpCode, pwGrpId, pwGrpNameEn, pwGrpNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwGrp other = (PwGrp) obj;
		return Objects.equals(pwGrpCode, other.pwGrpCode) && Objects.equals(pwGrpId, other.pwGrpId)
				&& Objects.equals(pwGrpNameEn, other.pwGrpNameEn) && Objects.equals(pwGrpNameJa, other.pwGrpNameJa);
	}

}
