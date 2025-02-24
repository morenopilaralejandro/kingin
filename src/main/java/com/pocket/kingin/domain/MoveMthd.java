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
@Table(name = "move_mthd")
public class MoveMthd implements InternatName {
	@Column(name = "move_mthd_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveMthdId;
	@Column(name = "move_mthd_code", unique = true)
	private String moveMthdCode;
	@Column(name = "move_mthd_name_en")
	private String moveMthdNameEn;
	@Column(name = "move_mthd_name_ja")
	private String moveMthdNameJa;

	public MoveMthd() {}
	
	public MoveMthd(Long moveMthdId, String moveMthdCode, String moveMthdNameEn, String moveMthdNameJa) {
		super();
		this.moveMthdId = moveMthdId;
		this.moveMthdCode = moveMthdCode;
		this.moveMthdNameEn = moveMthdNameEn;
		this.moveMthdNameJa = moveMthdNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveMthdNameEn);
		map.put("ja", this.moveMthdNameJa);
		return map;
	}

	public Long getMoveMthdId() {
		return moveMthdId;
	}

	public void setMoveMthdId(Long moveMthdId) {
		this.moveMthdId = moveMthdId;
	}

	public String getMoveMthdCode() {
		return moveMthdCode;
	}

	public void setMoveMthdCode(String moveMthdCode) {
		this.moveMthdCode = moveMthdCode;
	}

	public String getMoveMthdNameEn() {
		return moveMthdNameEn;
	}

	public void setMoveMthdNameEn(String moveMthdNameEn) {
		this.moveMthdNameEn = moveMthdNameEn;
	}

	public String getMoveMthdNameJa() {
		return moveMthdNameJa;
	}

	public void setMoveMthdNameJa(String moveMthdNameJa) {
		this.moveMthdNameJa = moveMthdNameJa;
	}

	@Override
	public String toString() {
		return "MoveMthd [moveMthdId=" + moveMthdId + ", moveMthdCode=" + moveMthdCode + ", moveMthdNameEn=" + moveMthdNameEn + ", moveMthdNameJa="
				+ moveMthdNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveMthdCode, moveMthdId, moveMthdNameEn, moveMthdNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveMthd other = (MoveMthd) obj;
		return Objects.equals(moveMthdCode, other.moveMthdCode) && Objects.equals(moveMthdId, other.moveMthdId)
				&& Objects.equals(moveMthdNameEn, other.moveMthdNameEn) && Objects.equals(moveMthdNameJa, other.moveMthdNameJa);
	}

}
