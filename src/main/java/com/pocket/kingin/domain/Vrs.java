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
@Table(name = "vrs")
public class Vrs implements InternatName {
	@Column(name = "vrs_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long vrsId;
	@Column(name = "vrs_code", unique = true)
	private String vrsCode;
	@Column(name = "vrs_name_en")
	private String vrsNameEn;
	@Column(name = "vrs_name_ja")
	private String vrsNameJa;
	@Column(name = "vrs_sym")
	private String vrsSym;	

	public Vrs() {}
	
	public Vrs(Long vrsId, String vrsCode, String vrsNameEn, String vrsNameJa, String vrsSym) {
		super();
		this.vrsId = vrsId;
		this.vrsCode = vrsCode;
		this.vrsNameEn = vrsNameEn;
		this.vrsNameJa = vrsNameJa;
		this.vrsSym = vrsSym;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.vrsNameEn);
		map.put("ja", this.vrsNameJa);
		return map;
	}

	public Long getVrsId() {
		return vrsId;
	}

	public void setVrsId(Long vrsId) {
		this.vrsId = vrsId;
	}

	public String getVrsCode() {
		return vrsCode;
	}

	public void setVrsCode(String vrsCode) {
		this.vrsCode = vrsCode;
	}

	public String getVrsNameEn() {
		return vrsNameEn;
	}

	public void setVrsNameEn(String vrsNameEn) {
		this.vrsNameEn = vrsNameEn;
	}

	public String getVrsNameJa() {
		return vrsNameJa;
	}

	public void setVrsNameJa(String vrsNameJa) {
		this.vrsNameJa = vrsNameJa;
	}

	public String getVrsSym() {
		return vrsSym;
	}

	public void setVrsSym(String vrsSym) {
		this.vrsSym = vrsSym;
	}

	@Override
	public String toString() {
		return "Vrs [vrsId=" + vrsId + ", vrsCode=" + vrsCode + ", vrsNameEn=" + vrsNameEn + ", vrsNameJa=" + vrsNameJa
				+ ", vrsSym=" + vrsSym + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(vrsCode, vrsId, vrsNameEn, vrsNameJa, vrsSym);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vrs other = (Vrs) obj;
		return Objects.equals(vrsCode, other.vrsCode) && Objects.equals(vrsId, other.vrsId)
				&& Objects.equals(vrsNameEn, other.vrsNameEn) && Objects.equals(vrsNameJa, other.vrsNameJa)
				&& Objects.equals(vrsSym, other.vrsSym);
	}

}
