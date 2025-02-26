package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.EvoFam;
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
@Table(name = "pd_lina_evo_fam")
public class PdLinaEvoFam {
	@EmbeddedId
	private PdLinaEvoFamId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("evoFamId")
	@JoinColumn(name = "evo_fam_id")
	private EvoFam evoFam;
	
	@Column(name = "ordr")
	private Long ordr;

	public PdLinaEvoFam() {}

	public PdLinaEvoFam(PdLinaEvoFamId id, Pd pd, EvoFam evoFam, Long ordr) {
		super();
		this.id = id;
		this.pd = pd;
		this.evoFam = evoFam;
		this.ordr = ordr;
	}
	
	public PdLinaEvoFam(Pd pd, EvoFam evoFam, Long ordr) {
		super();
		this.id = new PdLinaEvoFamId(pd.getPdId(), evoFam.getEvoFamId());
		this.pd = pd;
		this.evoFam = evoFam;
		this.ordr = ordr;
	}

	public PdLinaEvoFamId getId() {
		return id;
	}

	public void setId(PdLinaEvoFamId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public EvoFam getEvoFam() {
		return evoFam;
	}

	public void setEvoFam(EvoFam evoFam) {
		this.evoFam = evoFam;
	}

	public Long getOrdr() {
		return ordr;
	}

	public void setOrdr(Long ordr) {
		this.ordr = ordr;
	}

	@Override
	public String toString() {
		return "PdLinaEvoFam [id=" + id + ", pd=" + pd + ", evoFam=" + evoFam + ", ordr=" + ordr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(evoFam, id, ordr, pd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdLinaEvoFam other = (PdLinaEvoFam) obj;
		return Objects.equals(evoFam, other.evoFam) && Objects.equals(id, other.id) && Objects.equals(ordr, other.ordr)
				&& Objects.equals(pd, other.pd);
	}
	
}
