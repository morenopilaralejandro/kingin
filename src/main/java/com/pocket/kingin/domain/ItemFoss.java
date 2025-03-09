package com.pocket.kingin.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_foss")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_foss_id")
public class ItemFoss extends Item {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pd_id", referencedColumnName = "pd_id")
	private Pd pd;
	
	public ItemFoss() {}

	public ItemFoss(Pd pd) {
		super();
		this.pd = pd;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	@Override
	public String toString() {
		return "ItemFoss [pd=" + pd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pd);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemFoss other = (ItemFoss) obj;
		return Objects.equals(pd, other.pd);
	}

}
