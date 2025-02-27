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
@Table(name = "item_obt")
public class ItemObt implements InternatName {
	@Column(name = "item_obt_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long itemObtId;
	@Column(name = "item_obt_code", unique = true)
	private String itemObtCode;
	@Column(name = "item_obt_name_en")
	private String itemObtNameEn;
	@Column(name = "item_obt_name_ja")
	private String itemObtNameJa;

	public ItemObt() {}
	
	public ItemObt(Long itemObtId, String itemObtCode, String itemObtNameEn, String itemObtNameJa) {
		super();
		this.itemObtId = itemObtId;
		this.itemObtCode = itemObtCode;
		this.itemObtNameEn = itemObtNameEn;
		this.itemObtNameJa = itemObtNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.itemObtNameEn);
		map.put("ja", this.itemObtNameJa);
		return map;
	}

	public Long getItemObtId() {
		return itemObtId;
	}

	public void setItemObtId(Long itemObtId) {
		this.itemObtId = itemObtId;
	}

	public String getItemObtCode() {
		return itemObtCode;
	}

	public void setItemObtCode(String itemObtCode) {
		this.itemObtCode = itemObtCode;
	}

	public String getItemObtNameEn() {
		return itemObtNameEn;
	}

	public void setItemObtNameEn(String itemObtNameEn) {
		this.itemObtNameEn = itemObtNameEn;
	}

	public String getItemObtNameJa() {
		return itemObtNameJa;
	}

	public void setItemObtNameJa(String itemObtNameJa) {
		this.itemObtNameJa = itemObtNameJa;
	}

	@Override
	public String toString() {
		return "ItemObt [itemObtId=" + itemObtId + ", itemObtCode=" + itemObtCode + ", itemObtNameEn=" + itemObtNameEn + ", itemObtNameJa="
				+ itemObtNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemObtCode, itemObtId, itemObtNameEn, itemObtNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemObt other = (ItemObt) obj;
		return Objects.equals(itemObtCode, other.itemObtCode) && Objects.equals(itemObtId, other.itemObtId)
				&& Objects.equals(itemObtNameEn, other.itemObtNameEn) && Objects.equals(itemObtNameJa, other.itemObtNameJa);
	}

}
