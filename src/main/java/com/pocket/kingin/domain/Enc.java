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
@Table(name = "enc")
public class Enc implements InternatName {
	@Column(name = "enc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long encId;
	@Column(name = "enc_code", unique = true)
	private String encCode;
	@Column(name = "enc_name_en")
	private String encNameEn;
	@Column(name = "enc_name_ja")
	private String encNameJa;

	public Enc() {}
	
	public Enc(Long encId, String encCode, String encNameEn, String encNameJa) {
		super();
		this.encId = encId;
		this.encCode = encCode;
		this.encNameEn = encNameEn;
		this.encNameJa = encNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.encNameEn);
		map.put("ja", this.encNameJa);
		return map;
	}

	public Long getEncId() {
		return encId;
	}

	public void setEncId(Long encId) {
		this.encId = encId;
	}

	public String getEncCode() {
		return encCode;
	}

	public void setEncCode(String encCode) {
		this.encCode = encCode;
	}

	public String getEncNameEn() {
		return encNameEn;
	}

	public void setEncNameEn(String encNameEn) {
		this.encNameEn = encNameEn;
	}

	public String getEncNameJa() {
		return encNameJa;
	}

	public void setEncNameJa(String encNameJa) {
		this.encNameJa = encNameJa;
	}

	@Override
	public String toString() {
		return "Enc [encId=" + encId + ", encCode=" + encCode + ", encNameEn=" + encNameEn + ", encNameJa="
				+ encNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(encCode, encId, encNameEn, encNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enc other = (Enc) obj;
		return Objects.equals(encCode, other.encCode) && Objects.equals(encId, other.encId)
				&& Objects.equals(encNameEn, other.encNameEn) && Objects.equals(encNameJa, other.encNameJa);
	}

}
