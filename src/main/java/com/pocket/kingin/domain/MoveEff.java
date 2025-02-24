package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatDesc;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "move_eff")
public class MoveEff implements InternatDesc {
	@Column(name = "move_eff_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveEffId;
	@Column(name = "move_eff_code", unique = true)
	private String moveEffCode;
	@Column(name = "move_eff_desc_en")
	private String moveEffDescEn;
	@Column(name = "move_eff_desc_ja")
	private String moveEffDescJa;

	public MoveEff() {}
	
	public MoveEff(Long moveEffId, String moveEffCode, String moveEffDescEn, String moveEffDescJa) {
		super();
		this.moveEffId = moveEffId;
		this.moveEffCode = moveEffCode;
		this.moveEffDescEn = moveEffDescEn;
		this.moveEffDescJa = moveEffDescJa;
	}

	@Override
	public Map<String, String> getInternatDesc() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveEffDescEn);
		map.put("ja", this.moveEffDescJa);
		return map;
	}

	public Long getMoveEffId() {
		return moveEffId;
	}

	public void setMoveEffId(Long moveEffId) {
		this.moveEffId = moveEffId;
	}

	public String getMoveEffCode() {
		return moveEffCode;
	}

	public void setMoveEffCode(String moveEffCode) {
		this.moveEffCode = moveEffCode;
	}

	public String getMoveEffDescEn() {
		return moveEffDescEn;
	}

	public void setMoveEffDescEn(String moveEffDescEn) {
		this.moveEffDescEn = moveEffDescEn;
	}

	public String getMoveEffDescJa() {
		return moveEffDescJa;
	}

	public void setMoveEffDescJa(String moveEffDescJa) {
		this.moveEffDescJa = moveEffDescJa;
	}

	@Override
	public String toString() {
		return "MoveEff [moveEffId=" + moveEffId + ", moveEffCode=" + moveEffCode + ", moveEffDescEn=" + moveEffDescEn
				+ ", moveEffDescJa=" + moveEffDescJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveEffCode, moveEffDescEn, moveEffDescJa, moveEffId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveEff other = (MoveEff) obj;
		return Objects.equals(moveEffCode, other.moveEffCode) && Objects.equals(moveEffDescEn, other.moveEffDescEn)
				&& Objects.equals(moveEffDescJa, other.moveEffDescJa) && Objects.equals(moveEffId, other.moveEffId);
	}

}
