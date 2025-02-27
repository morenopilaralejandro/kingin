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
@Table(name = "npc_title")
public class NpcTitle implements InternatName {
	@Column(name = "npc_title_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long npcTitleId;
	@Column(name = "npc_title_code", unique = true)
	private String npcTitleCode;
	@Column(name = "npc_title_name_en")
	private String npcTitleNameEn;
	@Column(name = "npc_title_name_ja")
	private String npcTitleNameJa;

	public NpcTitle() {}
	
	public NpcTitle(Long npcTitleId, String npcTitleCode, String npcTitleNameEn, String npcTitleNameJa) {
		super();
		this.npcTitleId = npcTitleId;
		this.npcTitleCode = npcTitleCode;
		this.npcTitleNameEn = npcTitleNameEn;
		this.npcTitleNameJa = npcTitleNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.npcTitleNameEn);
		map.put("ja", this.npcTitleNameJa);
		return map;
	}

	public Long getNpcTitleId() {
		return npcTitleId;
	}

	public void setNpcTitleId(Long npcTitleId) {
		this.npcTitleId = npcTitleId;
	}

	public String getNpcTitleCode() {
		return npcTitleCode;
	}

	public void setNpcTitleCode(String npcTitleCode) {
		this.npcTitleCode = npcTitleCode;
	}

	public String getNpcTitleNameEn() {
		return npcTitleNameEn;
	}

	public void setNpcTitleNameEn(String npcTitleNameEn) {
		this.npcTitleNameEn = npcTitleNameEn;
	}

	public String getNpcTitleNameJa() {
		return npcTitleNameJa;
	}

	public void setNpcTitleNameJa(String npcTitleNameJa) {
		this.npcTitleNameJa = npcTitleNameJa;
	}

	@Override
	public String toString() {
		return "NpcTitle [npcTitleId=" + npcTitleId + ", npcTitleCode=" + npcTitleCode + ", npcTitleNameEn=" + npcTitleNameEn + ", npcTitleNameJa="
				+ npcTitleNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(npcTitleCode, npcTitleId, npcTitleNameEn, npcTitleNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NpcTitle other = (NpcTitle) obj;
		return Objects.equals(npcTitleCode, other.npcTitleCode) && Objects.equals(npcTitleId, other.npcTitleId)
				&& Objects.equals(npcTitleNameEn, other.npcTitleNameEn) && Objects.equals(npcTitleNameJa, other.npcTitleNameJa);
	}

}
