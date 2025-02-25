package com.pocket.kingin.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_foss")
@DiscriminatorValue("3")
public class ItemFoss extends Item {
	@Column(name = "item_foss_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemFossId;
	@ManyToOne(fetch = FetchType.LAZY)
	
	@JoinColumn(name = "pd_id", referencedColumnName = "pd_id")
	private Pd pd;
	
	public ItemFoss() {}
	
	public ItemFoss(Long itemFossId, Pd pd) {
		super();
		this.itemFossId = itemFossId;
		this.pd = pd;
	}

	public Long getItemFossId() {
		return itemFossId;
	}

	public void setItemFossId(Long itemFossId) {
		this.itemFossId = itemFossId;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	@Override
	public String toString() {
		return "ItemFoss [itemFossId=" + itemFossId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemFossId);
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
		return Objects.equals(itemFossId, other.itemFossId);
	}

}
