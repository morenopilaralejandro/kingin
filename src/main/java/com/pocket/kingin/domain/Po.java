package com.pocket.kingin.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "po")
public class Po {
	@Column(name = "po_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long poId;
	@Column(name = "po_uuid", unique = true)
	private String poUuid;
	@Column(name = "po_date_crt")
	private Date poDateCrt;
	@Column(name = "po_date_mod")
	private Date poDateMod;
	@Transient
	private List<Long> poDef;
	@Column(name = "po_def_hp")
	private Long poDefHp;	
	@Column(name = "po_def_atk")
	private Long poDefAtk;
	@Column(name = "po_def_def")
	private Long poDefDef;
	@Column(name = "po_def_spatk")
	private Long poDefSpatk;
	@Column(name = "po_def_spdef")
	private Long poDefSpdef;
	@Column(name = "po_def_spe")
	private Long poDefSpe;
	@Transient
	private List<Long> poCur;
	@Column(name = "po_cur_hp")
	private Long poCurHp;
	@Column(name = "po_cur_atk")
	private Long poCurAtk;
	@Column(name = "po_cur_def")
	private Long poCurDef;
	@Column(name = "po_cur_spatk")
	private Long poCurSpatk;
	@Column(name = "po_cur_spdef")
	private Long poCurSpdef;
	@Column(name = "po_cur_spe")
	private Long poCurSpe;
	@Transient
	private List<Long> poEv;
	@Column(name = "po_ev_hp")
	private Long poEvHp;
	@Column(name = "po_ev_atk")
	private Long poEvAtk;
	@Column(name = "po_ev_def")
	private Long poEvDef;
	@Column(name = "po_ev_spatk")
	private Long poEvSpatk;
	@Column(name = "po_ev_spdef")
	private Long poEvSpdef;
	@Column(name = "po_ev_spe")
	private Long poEvSpe;
	@Transient
	private List<Boolean> poIsSaiko;
	@Column(name = "po_is_saiko_hp")
	private Boolean poIsSaikoHp;
	@Column(name = "po_is_saiko_atk")
	private Boolean poIsSaikoAtk;
	@Column(name = "po_is_saiko_def")
	private Boolean poIsSaikoDef;
	@Column(name = "po_is_saiko_spatk")
	private Boolean poIsSaikoSpatk;
	@Column(name = "po_is_saiko_spdef")
	private Boolean poIsSaikoSpdef;
	@Column(name = "po_is_saiko_spe")
	private Boolean poIsSaikoSpe;
	
	@Column(name = "po_is_priv")
	private Boolean poIsPriv;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pd_id", referencedColumnName = "pd_id")
	private Pd pd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
	private Usr usr;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "abil_id", referencedColumnName = "abil_id")
	private Abil abil;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "natu_id", referencedColumnName = "natu_id")
	private Natu natu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gndr_id", referencedColumnName = "gndr_id")
	private Gndr gndr;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "po_held_item", joinColumns = @JoinColumn(name = "po_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "po_know_move", joinColumns = @JoinColumn(name = "po_id"), inverseJoinColumns = @JoinColumn(name = "move_id"))
	private List<Move> moves;
	
	public Po() {}

	public Po(Long poId, String poUuid, Date poDateCrt, Date poDateMod, Long poDefHp, Long poDefAtk, Long poDefDef,
			Long poDefSpatk, Long poDefSpdef, Long poDefSpe, Long poCurHp, Long poCurAtk, Long poCurDef,
			Long poCurSpatk, Long poCurSpdef, Long poCurSpe, Long poEvHp, Long poEvAtk, Long poEvDef, Long poEvSpatk,
			Long poEvSpdef, Long poEvSpe, Boolean poIsSaikoHp, Boolean poIsSaikoAtk, Boolean poIsSaikoDef,
			Boolean poIsSaikoSpatk, Boolean poIsSaikoSpdef, Boolean poIsSaikoSpe, Boolean poIsPriv, Pd pd, Usr usr,
			Abil abil, Natu natu, Gndr gndr) {
		super();
		this.poId = poId;
		this.poUuid = poUuid;
		this.poDateCrt = poDateCrt;
		this.poDateMod = poDateMod;
		this.poDefHp = poDefHp;
		this.poDefAtk = poDefAtk;
		this.poDefDef = poDefDef;
		this.poDefSpatk = poDefSpatk;
		this.poDefSpdef = poDefSpdef;
		this.poDefSpe = poDefSpe;
		this.poCurHp = poCurHp;
		this.poCurAtk = poCurAtk;
		this.poCurDef = poCurDef;
		this.poCurSpatk = poCurSpatk;
		this.poCurSpdef = poCurSpdef;
		this.poCurSpe = poCurSpe;
		this.poEvHp = poEvHp;
		this.poEvAtk = poEvAtk;
		this.poEvDef = poEvDef;
		this.poEvSpatk = poEvSpatk;
		this.poEvSpdef = poEvSpdef;
		this.poEvSpe = poEvSpe;
		this.poIsSaikoHp = poIsSaikoHp;
		this.poIsSaikoAtk = poIsSaikoAtk;
		this.poIsSaikoDef = poIsSaikoDef;
		this.poIsSaikoSpatk = poIsSaikoSpatk;
		this.poIsSaikoSpdef = poIsSaikoSpdef;
		this.poIsSaikoSpe = poIsSaikoSpe;
		this.poIsPriv = poIsPriv;
		this.pd = pd;
		this.usr = usr;
		this.abil = abil;
		this.natu = natu;
		this.gndr = gndr;
	}

	public Long getPoId() {
		return poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
	}

	public String getPoUuid() {
		return poUuid;
	}

	public void setPoUuid(String poUuid) {
		this.poUuid = poUuid;
	}

	public Date getPoDateCrt() {
		return poDateCrt;
	}

	public void setPoDateCrt(Date poDateCrt) {
		this.poDateCrt = poDateCrt;
	}

	public Date getPoDateMod() {
		return poDateMod;
	}

	public void setPoDateMod(Date poDateMod) {
		this.poDateMod = poDateMod;
	}

	public List<Long> getPoDef() {
		return poDef;
	}

	public void setPoDef(List<Long> poDef) {
		this.poDef = poDef;
	}

	public Long getPoDefHp() {
		return poDefHp;
	}

	public void setPoDefHp(Long poDefHp) {
		this.poDefHp = poDefHp;
	}

	public Long getPoDefAtk() {
		return poDefAtk;
	}

	public void setPoDefAtk(Long poDefAtk) {
		this.poDefAtk = poDefAtk;
	}

	public Long getPoDefDef() {
		return poDefDef;
	}

	public void setPoDefDef(Long poDefDef) {
		this.poDefDef = poDefDef;
	}

	public Long getPoDefSpatk() {
		return poDefSpatk;
	}

	public void setPoDefSpatk(Long poDefSpatk) {
		this.poDefSpatk = poDefSpatk;
	}

	public Long getPoDefSpdef() {
		return poDefSpdef;
	}

	public void setPoDefSpdef(Long poDefSpdef) {
		this.poDefSpdef = poDefSpdef;
	}

	public Long getPoDefSpe() {
		return poDefSpe;
	}

	public void setPoDefSpe(Long poDefSpe) {
		this.poDefSpe = poDefSpe;
	}

	public List<Long> getPoCur() {
		return poCur;
	}

	public void setPoCur(List<Long> poCur) {
		this.poCur = poCur;
	}

	public Long getPoCurHp() {
		return poCurHp;
	}

	public void setPoCurHp(Long poCurHp) {
		this.poCurHp = poCurHp;
	}

	public Long getPoCurAtk() {
		return poCurAtk;
	}

	public void setPoCurAtk(Long poCurAtk) {
		this.poCurAtk = poCurAtk;
	}

	public Long getPoCurDef() {
		return poCurDef;
	}

	public void setPoCurDef(Long poCurDef) {
		this.poCurDef = poCurDef;
	}

	public Long getPoCurSpatk() {
		return poCurSpatk;
	}

	public void setPoCurSpatk(Long poCurSpatk) {
		this.poCurSpatk = poCurSpatk;
	}

	public Long getPoCurSpdef() {
		return poCurSpdef;
	}

	public void setPoCurSpdef(Long poCurSpdef) {
		this.poCurSpdef = poCurSpdef;
	}

	public Long getPoCurSpe() {
		return poCurSpe;
	}

	public void setPoCurSpe(Long poCurSpe) {
		this.poCurSpe = poCurSpe;
	}

	public List<Long> getPoEv() {
		return poEv;
	}

	public void setPoEv(List<Long> poEv) {
		this.poEv = poEv;
	}

	public Long getPoEvHp() {
		return poEvHp;
	}

	public void setPoEvHp(Long poEvHp) {
		this.poEvHp = poEvHp;
	}

	public Long getPoEvAtk() {
		return poEvAtk;
	}

	public void setPoEvAtk(Long poEvAtk) {
		this.poEvAtk = poEvAtk;
	}

	public Long getPoEvDef() {
		return poEvDef;
	}

	public void setPoEvDef(Long poEvDef) {
		this.poEvDef = poEvDef;
	}

	public Long getPoEvSpatk() {
		return poEvSpatk;
	}

	public void setPoEvSpatk(Long poEvSpatk) {
		this.poEvSpatk = poEvSpatk;
	}

	public Long getPoEvSpdef() {
		return poEvSpdef;
	}

	public void setPoEvSpdef(Long poEvSpdef) {
		this.poEvSpdef = poEvSpdef;
	}

	public Long getPoEvSpe() {
		return poEvSpe;
	}

	public void setPoEvSpe(Long poEvSpe) {
		this.poEvSpe = poEvSpe;
	}

	public List<Boolean> getPoIsSaiko() {
		return poIsSaiko;
	}

	public void setPoIsSaiko(List<Boolean> poIsSaiko) {
		this.poIsSaiko = poIsSaiko;
	}

	public Boolean getPoIsSaikoHp() {
		return poIsSaikoHp;
	}

	public void setPoIsSaikoHp(Boolean poIsSaikoHp) {
		this.poIsSaikoHp = poIsSaikoHp;
	}

	public Boolean getPoIsSaikoAtk() {
		return poIsSaikoAtk;
	}

	public void setPoIsSaikoAtk(Boolean poIsSaikoAtk) {
		this.poIsSaikoAtk = poIsSaikoAtk;
	}

	public Boolean getPoIsSaikoDef() {
		return poIsSaikoDef;
	}

	public void setPoIsSaikoDef(Boolean poIsSaikoDef) {
		this.poIsSaikoDef = poIsSaikoDef;
	}

	public Boolean getPoIsSaikoSpatk() {
		return poIsSaikoSpatk;
	}

	public void setPoIsSaikoSpatk(Boolean poIsSaikoSpatk) {
		this.poIsSaikoSpatk = poIsSaikoSpatk;
	}

	public Boolean getPoIsSaikoSpdef() {
		return poIsSaikoSpdef;
	}

	public void setPoIsSaikoSpdef(Boolean poIsSaikoSpdef) {
		this.poIsSaikoSpdef = poIsSaikoSpdef;
	}

	public Boolean getPoIsSaikoSpe() {
		return poIsSaikoSpe;
	}

	public void setPoIsSaikoSpe(Boolean poIsSaikoSpe) {
		this.poIsSaikoSpe = poIsSaikoSpe;
	}

	public Boolean getPoIsPriv() {
		return poIsPriv;
	}

	public void setPoIsPriv(Boolean poIsPriv) {
		this.poIsPriv = poIsPriv;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Usr getUsr() {
		return usr;
	}

	public void setUsr(Usr usr) {
		this.usr = usr;
	}

	public Abil getAbil() {
		return abil;
	}

	public void setAbil(Abil abil) {
		this.abil = abil;
	}

	public Natu getNatu() {
		return natu;
	}

	public void setNatu(Natu natu) {
		this.natu = natu;
	}

	public Gndr getGndr() {
		return gndr;
	}

	public void setGndr(Gndr gndr) {
		this.gndr = gndr;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	@Override
	public String toString() {
		return "Po [poId=" + poId + ", poUuid=" + poUuid + ", poDateCrt=" + poDateCrt + ", poDate_Mod=" + poDateMod
				+ ", poDefHp=" + poDefHp + ", poDefAtk=" + poDefAtk + ", poDefDef=" + poDefDef + ", poDefSpatk="
				+ poDefSpatk + ", poDefSpdef=" + poDefSpdef + ", poDefSpe=" + poDefSpe + ", poCurHp=" + poCurHp
				+ ", poCurAtk=" + poCurAtk + ", poCurDef=" + poCurDef + ", poCurSpatk=" + poCurSpatk + ", poCurSpdef="
				+ poCurSpdef + ", poCurSpe=" + poCurSpe + ", poEvHp=" + poEvHp + ", poEvAtk=" + poEvAtk + ", poEvDef="
				+ poEvDef + ", poEvSpatk=" + poEvSpatk + ", poEvSpdef=" + poEvSpdef + ", poEvSpe=" + poEvSpe
				+ ", poIsSaikoHp=" + poIsSaikoHp + ", poIsSaikoAtk=" + poIsSaikoAtk + ", poIsSaikoDef=" + poIsSaikoDef
				+ ", poIsSaikoSpatk=" + poIsSaikoSpatk + ", poIsSaikoSpdef=" + poIsSaikoSpdef + ", poIsSaikoSpe="
				+ poIsSaikoSpe + ", poIsPriv=" + poIsPriv + ", pd=" + pd + ", usr=" + usr + ", abil=" + abil + ", natu="
				+ natu + ", gndr=" + gndr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abil, gndr, natu, pd, poCurAtk, poCurDef, poCurHp, poCurSpatk, poCurSpdef, poCurSpe,
				poDateCrt, poDateMod, poDefAtk, poDefDef, poDefHp, poDefSpatk, poDefSpdef, poDefSpe, poEvAtk, poEvDef,
				poEvHp, poEvSpatk, poEvSpdef, poEvSpe, poId, poIsPriv, poIsSaikoAtk, poIsSaikoDef, poIsSaikoHp,
				poIsSaikoSpatk, poIsSaikoSpdef, poIsSaikoSpe, poUuid, usr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Po other = (Po) obj;
		return Objects.equals(abil, other.abil) && Objects.equals(gndr, other.gndr) && Objects.equals(natu, other.natu)
				&& Objects.equals(pd, other.pd) && Objects.equals(poCurAtk, other.poCurAtk)
				&& Objects.equals(poCurDef, other.poCurDef) && Objects.equals(poCurHp, other.poCurHp)
				&& Objects.equals(poCurSpatk, other.poCurSpatk) && Objects.equals(poCurSpdef, other.poCurSpdef)
				&& Objects.equals(poCurSpe, other.poCurSpe) && Objects.equals(poDateCrt, other.poDateCrt)
				&& Objects.equals(poDateMod, other.poDateMod) && Objects.equals(poDefAtk, other.poDefAtk)
				&& Objects.equals(poDefDef, other.poDefDef) && Objects.equals(poDefHp, other.poDefHp)
				&& Objects.equals(poDefSpatk, other.poDefSpatk) && Objects.equals(poDefSpdef, other.poDefSpdef)
				&& Objects.equals(poDefSpe, other.poDefSpe) && Objects.equals(poEvAtk, other.poEvAtk)
				&& Objects.equals(poEvDef, other.poEvDef) && Objects.equals(poEvHp, other.poEvHp)
				&& Objects.equals(poEvSpatk, other.poEvSpatk) && Objects.equals(poEvSpdef, other.poEvSpdef)
				&& Objects.equals(poEvSpe, other.poEvSpe) && Objects.equals(poId, other.poId)
				&& Objects.equals(poIsPriv, other.poIsPriv) && Objects.equals(poIsSaikoAtk, other.poIsSaikoAtk)
				&& Objects.equals(poIsSaikoDef, other.poIsSaikoDef) && Objects.equals(poIsSaikoHp, other.poIsSaikoHp)
				&& Objects.equals(poIsSaikoSpatk, other.poIsSaikoSpatk)
				&& Objects.equals(poIsSaikoSpdef, other.poIsSaikoSpdef)
				&& Objects.equals(poIsSaikoSpe, other.poIsSaikoSpe) && Objects.equals(poUuid, other.poUuid)
				&& Objects.equals(usr, other.usr);
	}

}
