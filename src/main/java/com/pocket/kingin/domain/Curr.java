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
@Table(name = "curr")
public class Curr implements InternatName {
	@Column(name = "curr_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long currId;
	@Column(name = "curr_code", unique = true)
	private String currCode;
	@Column(name = "curr_name_en")
	private String currNameEn;
	@Column(name = "curr_name_ja")
	private String currNameJa;

	public Curr() {}
	
	public Curr(Long currId, String currCode, String currNameEn, String currNameJa) {
		super();
		this.currId = currId;
		this.currCode = currCode;
		this.currNameEn = currNameEn;
		this.currNameJa = currNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.currNameEn);
		map.put("ja", this.currNameJa);
		return map;
	}

	public Long getCurrId() {
		return currId;
	}

	public void setCurrId(Long currId) {
		this.currId = currId;
	}

	public String getCurrCode() {
		return currCode;
	}

	public void setCurrCode(String currCode) {
		this.currCode = currCode;
	}

	public String getCurrNameEn() {
		return currNameEn;
	}

	public void setCurrNameEn(String currNameEn) {
		this.currNameEn = currNameEn;
	}

	public String getCurrNameJa() {
		return currNameJa;
	}

	public void setCurrNameJa(String currNameJa) {
		this.currNameJa = currNameJa;
	}

	@Override
	public String toString() {
		return "Curr [currId=" + currId + ", currCode=" + currCode + ", currNameEn=" + currNameEn + ", currNameJa="
				+ currNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(currCode, currId, currNameEn, currNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curr other = (Curr) obj;
		return Objects.equals(currCode, other.currCode) && Objects.equals(currId, other.currId)
				&& Objects.equals(currNameEn, other.currNameEn) && Objects.equals(currNameJa, other.currNameJa);
	}

}
