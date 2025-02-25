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
@Table(name = "item_mach_obt")
public class ItemMachObt implements InternatName {
	@Column(name = "item_mach_obt_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemMachObtId;
	@Column(name = "item_mach_obt_code", unique = true)
	private String itemMachObtCode;
	@Column(name = "item_mach_obt_name_en")
	private String itemMachObtNameEn;
	@Column(name = "item_mach_obt_name_ja")
	private String itemMachObtNameJa;

	public ItemMachObt() {}
	
	public ItemMachObt(Long itemMachObtId, String itemMachObtCode, String itemMachObtNameEn, String itemMachObtNameJa) {
		super();
		this.itemMachObtId = itemMachObtId;
		this.itemMachObtCode = itemMachObtCode;
		this.itemMachObtNameEn = itemMachObtNameEn;
		this.itemMachObtNameJa = itemMachObtNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemMachObtNameEn);
		map.put("ja", this.itemMachObtNameJa);
		return map;
	}

	public Long getItemMachObtId() {
		return itemMachObtId;
	}

	public void setItemMachObtId(Long itemMachObtId) {
		this.itemMachObtId = itemMachObtId;
	}

	public String getItemMachObtCode() {
		return itemMachObtCode;
	}

	public void setItemMachObtCode(String itemMachObtCode) {
		this.itemMachObtCode = itemMachObtCode;
	}

	public String getItemMachObtNameEn() {
		return itemMachObtNameEn;
	}

	public void setItemMachObtNameEn(String itemMachObtNameEn) {
		this.itemMachObtNameEn = itemMachObtNameEn;
	}

	public String getItemMachObtNameJa() {
		return itemMachObtNameJa;
	}

	public void setItemMachObtNameJa(String itemMachObtNameJa) {
		this.itemMachObtNameJa = itemMachObtNameJa;
	}

	@Override
	public String toString() {
		return "ItemMachObt [itemMachObtId=" + itemMachObtId + ", itemMachObtCode=" + itemMachObtCode + ", itemMachObtNameEn=" + itemMachObtNameEn + ", itemMachObtNameJa="
				+ itemMachObtNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemMachObtCode, itemMachObtId, itemMachObtNameEn, itemMachObtNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMachObt other = (ItemMachObt) obj;
		return Objects.equals(itemMachObtCode, other.itemMachObtCode) && Objects.equals(itemMachObtId, other.itemMachObtId)
				&& Objects.equals(itemMachObtNameEn, other.itemMachObtNameEn) && Objects.equals(itemMachObtNameJa, other.itemMachObtNameJa);
	}

}
