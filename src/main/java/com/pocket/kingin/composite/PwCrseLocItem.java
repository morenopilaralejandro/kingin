package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.PwCrse;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pw_crse_loc_item")
public class PwCrseLocItem {
	@EmbeddedId
	private PwCrseLocItemId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne
	@MapsId("pwCrseId")
	@JoinColumn(name = "pw_crse_id")
	private PwCrse pwCrse;

	public PwCrseLocItem() {}

	public PwCrseLocItem(PwCrseLocItemId id, Item item, PwCrse pwCrse) {
		super();
		this.id = id;
		this.item = item;
		this.pwCrse = pwCrse;
	}
	
	public PwCrseLocItem(Item item, PwCrse pwCrse, Long step) {
		super();
		this.id = new PwCrseLocItemId(item.getItemId(), pwCrse.getPwCrseId(), step);
		this.item = item;
		this.pwCrse = pwCrse;
	}

	public PwCrseLocItemId getId() {
		return id;
	}

	public void setId(PwCrseLocItemId id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public PwCrse getPwCrse() {
		return pwCrse;
	}

	public void setPwCrse(PwCrse pwCrse) {
		this.pwCrse = pwCrse;
	}

	@Override
	public String toString() {
		return "PwCrseLocItem [id=" + id + ", item=" + item + ", pwCrse=" + pwCrse + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item, pwCrse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwCrseLocItem other = (PwCrseLocItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item) && Objects.equals(pwCrse, other.pwCrse);
	}

}
