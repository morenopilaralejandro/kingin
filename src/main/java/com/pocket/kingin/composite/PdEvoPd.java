package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.EvoCond;
import com.pocket.kingin.domain.Pd;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd_evo_pd")
public class PdEvoPd {
	@EmbeddedId
	private PdEvoPdId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdIdSta")
	@JoinColumn(name = "pd_id_sta")
	private Pd pdSta;
	
	@ManyToOne
	@MapsId("pdIdEnd")
	@JoinColumn(name = "pd_id_end")
	private Pd pdEnd;
		
	@ManyToOne
	@MapsId("evoCondId")
	@JoinColumn(name = "evo_cond_id")
	private EvoCond evoCond;
	
	@Column(name = "lv")
	private Long lv;

	public PdEvoPd() {}
	
	public PdEvoPd(PdEvoPdId id, Pd pdSta, Pd pdEnd, EvoCond evoCond, Long lv) {
		super();
		this.id = id;
		this.pdSta = pdSta;
		this.pdEnd = pdEnd;
		this.evoCond = evoCond;
		this.lv = lv;
	}

	public PdEvoPd(Pd pdSta, Pd pdEnd, EvoCond evoCond, Long lv) {
		super();
		this.id = new PdEvoPdId(pdSta.getPdId(), pdEnd.getPdId(), evoCond.getEvoCondId());
		this.pdSta = pdSta;
		this.pdEnd = pdEnd;
		this.evoCond = evoCond;
		this.lv = lv;
	}

	public PdEvoPdId getId() {
		return id;
	}

	public void setId(PdEvoPdId id) {
		this.id = id;
	}

	public Pd getPdSta() {
		return pdSta;
	}

	public void setPdSta(Pd pdSta) {
		this.pdSta = pdSta;
	}

	public Pd getPdEnd() {
		return pdEnd;
	}

	public void setPdEnd(Pd pdEnd) {
		this.pdEnd = pdEnd;
	}

	public EvoCond getEvoCond() {
		return evoCond;
	}

	public void setEvoCond(EvoCond evoCond) {
		this.evoCond = evoCond;
	}

	public Long getLv() {
		return lv;
	}

	public void setLv(Long lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "PdEvoPd [id=" + id + ", pdSta=" + pdSta + ", pdEnd=" + pdEnd + ", evoCond=" + evoCond + ", lv=" + lv
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(evoCond, id, lv, pdEnd, pdSta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdEvoPd other = (PdEvoPd) obj;
		return Objects.equals(evoCond, other.evoCond) && Objects.equals(id, other.id) && Objects.equals(lv, other.lv)
				&& Objects.equals(pdEnd, other.pdEnd) && Objects.equals(pdSta, other.pdSta);
	}
	
}
