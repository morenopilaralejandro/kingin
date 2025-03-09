package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.composite.MoveCauseEff;
import com.pocket.kingin.composite.MoveRememberedTuto;
import com.pocket.kingin.composite.PdLrnMove;
import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "move")
public class Move implements InternatName {
	@Column(name = "move_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long moveId;
	@Column(name = "move_code", unique = true)
	private String moveCode;
	@Column(name = "move_name_en")
	private String moveNameEn;
	@Column(name = "move_name_ja")
	private String moveNameJa;
	@Column(name = "move_pp")
	private Long movePp;
	@Column(name = "move_bp")
	private Long moveBp;
	@Column(name = "move_ac")
	private Long moveAc;
	@Column(name = "move_prio")
	private Long movePrio;
	@Column(name = "move_is_bright")
	private Boolean moveIsBright;
	@Column(name = "move_is_king")
	private Boolean moveIsking;
	@Column(name = "move_is_contact")
	private Boolean moveIscontact;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id", referencedColumnName = "type_id")
	private Type type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "move_cat_id", referencedColumnName = "move_cat_id")
	private MoveCat moveCat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "move_trgt_id", referencedColumnName = "move_trgt_id")
	private MoveTrgt moveTrgt;
	
	@OneToMany(mappedBy = "move", fetch = FetchType.LAZY)
	private List<MoveCauseEff> moveCauseEffs;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "move_considered_mthd", joinColumns = @JoinColumn(name = "move_id"), inverseJoinColumns = @JoinColumn(name = "move_mthd_id"))
	private List<MoveMthd> mthds;
	
	@OneToMany(mappedBy = "move", fetch = FetchType.LAZY)
	private List<MoveRememberedTuto> moveRememberedTutos;
	
	@OneToMany(mappedBy = "move", fetch = FetchType.LAZY)
	private List<PdLrnMove> pdLrnMove;
	
	@OneToMany(mappedBy = "move")
	private List<ItemMach> items;
	
	public Move() {}

	public Move(Long moveId, String moveCode, String moveNameEn, String moveNameJa, Long movePp, Long moveBp,
			Long moveAc, Long movePrio, Boolean moveIsBright, Boolean moveIsking, Boolean moveIscontact, Type type,
			MoveCat moveCat, MoveTrgt moveTrgt) {
		super();
		this.moveId = moveId;
		this.moveCode = moveCode;
		this.moveNameEn = moveNameEn;
		this.moveNameJa = moveNameJa;
		this.movePp = movePp;
		this.moveBp = moveBp;
		this.moveAc = moveAc;
		this.movePrio = movePrio;
		this.moveIsBright = moveIsBright;
		this.moveIsking = moveIsking;
		this.moveIscontact = moveIscontact;
		this.type = type;
		this.moveCat = moveCat;
		this.moveTrgt = moveTrgt;
	}
	
	public String getEffectInline(String lang) {
		String aux = "";
		int i = 0;
		for (MoveCauseEff mce : this.getMoveCauseEffs()) {
			if (mce.getRate() == null) {
				aux += mce.getMoveEff().getInternatDesc().get(lang);		
			} else {
				if (lang.equals("ja")) {
					aux += mce.getRate() + "%の" + mce.getMoveEff().getInternatDesc().get(lang);
				} else {
					aux += mce.getMoveEff().getInternatDesc().get(lang) + " (" + mce.getRate() + "%)";
				}
			}
			if (i < this.getMoveCauseEffs().size() - 1 && !lang.equals("ja")) {
				aux += " "; 
			}
			i++;
		}
		return aux;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.moveNameEn);
		map.put("ja", this.moveNameJa);
		return map;
	}

	public Long getMoveId() {
		return moveId;
	}

	public void setMoveId(Long moveId) {
		this.moveId = moveId;
	}

	public String getMoveCode() {
		return moveCode;
	}

	public void setMoveCode(String moveCode) {
		this.moveCode = moveCode;
	}

	public String getMoveNameEn() {
		return moveNameEn;
	}

	public void setMoveNameEn(String moveNameEn) {
		this.moveNameEn = moveNameEn;
	}

	public String getMoveNameJa() {
		return moveNameJa;
	}

	public void setMoveNameJa(String moveNameJa) {
		this.moveNameJa = moveNameJa;
	}

	public Long getMovePp() {
		return movePp;
	}

	public void setMovePp(Long movePp) {
		this.movePp = movePp;
	}

	public Long getMoveBp() {
		return moveBp;
	}

	public void setMoveBp(Long moveBp) {
		this.moveBp = moveBp;
	}

	public Long getMoveAc() {
		return moveAc;
	}

	public void setMoveAc(Long moveAc) {
		this.moveAc = moveAc;
	}

	public Long getMovePrio() {
		return movePrio;
	}

	public void setMovePrio(Long movePrio) {
		this.movePrio = movePrio;
	}

	public Boolean getMoveIsBright() {
		return moveIsBright;
	}

	public void setMoveIsBright(Boolean moveIsBright) {
		this.moveIsBright = moveIsBright;
	}

	public Boolean getMoveIsking() {
		return moveIsking;
	}

	public void setMoveIsking(Boolean moveIsking) {
		this.moveIsking = moveIsking;
	}

	public Boolean getMoveIscontact() {
		return moveIscontact;
	}

	public void setMoveIscontact(Boolean moveIscontact) {
		this.moveIscontact = moveIscontact;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public MoveCat getMoveCat() {
		return moveCat;
	}

	public void setMoveCat(MoveCat moveCat) {
		this.moveCat = moveCat;
	}

	public MoveTrgt getMoveTrgt() {
		return moveTrgt;
	}

	public void setMoveTrgt(MoveTrgt moveTrgt) {
		this.moveTrgt = moveTrgt;
	}

	public List<MoveCauseEff> getMoveCauseEffs() {
		return moveCauseEffs;
	}

	public void setMoveCauseEffs(List<MoveCauseEff> moveCauseEffs) {
		this.moveCauseEffs = moveCauseEffs;
	}

	public List<MoveMthd> getMthds() {
		return mthds;
	}

	public void setMthds(List<MoveMthd> mthds) {
		this.mthds = mthds;
	}

	public List<MoveRememberedTuto> getMoveRememberedTutos() {
		return moveRememberedTutos;
	}

	public void setMoveRememberedTutos(List<MoveRememberedTuto> moveRememberedTutos) {
		this.moveRememberedTutos = moveRememberedTutos;
	}

	public List<PdLrnMove> getPdLrnMove() {
		return pdLrnMove;
	}

	public void setPdLrnMove(List<PdLrnMove> pdLrnMove) {
		this.pdLrnMove = pdLrnMove;
	}

	public List<ItemMach> getItems() {
		return items;
	}

	public void setItems(List<ItemMach> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Move [moveId=" + moveId + ", moveCode=" + moveCode + ", moveNameEn=" + moveNameEn + ", moveNameJa="
				+ moveNameJa + ", movePp=" + movePp + ", moveBp=" + moveBp + ", moveAc=" + moveAc + ", movePrio="
				+ movePrio + ", moveIsBright=" + moveIsBright + ", moveIsking=" + moveIsking + ", moveIscontact="
				+ moveIscontact + ", type=" + type + ", moveCat=" + moveCat + ", moveTrgt=" + moveTrgt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(moveAc, moveBp, moveCat, moveCode, moveId, moveIsBright, moveIscontact, moveIsking,
				moveNameEn, moveNameJa, movePp, movePrio, moveTrgt, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		return Objects.equals(moveAc, other.moveAc) && Objects.equals(moveBp, other.moveBp)
				&& Objects.equals(moveCat, other.moveCat) && Objects.equals(moveCode, other.moveCode)
				&& Objects.equals(moveId, other.moveId) && Objects.equals(moveIsBright, other.moveIsBright)
				&& Objects.equals(moveIscontact, other.moveIscontact) && Objects.equals(moveIsking, other.moveIsking)
				&& Objects.equals(moveNameEn, other.moveNameEn) && Objects.equals(moveNameJa, other.moveNameJa)
				&& Objects.equals(movePp, other.movePp) && Objects.equals(movePrio, other.movePrio)
				&& Objects.equals(moveTrgt, other.moveTrgt) && Objects.equals(type, other.type);
	}

}
