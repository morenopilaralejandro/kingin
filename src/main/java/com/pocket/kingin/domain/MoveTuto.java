package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.composite.MoveRememberedTuto;
import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "move_tuto")
public class MoveTuto implements InternatName {
	@Column(name = "move_tuto_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveTutoId;
	@Column(name = "move_tuto_code", unique = true)
	private String moveTutoCode;
	@Column(name = "move_tuto_name_en")
	private String moveTutoNameEn;
	@Column(name = "move_tuto_name_ja")
	private String moveTutoNameJa;
	
	@OneToMany(mappedBy = "moveTuto", fetch = FetchType.LAZY)
	private List<MoveRememberedTuto> moveRememberedTutos;

	public MoveTuto() {}
	
	public MoveTuto(Long moveTutoId, String moveTutoCode, String moveTutoNameEn, String moveTutoNameJa) {
		super();
		this.moveTutoId = moveTutoId;
		this.moveTutoCode = moveTutoCode;
		this.moveTutoNameEn = moveTutoNameEn;
		this.moveTutoNameJa = moveTutoNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveTutoNameEn);
		map.put("ja", this.moveTutoNameJa);
		return map;
	}

	public Long getMoveTutoId() {
		return moveTutoId;
	}

	public void setMoveTutoId(Long moveTutoId) {
		this.moveTutoId = moveTutoId;
	}

	public String getMoveTutoCode() {
		return moveTutoCode;
	}

	public void setMoveTutoCode(String moveTutoCode) {
		this.moveTutoCode = moveTutoCode;
	}

	public String getMoveTutoNameEn() {
		return moveTutoNameEn;
	}

	public void setMoveTutoNameEn(String moveTutoNameEn) {
		this.moveTutoNameEn = moveTutoNameEn;
	}

	public String getMoveTutoNameJa() {
		return moveTutoNameJa;
	}

	public void setMoveTutoNameJa(String moveTutoNameJa) {
		this.moveTutoNameJa = moveTutoNameJa;
	}
	
	public List<MoveRememberedTuto> getMoveRememberedTutos() {
		return moveRememberedTutos;
	}

	public void setMoveRememberedTutos(List<MoveRememberedTuto> moveRememberedTutos) {
		this.moveRememberedTutos = moveRememberedTutos;
	}

	@Override
	public String toString() {
		return "MoveTuto [moveTutoId=" + moveTutoId + ", moveTutoCode=" + moveTutoCode + ", moveTutoNameEn=" + moveTutoNameEn + ", moveTutoNameJa="
				+ moveTutoNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveTutoCode, moveTutoId, moveTutoNameEn, moveTutoNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveTuto other = (MoveTuto) obj;
		return Objects.equals(moveTutoCode, other.moveTutoCode) && Objects.equals(moveTutoId, other.moveTutoId)
				&& Objects.equals(moveTutoNameEn, other.moveTutoNameEn) && Objects.equals(moveTutoNameJa, other.moveTutoNameJa);
	}

}
