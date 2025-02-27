package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PwCrseSpawPdId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "pw_crse_id")
	private Long pwCrseId;
	
	@Column(name = "pw_grp_id")
	private Long pwGrpId;
	
	@Column(name = "step")
	private Long step;

	public PwCrseSpawPdId() {}

	public PwCrseSpawPdId(Long pdId, Long pwCrseId, Long pwGrpId, Long step) {
		super();
		this.pdId = pdId;
		this.pwCrseId = pwCrseId;
		this.pwGrpId = pwGrpId;
		this.step = step;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getPwCrseId() {
		return pwCrseId;
	}

	public void setPwCrseId(Long pwCrseId) {
		this.pwCrseId = pwCrseId;
	}

	public Long getPwGrpId() {
		return pwGrpId;
	}

	public void setPwGrpId(Long pwGrpId) {
		this.pwGrpId = pwGrpId;
	}

	public Long getStep() {
		return step;
	}

	public void setStep(Long step) {
		this.step = step;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PwCrseSpawPdId [pdId=" + pdId + ", pwCrseId=" + pwCrseId + ", pwGrpId=" + pwGrpId + ", step=" + step
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pdId, pwCrseId, pwGrpId, step);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwCrseSpawPdId other = (PwCrseSpawPdId) obj;
		return Objects.equals(pdId, other.pdId) && Objects.equals(pwCrseId, other.pwCrseId)
				&& Objects.equals(pwGrpId, other.pwGrpId) && Objects.equals(step, other.step);
	}
	
}
