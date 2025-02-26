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
@Table(name = "item_type")
public class ItemType implements InternatName {
	@Column(name = "item_type_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemTypeId;
	@Column(name = "item_type_code", unique = true)
	private String itemTypeCode;
	@Column(name = "item_type_name_en")
	private String itemTypeNameEn;
	@Column(name = "item_type_name_ja")
	private String itemTypeNameJa;

	public ItemType() {}
	
	public ItemType(Long itemTypeId, String itemTypeCode, String itemTypeNameEn, String itemTypeNameJa) {
		super();
		this.itemTypeId = itemTypeId;
		this.itemTypeCode = itemTypeCode;
		this.itemTypeNameEn = itemTypeNameEn;
		this.itemTypeNameJa = itemTypeNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemTypeNameEn);
		map.put("ja", this.itemTypeNameJa);
		return map;
	}

	public Long getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(Long itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public String getItemTypeCode() {
		return itemTypeCode;
	}

	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}

	public String getItemTypeNameEn() {
		return itemTypeNameEn;
	}

	public void setItemTypeNameEn(String itemTypeNameEn) {
		this.itemTypeNameEn = itemTypeNameEn;
	}

	public String getItemTypeNameJa() {
		return itemTypeNameJa;
	}

	public void setItemTypeNameJa(String itemTypeNameJa) {
		this.itemTypeNameJa = itemTypeNameJa;
	}

	@Override
	public String toString() {
		return "ItemType [itemTypeId=" + itemTypeId + ", itemTypeCode=" + itemTypeCode + ", itemTypeNameEn=" + itemTypeNameEn + ", itemTypeNameJa="
				+ itemTypeNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemTypeCode, itemTypeId, itemTypeNameEn, itemTypeNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemType other = (ItemType) obj;
		return Objects.equals(itemTypeCode, other.itemTypeCode) && Objects.equals(itemTypeId, other.itemTypeId)
				&& Objects.equals(itemTypeNameEn, other.itemTypeNameEn) && Objects.equals(itemTypeNameJa, other.itemTypeNameJa);
	}

}
