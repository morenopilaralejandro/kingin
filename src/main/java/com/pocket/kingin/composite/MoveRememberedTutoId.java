package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MoveRememberedTutoId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "move_id")
	private Long moveId;
	
	@Column(name = "move_tuto_id")
	private Long moveTutoId;

	public MoveRememberedTutoId() {}

	public MoveRememberedTutoId(Long moveId, Long moveTutoId) {
		super();
		this.moveId = moveId;
		this.moveTutoId = moveTutoId;
	}

	public Long getMoveId() {
		return moveId;
	}

	public void setMoveId(Long moveId) {
		this.moveId = moveId;
	}

	public Long getMoveTutoId() {
		return moveTutoId;
	}

	public void setMoveTutoId(Long moveTutoId) {
		this.moveTutoId = moveTutoId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MoveRememberedTutoId [moveId=" + moveId + ", moveTutoId=" + moveTutoId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveId, moveTutoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveRememberedTutoId other = (MoveRememberedTutoId) obj;
		return Objects.equals(moveId, other.moveId) && Objects.equals(moveTutoId, other.moveTutoId);
	}
	
}
