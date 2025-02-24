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
@Table(name = "type")
public class Type implements InternatName {
	@Column(name = "type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long typeId;
	@Column(name = "type_code", unique = true)
	private String typeCode;
	@Column(name = "type_name_en")
	private String typeNameEn;
	@Column(name = "type_name_ja")
	private String typeNameJa;

	public Type() {}
	
	public Type(Long typeId, String typeCode, String typeNameEn, String typeNameJa) {
		super();
		this.typeId = typeId;
		this.typeCode = typeCode;
		this.typeNameEn = typeNameEn;
		this.typeNameJa = typeNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.typeNameEn);
		map.put("ja", this.typeNameJa);
		return map;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeNameEn() {
		return typeNameEn;
	}

	public void setTypeNameEn(String typeNameEn) {
		this.typeNameEn = typeNameEn;
	}

	public String getTypeNameJa() {
		return typeNameJa;
	}

	public void setTypeNameJa(String typeNameJa) {
		this.typeNameJa = typeNameJa;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeCode=" + typeCode + ", typeNameEn=" + typeNameEn + ", typeNameJa="
				+ typeNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(typeCode, typeId, typeNameEn, typeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		return Objects.equals(typeCode, other.typeCode) && Objects.equals(typeId, other.typeId)
				&& Objects.equals(typeNameEn, other.typeNameEn) && Objects.equals(typeNameJa, other.typeNameJa);
	}

}
