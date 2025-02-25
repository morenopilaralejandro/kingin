package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveTuto;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "move_cause_eff")
public class MoveRememberedTuto {
	@EmbeddedId
	private MoveRememberedTutoId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("moveId")
	@JoinColumn(name = "move_id")
	private Move move;
	
	@ManyToOne
	@MapsId("moveTutoId")
	@JoinColumn(name = "move_tuto_id")
	private MoveTuto moveTuto;
	
	@Column(name = "bp")
	private Long bp;

	public MoveRememberedTuto() {}

	public MoveRememberedTuto(MoveRememberedTutoId id, Move move, MoveTuto moveTuto, Long bp) {
		super();
		this.id = id;
		this.move = move;
		this.moveTuto = moveTuto;
		this.bp = bp;
	}
	
	public MoveRememberedTuto(Long moveId, Long moveTutoId, Move move, MoveTuto moveTuto, Long bp) {
		super();
		this.id = new MoveRememberedTutoId(moveId, moveTutoId);
		this.move = move;
		this.moveTuto = moveTuto;
		this.bp = bp;
	}
	
	public MoveRememberedTuto(Move move, MoveTuto moveTuto, Long bp) {
		super();
		this.id = new MoveRememberedTutoId(move.getMoveId(), moveTuto.getMoveTutoId());
		this.move = move;
		this.moveTuto = moveTuto;
		this.bp = bp;
	}

	public MoveRememberedTutoId getId() {
		return id;
	}

	public void setId(MoveRememberedTutoId id) {
		this.id = id;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public MoveTuto getMoveTuto() {
		return moveTuto;
	}

	public void setMoveTuto(MoveTuto moveTuto) {
		this.moveTuto = moveTuto;
	}

	public Long getBp() {
		return bp;
	}

	public void setBp(Long bp) {
		this.bp = bp;
	}

	@Override
	public String toString() {
		return "MoveRememberedTuto [id=" + id + ", move=" + move + ", moveTuto=" + moveTuto + ", bp=" + bp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bp, id, move, moveTuto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveRememberedTuto other = (MoveRememberedTuto) obj;
		return Objects.equals(bp, other.bp) && Objects.equals(id, other.id) && Objects.equals(move, other.move)
				&& Objects.equals(moveTuto, other.moveTuto);
	}
	
}
