package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdLrnMoveId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "move_id")
	private Long moveId;
	
	@Column(name = "move_lrn_id")
	private Long moveLrnId;
	
	@Column(name = "lv")
	private Long lv;
	
	public PdLrnMoveId() {}

	public PdLrnMoveId(Long pdId, Long moveId, Long moveLrnId, Long lv) {
		super();
		this.pdId = pdId;
		this.moveId = moveId;
		this.moveLrnId = moveLrnId;
		this.lv = lv;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getMoveId() {
		return moveId;
	}

	public void setMoveId(Long moveId) {
		this.moveId = moveId;
	}

	public Long getMoveLrnId() {
		return moveLrnId;
	}

	public void setMoveLrnId(Long moveLrnId) {
		this.moveLrnId = moveLrnId;
	}

	public Long getLv() {
		return lv;
	}

	public void setLv(Long lv) {
		this.lv = lv;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdLrnMoveId [pdId=" + pdId + ", moveId=" + moveId + ", moveLrnId=" + moveLrnId + ", lv=" + lv + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(lv, moveId, moveLrnId, pdId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdLrnMoveId other = (PdLrnMoveId) obj;
		return Objects.equals(lv, other.lv) && Objects.equals(moveId, other.moveId)
				&& Objects.equals(moveLrnId, other.moveLrnId) && Objects.equals(pdId, other.pdId);
	}
	
}
