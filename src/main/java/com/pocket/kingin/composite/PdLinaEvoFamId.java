package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdLinaEvoFamId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "evo_fam_id")
	private Long evoFamId;

	public PdLinaEvoFamId() {}

	public PdLinaEvoFamId(Long pdId, Long evoFamId) {
		super();
		this.pdId = pdId;
		this.evoFamId = evoFamId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getEvoFamId() {
		return evoFamId;
	}

	public void setEvoFamId(Long evoFamId) {
		this.evoFamId = evoFamId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdLinaEvoFamId [pdId=" + pdId + ", evoFamId=" + evoFamId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(evoFamId, pdId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdLinaEvoFamId other = (PdLinaEvoFamId) obj;
		return Objects.equals(evoFamId, other.evoFamId) && Objects.equals(pdId, other.pdId);
	}
	
}
