package com.pocket.kingin.composite;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PdEvokTypeId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "pd_id")
	private Long pdId;
	
	@Column(name = "type_id")
	private Long typeId;

	public PdEvokTypeId() {}

	public PdEvokTypeId(Long pdId, Long typeId) {
		super();
		this.pdId = pdId;
		this.typeId = typeId;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PdEvokTypeId [pdId=" + pdId + ", typeId=" + typeId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pdId, typeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdEvokTypeId other = (PdEvokTypeId) obj;
		return Objects.equals(pdId, other.pdId) && Objects.equals(typeId, other.typeId);
	}
	
}
