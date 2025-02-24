package com.pocket.kingin.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MoveCauseEffId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "move_id")
	private Long moveId;
	
	@Column(name = "move_eff_id")
	private Long moveEffId;

	public MoveCauseEffId() {}
	
	public MoveCauseEffId(Long moveId, Long moveEffId) {
		super();
		this.moveId = moveId;
		this.moveEffId = moveEffId;
	}

	public Long getMoveId() {
		return moveId;
	}

	public void setMoveId(Long moveId) {
		this.moveId = moveId;
	}

	public Long getMoveEffId() {
		return moveEffId;
	}

	public void setMoveEffId(Long moveEffId) {
		this.moveEffId = moveEffId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MoveCauseEffId [moveId=" + moveId + ", moveEffId=" + moveEffId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveEffId, moveId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveCauseEffId other = (MoveCauseEffId) obj;
		return Objects.equals(moveEffId, other.moveEffId) && Objects.equals(moveId, other.moveId);
	}
	
}
