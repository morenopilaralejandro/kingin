package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatDesc;
import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@DiscriminatorColumn(name = "item_type_id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item implements InternatName, InternatDesc {
	@Column(name = "item_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemId;
	@Column(name = "item_code", unique = true)
	private String itemCode;
	@Column(name = "item_name_en")
	private String itemNameEn;
	@Column(name = "item_name_ja")
	private String itemNameJa;
	@Column(name = "item_desc_en")
	private String itemDescEn;
	@Column(name = "item_desc_ja")
	private String itemDescJa;
	@Column(name = "item_price_buy_ye")
	private Long itemPriceBuyYe;
	@Column(name = "item_price_sel_ye")
	private Long itemPriceSelYe;
	@Column(name = "item_price_buy_bp")
	private Long itemPriceBuyBp;
	@Column(name = "item_price_buy_cn")
	private Long itemPriceBuyCn;
	@Column(name = "item_price_buy_ap")
	private Long itemPriceBuyAp;
	@Column(name = "item_flin")
	private Long itemFlin;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_type_id", referencedColumnName = "item_type_id", insertable=false, updatable=false)
	private ItemType itemType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_pkt_id", referencedColumnName = "item_pkt_id")
	private ItemPkt itemPkt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_cat_id", referencedColumnName = "item_cat_id")
	private ItemCat itemCat;
	
	@ManyToMany(mappedBy = "items")
	private List<Shop> shops;

	public Item() {
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemNameEn);
		map.put("ja", this.itemNameJa);
		return map;
	}

	public Item(Long itemId, String itemCode, String itemNameEn, String itemNameJa, String itemDescEn,
			String itemDescJa, Long itemPriceBuyYe, Long itemPriceSelYe, Long itemPriceBuyBp, Long itemPriceBuyCn,
			Long itemPriceBuyAp, Long itemFlin, ItemType itemType, ItemPkt itemPkt, ItemCat itemCat) {
		super();
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemNameEn = itemNameEn;
		this.itemNameJa = itemNameJa;
		this.itemDescEn = itemDescEn;
		this.itemDescJa = itemDescJa;
		this.itemPriceBuyYe = itemPriceBuyYe;
		this.itemPriceSelYe = itemPriceSelYe;
		this.itemPriceBuyBp = itemPriceBuyBp;
		this.itemPriceBuyCn = itemPriceBuyCn;
		this.itemPriceBuyAp = itemPriceBuyAp;
		this.itemFlin = itemFlin;
		this.itemType = itemType;
		this.itemPkt = itemPkt;
		this.itemCat = itemCat;
	}

	@Override
	public Map<String, String> getInternatDesc() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemDescEn);
		map.put("ja", this.itemDescJa);
		return map;
	}

	public Long getPriceBuyByCurr(Curr curr) {
		switch (curr.getCurrCode()) {
		case "curr-ye": {
			return this.itemPriceBuyYe;
		}
		case "curr-bp": {
			return this.itemPriceBuyBp;
		}
		case "curr-cn": {
			return this.itemPriceBuyCn;
		}
		case "curr-ap": {
			return this.itemPriceBuyAp;
		}
		default:
			return null;
		}
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemNameEn() {
		return itemNameEn;
	}

	public void setItemNameEn(String itemNameEn) {
		this.itemNameEn = itemNameEn;
	}

	public String getItemNameJa() {
		return itemNameJa;
	}

	public void setItemNameJa(String itemNameJa) {
		this.itemNameJa = itemNameJa;
	}

	public String getItemDescEn() {
		return itemDescEn;
	}

	public void setItemDescEn(String itemDescEn) {
		this.itemDescEn = itemDescEn;
	}

	public String getItemDescJa() {
		return itemDescJa;
	}

	public void setItemDescJa(String itemDescJa) {
		this.itemDescJa = itemDescJa;
	}

	public Long getItemPriceBuyYe() {
		return itemPriceBuyYe;
	}

	public void setItemPriceBuyYe(Long itemPriceBuyYe) {
		this.itemPriceBuyYe = itemPriceBuyYe;
	}

	public Long getItemPriceSelYe() {
		return itemPriceSelYe;
	}

	public void setItemPriceSelYe(Long itemPriceSelYe) {
		this.itemPriceSelYe = itemPriceSelYe;
	}

	public Long getItemPriceBuyBp() {
		return itemPriceBuyBp;
	}

	public void setItemPriceBuyBp(Long itemPriceBuyBp) {
		this.itemPriceBuyBp = itemPriceBuyBp;
	}

	public Long getItemPriceBuyCn() {
		return itemPriceBuyCn;
	}

	public void setItemPriceBuyCn(Long itemPriceBuyCn) {
		this.itemPriceBuyCn = itemPriceBuyCn;
	}

	public Long getItemPriceBuyAp() {
		return itemPriceBuyAp;
	}

	public void setItemPriceBuyAp(Long itemPriceBuyAp) {
		this.itemPriceBuyAp = itemPriceBuyAp;
	}

	public Long getItemFlin() {
		return itemFlin;
	}

	public void setItemFlin(Long itemFlin) {
		this.itemFlin = itemFlin;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public ItemPkt getItemPkt() {
		return itemPkt;
	}

	public void setItemPkt(ItemPkt itemPkt) {
		this.itemPkt = itemPkt;
	}

	public ItemCat getItemCat() {
		return itemCat;
	}

	public void setItemCat(ItemCat itemCat) {
		this.itemCat = itemCat;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemNameEn=" + itemNameEn + ", itemNameJa="
				+ itemNameJa + ", itemDescEn=" + itemDescEn + ", itemDescJa=" + itemDescJa + ", itemPriceBuyYe="
				+ itemPriceBuyYe + ", itemPriceSelYe=" + itemPriceSelYe + ", itemPriceBuyBp=" + itemPriceBuyBp
				+ ", itemPriceBuyCn=" + itemPriceBuyCn + ", itemPriceBuyAp=" + itemPriceBuyAp + ", itemFlin=" + itemFlin
				+ ", itemType=" + itemType + ", itemPkt=" + itemPkt + ", itemCat=" + itemCat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemCat, itemCode, itemDescEn, itemDescJa, itemFlin, itemId, itemNameEn, itemNameJa,
				itemPkt, itemPriceBuyAp, itemPriceBuyBp, itemPriceBuyCn, itemPriceBuyYe, itemPriceSelYe, itemType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(itemCat, other.itemCat) && Objects.equals(itemCode, other.itemCode)
				&& Objects.equals(itemDescEn, other.itemDescEn) && Objects.equals(itemDescJa, other.itemDescJa)
				&& Objects.equals(itemFlin, other.itemFlin) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(itemNameEn, other.itemNameEn) && Objects.equals(itemNameJa, other.itemNameJa)
				&& Objects.equals(itemPkt, other.itemPkt) && Objects.equals(itemPriceBuyAp, other.itemPriceBuyAp)
				&& Objects.equals(itemPriceBuyBp, other.itemPriceBuyBp)
				&& Objects.equals(itemPriceBuyCn, other.itemPriceBuyCn)
				&& Objects.equals(itemPriceBuyYe, other.itemPriceBuyYe)
				&& Objects.equals(itemPriceSelYe, other.itemPriceSelYe) && Objects.equals(itemType, other.itemType);
	}

}
