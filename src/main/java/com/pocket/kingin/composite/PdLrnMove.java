package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Move;
import com.pocket.kingin.domain.MoveLrn;
import com.pocket.kingin.domain.Pd;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd_lrn_move")
public class PdLrnMove {
	@EmbeddedId
	private PdLrnMoveId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("moveId")
	@JoinColumn(name = "move_id")
	private Move move;
	
	@ManyToOne
	@MapsId("moveLrnId")
	@JoinColumn(name = "move_lrn_id")
	private MoveLrn moveLrn;

	public PdLrnMove() {}

	public PdLrnMove(PdLrnMoveId id, Pd pd, Move move, MoveLrn moveLrn) {
		super();
		this.id = id;
		this.pd = pd;
		this.move = move;
		this.moveLrn = moveLrn;
	}
	
	public PdLrnMove(Pd pd, Move move, MoveLrn moveLrn, Long lv) {
		super();
		this.id = new PdLrnMoveId(pd.getPdId(), move.getMoveId(), moveLrn.getMoveLrnId(), lv);
		this.pd = pd;
		this.move = move;
		this.moveLrn = moveLrn;
	}

	public PdLrnMoveId getId() {
		return id;
	}

	public void setId(PdLrnMoveId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public MoveLrn getMoveLrn() {
		return moveLrn;
	}

	public void setMoveLrn(MoveLrn moveLrn) {
		this.moveLrn = moveLrn;
	}

	@Override
	public String toString() {
		return "PdLrnMove [id=" + id + ", pd=" + pd + ", move=" + move + ", moveLrn=" + moveLrn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, move, moveLrn, pd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdLrnMove other = (PdLrnMove) obj;
		return Objects.equals(id, other.id) && Objects.equals(move, other.move)
				&& Objects.equals(moveLrn, other.moveLrn) && Objects.equals(pd, other.pd);
	}
	
}
