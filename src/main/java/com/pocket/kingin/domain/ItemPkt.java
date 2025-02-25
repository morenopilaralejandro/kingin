package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_pkt")
public class ItemPkt implements InternatName {
	@Column(name = "item_pkt_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemPktId;
	@Column(name = "item_pkt_code", unique = true)
	private String itemPktCode;
	@Column(name = "item_pkt_name_en")
	private String itemPktNameEn;
	@Column(name = "item_pkt_name_ja")
	private String itemPktNameJa;

	public ItemPkt() {}
	
	public ItemPkt(Long itemPktId, String itemPktCode, String itemPktNameEn, String itemPktNameJa) {
		super();
		this.itemPktId = itemPktId;
		this.itemPktCode = itemPktCode;
		this.itemPktNameEn = itemPktNameEn;
		this.itemPktNameJa = itemPktNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemPktNameEn);
		map.put("ja", this.itemPktNameJa);
		return map;
	}

	public Long getItemPktId() {
		return itemPktId;
	}

	public void setItemPktId(Long itemPktId) {
		this.itemPktId = itemPktId;
	}

	public String getItemPktCode() {
		return itemPktCode;
	}

	public void setItemPktCode(String itemPktCode) {
		this.itemPktCode = itemPktCode;
	}

	public String getItemPktNameEn() {
		return itemPktNameEn;
	}

	public void setItemPktNameEn(String itemPktNameEn) {
		this.itemPktNameEn = itemPktNameEn;
	}

	public String getItemPktNameJa() {
		return itemPktNameJa;
	}

	public void setItemPktNameJa(String itemPktNameJa) {
		this.itemPktNameJa = itemPktNameJa;
	}

	@Override
	public String toString() {
		return "ItemPkt [itemPktId=" + itemPktId + ", itemPktCode=" + itemPktCode + ", itemPktNameEn=" + itemPktNameEn + ", itemPktNameJa="
				+ itemPktNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemPktCode, itemPktId, itemPktNameEn, itemPktNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPkt other = (ItemPkt) obj;
		return Objects.equals(itemPktCode, other.itemPktCode) && Objects.equals(itemPktId, other.itemPktId)
				&& Objects.equals(itemPktNameEn, other.itemPktNameEn) && Objects.equals(itemPktNameJa, other.itemPktNameJa);
	}

}
