package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdEvoPdId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id_sta")
	private Long pdIdSta;
	
	@Column(name = "pd_id_end")
	private Long pdIdEnd;
	
	@Column(name = "evo_cond_id")
	private Long evoCondId;

	public PdEvoPdId() {}

	public PdEvoPdId(Long pdIdSta, Long pdIdEnd, Long evoCondId) {
		super();
		this.pdIdSta = pdIdSta;
		this.pdIdEnd = pdIdEnd;
		this.evoCondId = evoCondId;
	}

	public Long getPdIdSta() {
		return pdIdSta;
	}

	public void setPdIdSta(Long pdIdSta) {
		this.pdIdSta = pdIdSta;
	}

	public Long getPdIdEnd() {
		return pdIdEnd;
	}

	public void setPdIdEnd(Long pdIdEnd) {
		this.pdIdEnd = pdIdEnd;
	}

	public Long getEvoCondId() {
		return evoCondId;
	}

	public void setEvoCondId(Long evoCondId) {
		this.evoCondId = evoCondId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdEvoPdId [pdIdSta=" + pdIdSta + ", pdIdEnd=" + pdIdEnd + ", evoCondId=" + evoCondId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(evoCondId, pdIdEnd, pdIdSta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdEvoPdId other = (PdEvoPdId) obj;
		return Objects.equals(evoCondId, other.evoCondId) && Objects.equals(pdIdEnd, other.pdIdEnd)
				&& Objects.equals(pdIdSta, other.pdIdSta);
	}
	
}
