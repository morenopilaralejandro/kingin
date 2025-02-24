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
@Table(name = "move_cat")
public class MoveCat implements InternatName {
	@Column(name = "move_cat_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveCatId;
	@Column(name = "move_cat_code", unique = true)
	private String moveCatCode;
	@Column(name = "move_cat_name_en")
	private String moveCatNameEn;
	@Column(name = "move_cat_name_ja")
	private String moveCatNameJa;

	public MoveCat() {}
	
	public MoveCat(Long moveCatId, String moveCatCode, String moveCatNameEn, String moveCatNameJa) {
		super();
		this.moveCatId = moveCatId;
		this.moveCatCode = moveCatCode;
		this.moveCatNameEn = moveCatNameEn;
		this.moveCatNameJa = moveCatNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveCatNameEn);
		map.put("ja", this.moveCatNameJa);
		return map;
	}

	public Long getMoveCatId() {
		return moveCatId;
	}

	public void setMoveCatId(Long moveCatId) {
		this.moveCatId = moveCatId;
	}

	public String getMoveCatCode() {
		return moveCatCode;
	}

	public void setMoveCatCode(String moveCatCode) {
		this.moveCatCode = moveCatCode;
	}

	public String getMoveCatNameEn() {
		return moveCatNameEn;
	}

	public void setMoveCatNameEn(String moveCatNameEn) {
		this.moveCatNameEn = moveCatNameEn;
	}

	public String getMoveCatNameJa() {
		return moveCatNameJa;
	}

	public void setMoveCatNameJa(String moveCatNameJa) {
		this.moveCatNameJa = moveCatNameJa;
	}

	@Override
	public String toString() {
		return "MoveCat [moveCatId=" + moveCatId + ", moveCatCode=" + moveCatCode + ", moveCatNameEn=" + moveCatNameEn + ", moveCatNameJa="
				+ moveCatNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveCatCode, moveCatId, moveCatNameEn, moveCatNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveCat other = (MoveCat) obj;
		return Objects.equals(moveCatCode, other.moveCatCode) && Objects.equals(moveCatId, other.moveCatId)
				&& Objects.equals(moveCatNameEn, other.moveCatNameEn) && Objects.equals(moveCatNameJa, other.moveCatNameJa);
	}

}
