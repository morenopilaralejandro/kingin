package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "npc")
public class Npc implements InternatName {
	@Column(name = "npc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long npcId;
	@Column(name = "npc_code", unique = true)
	private String npcCode;
	@Column(name = "npc_name_en")
	private String npcNameEn;
	@Column(name = "npc_name_ja")
	private String npcNameJa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "npc_title_id", referencedColumnName = "npc_title_id")
	private NpcTitle npcTitle;

	public Npc() {}
	
	public Npc(Long npcId, String npcCode, String npcNameEn, String npcNameJa, NpcTitle npcTitle) {
		super();
		this.npcId = npcId;
		this.npcCode = npcCode;
		this.npcNameEn = npcNameEn;
		this.npcNameJa = npcNameJa;
		this.npcTitle = npcTitle;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.npcNameEn);
		map.put("ja", this.npcNameJa);
		return map;
	}

	public Long getNpcId() {
		return npcId;
	}

	public void setNpcId(Long npcId) {
		this.npcId = npcId;
	}

	public String getNpcCode() {
		return npcCode;
	}

	public void setNpcCode(String npcCode) {
		this.npcCode = npcCode;
	}

	public String getNpcNameEn() {
		return npcNameEn;
	}

	public void setNpcNameEn(String npcNameEn) {
		this.npcNameEn = npcNameEn;
	}

	public String getNpcNameJa() {
		return npcNameJa;
	}

	public void setNpcNameJa(String npcNameJa) {
		this.npcNameJa = npcNameJa;
	}

	public NpcTitle getNpcTitle() {
		return npcTitle;
	}

	public void setNpcTitle(NpcTitle npcTitle) {
		this.npcTitle = npcTitle;
	}

	@Override
	public String toString() {
		return "Npc [npcId=" + npcId + ", npcCode=" + npcCode + ", npcNameEn=" + npcNameEn + ", npcNameJa=" + npcNameJa
				+ ", npcTitle=" + npcTitle + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(npcCode, npcId, npcNameEn, npcNameJa, npcTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Npc other = (Npc) obj;
		return Objects.equals(npcCode, other.npcCode) && Objects.equals(npcId, other.npcId)
				&& Objects.equals(npcNameEn, other.npcNameEn) && Objects.equals(npcNameJa, other.npcNameJa)
				&& Objects.equals(npcTitle, other.npcTitle);
	}

}
