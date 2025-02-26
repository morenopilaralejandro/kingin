package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Item;
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
@Table(name = "move_cause_eff")
public class PdHoldItem {
	@EmbeddedId
	private PdHoldItemId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(name = "rate")
	private Long rate;

	public PdHoldItem() {}

	public PdHoldItem(PdHoldItemId id, Pd pd, Item item, Long rate) {
		super();
		this.id = id;
		this.pd = pd;
		this.item = item;
		this.rate = rate;
	}
	
	public PdHoldItem(Long pdId, Long itemId, Pd pd, Item item, Long rate) {
		super();
		this.id = new PdHoldItemId(pdId, itemId);
		this.pd = pd;
		this.item = item;
		this.rate = rate;
	}
	
	public PdHoldItem(Pd pd, Item item, Long rate) {
		super();
		this.id = new PdHoldItemId(pd.getPdId(), item.getItemId());
		this.pd = pd;
		this.item = item;
		this.rate = rate;
	}

	public PdHoldItemId getId() {
		return id;
	}

	public void setId(PdHoldItemId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "PdHoldItem [id=" + id + ", pd=" + pd + ", item=" + item + ", rate=" + rate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item, pd, rate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdHoldItem other = (PdHoldItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item) && Objects.equals(pd, other.pd)
				&& Objects.equals(rate, other.rate);
	}
	
}
