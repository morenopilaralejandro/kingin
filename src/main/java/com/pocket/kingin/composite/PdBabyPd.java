package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.Pd;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd_baby_pd")
public class PdBabyPd {
	@EmbeddedId
	private PdBabyPdId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdIdPare")
	@JoinColumn(name = "pd_id_pare")
	private Pd pdPare;
	
	@ManyToOne
	@MapsId("pdIdBaby")
	@JoinColumn(name = "pd_id_baby")
	private Pd pdBaby;
	
	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;
	
	public PdBabyPd() {}

	public PdBabyPd(PdBabyPdId id, Pd pdPare, Pd pdBaby, Item item) {
		super();
		this.id = id;
		this.pdPare = pdPare;
		this.pdBaby = pdBaby;
		this.item = item;
	}
	
	public PdBabyPd(Pd pdPare, Pd pdBaby, Item item) {
		super();
		this.id = new PdBabyPdId(pdPare.getPdId(), pdPare.getPdId(), item.getItemId());
		this.pdPare = pdPare;
		this.pdBaby = pdBaby;
		this.item = item;
	}

	public PdBabyPdId getId() {
		return id;
	}

	public void setId(PdBabyPdId id) {
		this.id = id;
	}

	public Pd getPdPare() {
		return pdPare;
	}

	public void setPdPare(Pd pdPare) {
		this.pdPare = pdPare;
	}

	public Pd getPdBaby() {
		return pdBaby;
	}

	public void setPdBaby(Pd pdBaby) {
		this.pdBaby = pdBaby;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "PdBabyPd [id=" + id + ", pdPare=" + pdPare + ", pdBaby=" + pdBaby + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item, pdBaby, pdPare);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdBabyPd other = (PdBabyPd) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item) && Objects.equals(pdBaby, other.pdBaby)
				&& Objects.equals(pdPare, other.pdPare);
	}
	
}
