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
@Table(name = "item_cat")
public class ItemCat implements InternatName {
	@Column(name = "item_cat_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemCatId;
	@Column(name = "item_cat_code", unique = true)
	private String itemCatCode;
	@Column(name = "item_cat_name_en")
	private String itemCatNameEn;
	@Column(name = "item_cat_name_ja")
	private String itemCatNameJa;

	public ItemCat() {}
	
	public ItemCat(Long itemCatId, String itemCatCode, String itemCatNameEn, String itemCatNameJa) {
		super();
		this.itemCatId = itemCatId;
		this.itemCatCode = itemCatCode;
		this.itemCatNameEn = itemCatNameEn;
		this.itemCatNameJa = itemCatNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemCatNameEn);
		map.put("ja", this.itemCatNameJa);
		return map;
	}

	public Long getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getItemCatCode() {
		return itemCatCode;
	}

	public void setItemCatCode(String itemCatCode) {
		this.itemCatCode = itemCatCode;
	}

	public String getItemCatNameEn() {
		return itemCatNameEn;
	}

	public void setItemCatNameEn(String itemCatNameEn) {
		this.itemCatNameEn = itemCatNameEn;
	}

	public String getItemCatNameJa() {
		return itemCatNameJa;
	}

	public void setItemCatNameJa(String itemCatNameJa) {
		this.itemCatNameJa = itemCatNameJa;
	}

	@Override
	public String toString() {
		return "ItemCat [itemCatId=" + itemCatId + ", itemCatCode=" + itemCatCode + ", itemCatNameEn=" + itemCatNameEn + ", itemCatNameJa="
				+ itemCatNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemCatCode, itemCatId, itemCatNameEn, itemCatNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCat other = (ItemCat) obj;
		return Objects.equals(itemCatCode, other.itemCatCode) && Objects.equals(itemCatId, other.itemCatId)
				&& Objects.equals(itemCatNameEn, other.itemCatNameEn) && Objects.equals(itemCatNameJa, other.itemCatNameJa);
	}

}
