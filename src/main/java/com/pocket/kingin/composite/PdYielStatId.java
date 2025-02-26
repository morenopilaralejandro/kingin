package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdYielStatId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "stat_id")
	private Long statId;

	public PdYielStatId() {}

	public PdYielStatId(Long pdId, Long statId) {
		super();
		this.pdId = pdId;
		this.statId = statId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getStatId() {
		return statId;
	}

	public void setStatId(Long statId) {
		this.statId = statId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdYielStatId [pdId=" + pdId + ", statId=" + statId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pdId, statId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdYielStatId other = (PdYielStatId) obj;
		return Objects.equals(pdId, other.pdId) && Objects.equals(statId, other.statId);
	}
	
}
