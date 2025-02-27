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
@Table(name = "arti_type")
public class ArtiType implements InternatName {
	@Column(name = "arti_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long artiTypeId;
	@Column(name = "arti_type_code", unique = true)
	private String artiTypeCode;
	@Column(name = "arti_type_name_en")
	private String artiTypeNameEn;
	@Column(name = "arti_type_name_ja")
	private String artiTypeNameJa;

	public ArtiType() {}
	
	public ArtiType(Long artiTypeId, String artiTypeCode, String artiTypeNameEn, String artiTypeNameJa) {
		super();
		this.artiTypeId = artiTypeId;
		this.artiTypeCode = artiTypeCode;
		this.artiTypeNameEn = artiTypeNameEn;
		this.artiTypeNameJa = artiTypeNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.artiTypeNameEn);
		map.put("ja", this.artiTypeNameJa);
		return map;
	}

	public Long getArtiTypeId() {
		return artiTypeId;
	}

	public void setArtiTypeId(Long artiTypeId) {
		this.artiTypeId = artiTypeId;
	}

	public String getArtiTypeCode() {
		return artiTypeCode;
	}

	public void setArtiTypeCode(String artiTypeCode) {
		this.artiTypeCode = artiTypeCode;
	}

	public String getArtiTypeNameEn() {
		return artiTypeNameEn;
	}

	public void setArtiTypeNameEn(String artiTypeNameEn) {
		this.artiTypeNameEn = artiTypeNameEn;
	}

	public String getArtiTypeNameJa() {
		return artiTypeNameJa;
	}

	public void setArtiTypeNameJa(String artiTypeNameJa) {
		this.artiTypeNameJa = artiTypeNameJa;
	}

	@Override
	public String toString() {
		return "ArtiType [artiTypeId=" + artiTypeId + ", artiTypeCode=" + artiTypeCode + ", artiTypeNameEn=" + artiTypeNameEn + ", artiTypeNameJa="
				+ artiTypeNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(artiTypeCode, artiTypeId, artiTypeNameEn, artiTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtiType other = (ArtiType) obj;
		return Objects.equals(artiTypeCode, other.artiTypeCode) && Objects.equals(artiTypeId, other.artiTypeId)
				&& Objects.equals(artiTypeNameEn, other.artiTypeNameEn) && Objects.equals(artiTypeNameJa, other.artiTypeNameJa);
	}

}
