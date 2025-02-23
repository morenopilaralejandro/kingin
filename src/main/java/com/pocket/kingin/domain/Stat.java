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
@Table(name = "stat")
public class Stat implements InternatName {
	@Column(name = "stat_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long statId;
	@Column(name = "stat_code", unique = true)
	private String statCode;
	@Column(name = "stat_name_en")
	private String statNameEn;
	@Column(name = "stat_name_ja")
	private String statNameJa;

	public Stat() {
	}
	
	public Stat(Long statId, String statCode, String statNameEn, String statNameJa) {
		super();
		this.statId = statId;
		this.statCode = statCode;
		this.statNameEn = statNameEn;
		this.statNameJa = statNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.statNameEn);
		map.put("ja", this.statNameJa);
		return map;
	}

	public Long getStatId() {
		return statId;
	}

	public void setStatId(Long statId) {
		this.statId = statId;
	}

	public String getStatCode() {
		return statCode;
	}

	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}

	public String getStatNameEn() {
		return statNameEn;
	}

	public void setStatNameEn(String statNameEn) {
		this.statNameEn = statNameEn;
	}

	public String getStatNameJa() {
		return statNameJa;
	}

	public void setStatNameJa(String statNameJa) {
		this.statNameJa = statNameJa;
	}

	@Override
	public String toString() {
		return "Stat [statId=" + statId + ", statCode=" + statCode + ", statNameEn=" + statNameEn + ", statNameJa="
				+ statNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(statCode, statId, statNameEn, statNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stat other = (Stat) obj;
		return Objects.equals(statCode, other.statCode) && Objects.equals(statId, other.statId)
				&& Objects.equals(statNameEn, other.statNameEn) && Objects.equals(statNameJa, other.statNameJa);
	}

}
