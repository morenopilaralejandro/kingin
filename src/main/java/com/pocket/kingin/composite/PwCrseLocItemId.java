package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PwCrseLocItemId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "item_id")
	private Long itemId;
	
	@Column(name = "pw_crse_id")
	private Long pwCrseId;
	
	@Column(name = "step")
	private Long step;

	public PwCrseLocItemId() {}

	public PwCrseLocItemId(Long itemId, Long pwCrseId, Long step) {
		super();
		this.itemId = itemId;
		this.pwCrseId = pwCrseId;
		this.step = step;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getPwCrseId() {
		return pwCrseId;
	}

	public void setPwCrseId(Long pwCrseId) {
		this.pwCrseId = pwCrseId;
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
		return "PwCrseLocItemId [itemId=" + itemId + ", pwCrseId=" + pwCrseId + ", step=" + step + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, pwCrseId, step);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwCrseLocItemId other = (PwCrseLocItemId) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(pwCrseId, other.pwCrseId)
				&& Objects.equals(step, other.step);
	}
	
}
