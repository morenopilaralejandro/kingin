package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdDimoGndrId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "gndr_id")
	private Long gndrId;

	public PdDimoGndrId() {}

	public PdDimoGndrId(Long pdId, Long gndrId) {
		super();
		this.pdId = pdId;
		this.gndrId = gndrId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getGndrId() {
		return gndrId;
	}

	public void setGndrId(Long gndrId) {
		this.gndrId = gndrId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdDimoGndrId [pdId=" + pdId + ", gndrId=" + gndrId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gndrId, pdId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdDimoGndrId other = (PdDimoGndrId) obj;
		return Objects.equals(gndrId, other.gndrId) && Objects.equals(pdId, other.pdId);
	}
	
}
