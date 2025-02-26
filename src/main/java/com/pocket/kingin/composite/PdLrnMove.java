package com.pocket.kingin.composite;

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

	
	
}
