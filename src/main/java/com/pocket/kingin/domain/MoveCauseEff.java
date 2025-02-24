package com.pocket.kingin.domain;

import java.util.Objects;

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
public class MoveCauseEff {
	@EmbeddedId
	private MoveCauseEffId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("moveId")
	@JoinColumn(name = "move_id")
	private Move move;
	
	@ManyToOne
	@MapsId("moveEffId")
	@JoinColumn(name = "move_eff_id")
	private MoveEff moveEff;
	
	@Column(name = "rate")
	private Long rate;

	public MoveCauseEff() {}
	
	public MoveCauseEff(MoveCauseEffId id, Move move, MoveEff moveEff, Long rate) {
		super();
		this.id = id;
		this.move = move;
		this.moveEff = moveEff;
		this.rate = rate;
	}
	
	public MoveCauseEff(Long moveId, Long moveEffId, Move move, MoveEff moveEff, Long rate) {
		super();
		this.id = new MoveCauseEffId(moveId, moveEffId);
		this.move = move;
		this.moveEff = moveEff;
		this.rate = rate;
	}

	public MoveCauseEffId getId() {
		return id;
	}

	public void setId(MoveCauseEffId id) {
		this.id = id;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public MoveEff getMoveEff() {
		return moveEff;
	}

	public void setMoveEff(MoveEff moveEff) {
		this.moveEff = moveEff;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "MoveCauseEff [id=" + id + ", move=" + move + ", moveEff=" + moveEff + ", rate=" + rate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, move, moveEff, rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveCauseEff other = (MoveCauseEff) obj;
		return Objects.equals(id, other.id) && Objects.equals(move, other.move)
				&& Objects.equals(moveEff, other.moveEff) && Objects.equals(rate, other.rate);
	}
	
}
