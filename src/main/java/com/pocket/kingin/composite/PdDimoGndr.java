package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Gndr;
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
@Table(name = "pd_dimo_gndr")
public class PdDimoGndr {
	@EmbeddedId
	private PdDimoGndrId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("gndrId")
	@JoinColumn(name = "gndr_id")
	private Gndr gndr;
	
	@Column(name = "rate")
	private Double rate;

	public PdDimoGndr() {}

	public PdDimoGndr(PdDimoGndrId id, Pd pd, Gndr gndr, Double rate) {
		super();
		this.id = id;
		this.pd = pd;
		this.gndr = gndr;
		this.rate = rate;
	}
	
	public PdDimoGndr(Pd pd, Gndr gndr, Double rate) {
		super();
		this.id = new PdDimoGndrId(pd.getPdId(), gndr.getGndrId());
		this.pd = pd;
		this.gndr = gndr;
		this.rate = rate;
	}

	public PdDimoGndrId getId() {
		return id;
	}

	public void setId(PdDimoGndrId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Gndr getGndr() {
		return gndr;
	}

	public void setGndr(Gndr gndr) {
		this.gndr = gndr;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "PdDimoGndr [id=" + id + ", pd=" + pd + ", gndr=" + gndr + ", rate=" + rate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gndr, id, pd, rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdDimoGndr other = (PdDimoGndr) obj;
		return Objects.equals(gndr, other.gndr) && Objects.equals(id, other.id) && Objects.equals(pd, other.pd)
				&& Objects.equals(rate, other.rate);
	}
	
}
