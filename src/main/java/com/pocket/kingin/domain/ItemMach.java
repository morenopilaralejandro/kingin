package com.pocket.kingin.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_mach")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "item_mach_id")
public class ItemMach extends Item {
	@Column(name = "item_mach_num")
	private Long itemMachNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_mach_obt_id", referencedColumnName = "item_mach_obt_id")
	private ItemMachObt itemMachObt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "move_id", referencedColumnName = "move_id")
	private Move move;

	public ItemMach() {}

	public ItemMach(Long itemMachNum, ItemMachObt itemMachObt, Move move) {
		super();
		this.itemMachNum = itemMachNum;
		this.itemMachObt = itemMachObt;
		this.move = move;
	}
	
	public ItemMach(Long itemId, String itemCode, String itemNameEn, String itemNameJa, String itemDescEn,
			String itemDescJa, Long itemPriceBuyYe, Long itemPriceSelYe, Long itemPriceBuyBp, Long itemPriceBuyCn,
			Long itemPriceBuyAp, Long itemFlin, ItemType itemType, ItemPkt itemPkt, ItemCat itemCat) {
		super(itemId, itemCode, itemNameEn, itemNameJa, itemDescEn, itemDescJa, itemPriceBuyYe, itemPriceSelYe, itemPriceBuyBp,
				itemPriceBuyCn, itemPriceBuyAp, itemFlin, itemType, itemPkt, itemCat);
	}
	
	@Override
	public String getTitle(String lang) {
		String title = "";
		title = this.move.getInternatName().get(lang);
		return title;
	}

	public Long getItemMachNum() {
		return itemMachNum;
	}

	public void setItemMachNum(Long itemMachNum) {
		this.itemMachNum = itemMachNum;
	}

	public ItemMachObt getItemMachObt() {
		return itemMachObt;
	}

	public void setItemMachObt(ItemMachObt itemMachObt) {
		this.itemMachObt = itemMachObt;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	@Override
	public String toString() {
		return "ItemMach [itemMachNum=" + itemMachNum + ", itemMachObt=" + itemMachObt + ", move=" + move + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(itemMachNum, itemMachObt, move);
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
		ItemMach other = (ItemMach) obj;
		return Objects.equals(itemMachNum, other.itemMachNum) && Objects.equals(itemMachObt, other.itemMachObt)
				&& Objects.equals(move, other.move);
	}

}
