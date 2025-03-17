package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.Type;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd_evok_type")
public class PdEvokType {
	@EmbeddedId
	private PdEvokTypeId id;

	@ManyToOne
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("typeId")
	@JoinColumn(name = "type_id")
	private Type type;
	
	@Column(name = "ordr")
	private Long ordr;

	public PdEvokType() {}

	public PdEvokType(PdEvokTypeId id, Pd pd, Type type, Long ordr) {
		super();
		this.id = id;
		this.pd = pd;
		this.type = type;
		this.ordr = ordr;
	}
	
	public PdEvokType(Pd pd, Type type, Long ordr) {
		super();
		this.id = new PdEvokTypeId(pd.getPdId(), type.getTypeId());
		this.pd = pd;
		this.type = type;
		this.ordr = ordr;
	}

	public PdEvokTypeId getId() {
		return id;
	}

	public void setId(PdEvokTypeId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getOrdr() {
		return ordr;
	}

	public void setOrdr(Long ordr) {
		this.ordr = ordr;
	}

	@Override
	public String toString() {
		return "PdEvokType [id=" + id + ", pd=" + pd + ", type=" + type + ", ordr=" + ordr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ordr, pd, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdEvokType other = (PdEvokType) obj;
		return Objects.equals(id, other.id) && Objects.equals(ordr, other.ordr) && Objects.equals(pd, other.pd)
				&& Objects.equals(type, other.type);
	}
	
}
