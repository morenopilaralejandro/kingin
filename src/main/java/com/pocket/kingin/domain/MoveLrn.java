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
@Table(name = "move_lrn")
public class MoveLrn implements InternatName {
	@Column(name = "move_lrn_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveLrnId;
	@Column(name = "move_lrn_code", unique = true)
	private String moveLrnCode;
	@Column(name = "move_lrn_name_en")
	private String moveLrnNameEn;
	@Column(name = "move_lrn_name_ja")
	private String moveLrnNameJa;

	public MoveLrn() {}
	
	public MoveLrn(Long moveLrnId, String moveLrnCode, String moveLrnNameEn, String moveLrnNameJa) {
		super();
		this.moveLrnId = moveLrnId;
		this.moveLrnCode = moveLrnCode;
		this.moveLrnNameEn = moveLrnNameEn;
		this.moveLrnNameJa = moveLrnNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveLrnNameEn);
		map.put("ja", this.moveLrnNameJa);
		return map;
	}

	public Long getMoveLrnId() {
		return moveLrnId;
	}

	public void setMoveLrnId(Long moveLrnId) {
		this.moveLrnId = moveLrnId;
	}

	public String getMoveLrnCode() {
		return moveLrnCode;
	}

	public void setMoveLrnCode(String moveLrnCode) {
		this.moveLrnCode = moveLrnCode;
	}

	public String getMoveLrnNameEn() {
		return moveLrnNameEn;
	}

	public void setMoveLrnNameEn(String moveLrnNameEn) {
		this.moveLrnNameEn = moveLrnNameEn;
	}

	public String getMoveLrnNameJa() {
		return moveLrnNameJa;
	}

	public void setMoveLrnNameJa(String moveLrnNameJa) {
		this.moveLrnNameJa = moveLrnNameJa;
	}

	@Override
	public String toString() {
		return "MoveLrn [moveLrnId=" + moveLrnId + ", moveLrnCode=" + moveLrnCode + ", moveLrnNameEn=" + moveLrnNameEn + ", moveLrnNameJa="
				+ moveLrnNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveLrnCode, moveLrnId, moveLrnNameEn, moveLrnNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveLrn other = (MoveLrn) obj;
		return Objects.equals(moveLrnCode, other.moveLrnCode) && Objects.equals(moveLrnId, other.moveLrnId)
				&& Objects.equals(moveLrnNameEn, other.moveLrnNameEn) && Objects.equals(moveLrnNameJa, other.moveLrnNameJa);
	}

}
