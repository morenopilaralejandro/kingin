package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Item;
import com.pocket.kingin.domain.ItemObt;
import com.pocket.kingin.domain.Zone;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_loc_hgss")
public class ItemLocHgss {
	@EmbeddedId
	private ItemLocHgssId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("itemId")
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne
	@MapsId("zoneId")
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	@ManyToOne
	@MapsId("itemObtId")
	@JoinColumn(name = "item_obt_id")
	private ItemObt itemObt;

	public ItemLocHgss() {}

	public ItemLocHgss(ItemLocHgssId id, Item item, Zone zone, ItemObt itemObt) {
		super();
		this.id = id;
		this.item = item;
		this.zone = zone;
		this.itemObt = itemObt;
	}
	
	public ItemLocHgss(Item item, Zone zone, ItemObt itemObt) {
		super();
		this.id = new ItemLocHgssId(item.getItemId(), zone.getZoneId(), itemObt.getItemObtId());
		this.item = item;
		this.zone = zone;
		this.itemObt = itemObt;
	}

	public ItemLocHgssId getId() {
		return id;
	}

	public void setId(ItemLocHgssId id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public ItemObt getItemObt() {
		return itemObt;
	}

	public void setItemObt(ItemObt itemObt) {
		this.itemObt = itemObt;
	}

	@Override
	public String toString() {
		return "ItemLocHgss [id=" + id + ", item=" + item + ", zone=" + zone + ", itemObt=" + itemObt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item, itemObt, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemLocHgss other = (ItemLocHgss) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item)
				&& Objects.equals(itemObt, other.itemObt) && Objects.equals(zone, other.zone);
	}
	
}
