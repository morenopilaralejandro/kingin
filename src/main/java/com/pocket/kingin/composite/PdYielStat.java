package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.Stat;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd_yiel_stat")
public class PdYielStat {
	@EmbeddedId
	private PdYielStatId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("statId")
	@JoinColumn(name = "stat_id")
	private Stat stat;
	
	@Column(name = "amount")
	private Long amount;

	public PdYielStat() {}

	public PdYielStat(PdYielStatId id, Pd pd, Stat stat, Long amount) {
		super();
		this.id = id;
		this.pd = pd;
		this.stat = stat;
		this.amount = amount;
	}
	
	public PdYielStat(Long pdId, Long statId, Pd pd, Stat stat, Long amount) {
		super();
		this.id = new PdYielStatId(pdId, statId);
		this.pd = pd;
		this.stat = stat;
		this.amount = amount;
	}
	
	public PdYielStat(Pd pd, Stat stat, Long amount) {
		super();
		this.id = new PdYielStatId(pd.getPdId(), stat.getStatId());
		this.pd = pd;
		this.stat = stat;
		this.amount = amount;
	}

	public PdYielStatId getId() {
		return id;
	}

	public void setId(PdYielStatId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PdYielStat [id=" + id + ", pd=" + pd + ", stat=" + stat + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, pd, stat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdYielStat other = (PdYielStat) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(id, other.id) && Objects.equals(pd, other.pd)
				&& Objects.equals(stat, other.stat);
	}
	
}
