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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "natu")
public class Natu implements InternatName {
	@Column(name = "natu_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long natuId;
	@Column(name = "natu_code", unique = true)
	private String natuCode;
	@Column(name = "natu_name_en")
	private String natuNameEn;
	@Column(name = "natu_name_ja")
	private String natuNameJa;
	
	@ManyToOne
	@JoinColumn(name = "stat_id_red", referencedColumnName = "stat_id")
	private Stat statRed;
	
	@ManyToOne
	@JoinColumn(name = "stat_id_blue", referencedColumnName = "stat_id")
	private Stat statBlue;

	public Natu() {
	}
	
	public Natu(Long natuId, String natuCode, String natuNameEn, String natuNameJa, Stat statRed, Stat statBlue) {
		super();
		this.natuId = natuId;
		this.natuCode = natuCode;
		this.natuNameEn = natuNameEn;
		this.natuNameJa = natuNameJa;
		this.statRed = statRed;
		this.statBlue = statBlue;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.natuNameEn);
		map.put("ja", this.natuNameJa);
		return map;
	}

	public Long getNatuId() {
		return natuId;
	}

	public void setNatuId(Long natuId) {
		this.natuId = natuId;
	}

	public String getNatuCode() {
		return natuCode;
	}

	public void setNatuCode(String natuCode) {
		this.natuCode = natuCode;
	}

	public String getNatuNameEn() {
		return natuNameEn;
	}

	public void setNatuNameEn(String natuNameEn) {
		this.natuNameEn = natuNameEn;
	}

	public String getNatuNameJa() {
		return natuNameJa;
	}

	public void setNatuNameJa(String natuNameJa) {
		this.natuNameJa = natuNameJa;
	}

	public Stat getStatRed() {
		return statRed;
	}

	public void setStatRed(Stat statRed) {
		this.statRed = statRed;
	}

	public Stat getStatBlue() {
		return statBlue;
	}

	public void setStatBlue(Stat statBlue) {
		this.statBlue = statBlue;
	}

	@Override
	public String toString() {
		return "Natu [natuId=" + natuId + ", natuCode=" + natuCode + ", natuNameEn=" + natuNameEn + ", natuNameJa="
				+ natuNameJa + ", statRed=" + statRed + ", statBlue=" + statBlue + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(natuCode, natuId, natuNameEn, natuNameJa, statBlue, statRed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Natu other = (Natu) obj;
		return Objects.equals(natuCode, other.natuCode) && Objects.equals(natuId, other.natuId)
				&& Objects.equals(natuNameEn, other.natuNameEn) && Objects.equals(natuNameJa, other.natuNameJa)
				&& Objects.equals(statBlue, other.statBlue) && Objects.equals(statRed, other.statRed);
	}

}
