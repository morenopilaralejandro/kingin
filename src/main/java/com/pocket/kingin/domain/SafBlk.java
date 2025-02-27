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
@Table(name = "saf_blk")
public class SafBlk implements InternatName {
	@Column(name = "saf_blk_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long safBlkId;
	@Column(name = "saf_blk_code", unique = true)
	private String safBlkCode;
	@Column(name = "saf_blk_name_en")
	private String safBlkNameEn;
	@Column(name = "saf_blk_name_ja")
	private String safBlkNameJa;

	public SafBlk() {}
	
	public SafBlk(Long safBlkId, String safBlkCode, String safBlkNameEn, String safBlkNameJa) {
		super();
		this.safBlkId = safBlkId;
		this.safBlkCode = safBlkCode;
		this.safBlkNameEn = safBlkNameEn;
		this.safBlkNameJa = safBlkNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.safBlkNameEn);
		map.put("ja", this.safBlkNameJa);
		return map;
	}

	public Long getSafBlkId() {
		return safBlkId;
	}

	public void setSafBlkId(Long safBlkId) {
		this.safBlkId = safBlkId;
	}

	public String getSafBlkCode() {
		return safBlkCode;
	}

	public void setSafBlkCode(String safBlkCode) {
		this.safBlkCode = safBlkCode;
	}

	public String getSafBlkNameEn() {
		return safBlkNameEn;
	}

	public void setSafBlkNameEn(String safBlkNameEn) {
		this.safBlkNameEn = safBlkNameEn;
	}

	public String getSafBlkNameJa() {
		return safBlkNameJa;
	}

	public void setSafBlkNameJa(String safBlkNameJa) {
		this.safBlkNameJa = safBlkNameJa;
	}

	@Override
	public String toString() {
		return "SafBlk [safBlkId=" + safBlkId + ", safBlkCode=" + safBlkCode + ", safBlkNameEn=" + safBlkNameEn + ", safBlkNameJa="
				+ safBlkNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(safBlkCode, safBlkId, safBlkNameEn, safBlkNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SafBlk other = (SafBlk) obj;
		return Objects.equals(safBlkCode, other.safBlkCode) && Objects.equals(safBlkId, other.safBlkId)
				&& Objects.equals(safBlkNameEn, other.safBlkNameEn) && Objects.equals(safBlkNameJa, other.safBlkNameJa);
	}

}
