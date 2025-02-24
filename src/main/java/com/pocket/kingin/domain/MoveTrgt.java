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
@Table(name = "move_trgt")
public class MoveTrgt implements InternatName {
	@Column(name = "move_trgt_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveTrgtId;
	@Column(name = "move_trgt_code", unique = true)
	private String moveTrgtCode;
	@Column(name = "move_trgt_name_en")
	private String moveTrgtNameEn;
	@Column(name = "move_trgt_name_ja")
	private String moveTrgtNameJa;

	public MoveTrgt() {}
	
	public MoveTrgt(Long moveTrgtId, String moveTrgtCode, String moveTrgtNameEn, String moveTrgtNameJa) {
		super();
		this.moveTrgtId = moveTrgtId;
		this.moveTrgtCode = moveTrgtCode;
		this.moveTrgtNameEn = moveTrgtNameEn;
		this.moveTrgtNameJa = moveTrgtNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveTrgtNameEn);
		map.put("ja", this.moveTrgtNameJa);
		return map;
	}

	public Long getMoveTrgtId() {
		return moveTrgtId;
	}

	public void setMoveTrgtId(Long moveTrgtId) {
		this.moveTrgtId = moveTrgtId;
	}

	public String getMoveTrgtCode() {
		return moveTrgtCode;
	}

	public void setMoveTrgtCode(String moveTrgtCode) {
		this.moveTrgtCode = moveTrgtCode;
	}

	public String getMoveTrgtNameEn() {
		return moveTrgtNameEn;
	}

	public void setMoveTrgtNameEn(String moveTrgtNameEn) {
		this.moveTrgtNameEn = moveTrgtNameEn;
	}

	public String getMoveTrgtNameJa() {
		return moveTrgtNameJa;
	}

	public void setMoveTrgtNameJa(String moveTrgtNameJa) {
		this.moveTrgtNameJa = moveTrgtNameJa;
	}

	@Override
	public String toString() {
		return "MoveTrgt [moveTrgtId=" + moveTrgtId + ", moveTrgtCode=" + moveTrgtCode + ", moveTrgtNameEn=" + moveTrgtNameEn + ", moveTrgtNameJa="
				+ moveTrgtNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveTrgtCode, moveTrgtId, moveTrgtNameEn, moveTrgtNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveTrgt other = (MoveTrgt) obj;
		return Objects.equals(moveTrgtCode, other.moveTrgtCode) && Objects.equals(moveTrgtId, other.moveTrgtId)
				&& Objects.equals(moveTrgtNameEn, other.moveTrgtNameEn) && Objects.equals(moveTrgtNameJa, other.moveTrgtNameJa);
	}

}
