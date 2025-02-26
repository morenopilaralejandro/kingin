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
@Table(name = "evo_fam")
public class EvoFam implements InternatName {
	@Column(name = "evo_fam_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long evoFamId;
	@Column(name = "evo_fam_code", unique = true)
	private String evoFamCode;
	@Column(name = "evo_fam_name_en")
	private String evoFamNameEn;
	@Column(name = "evo_fam_name_ja")
	private String evoFamNameJa;

	public EvoFam() {}
	
	public EvoFam(Long evoFamId, String evoFamCode, String evoFamNameEn, String evoFamNameJa) {
		super();
		this.evoFamId = evoFamId;
		this.evoFamCode = evoFamCode;
		this.evoFamNameEn = evoFamNameEn;
		this.evoFamNameJa = evoFamNameJa;
	}
	
	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.evoFamNameEn);
		map.put("ja", this.evoFamNameJa);
		return map;
	}

	public Long getEvoFamId() {
		return evoFamId;
	}

	public void setEvoFamId(Long evoFamId) {
		this.evoFamId = evoFamId;
	}

	public String getEvoFamCode() {
		return evoFamCode;
	}

	public void setEvoFamCode(String evoFamCode) {
		this.evoFamCode = evoFamCode;
	}

	public String getEvoFamNameEn() {
		return evoFamNameEn;
	}

	public void setEvoFamNameEn(String evoFamNameEn) {
		this.evoFamNameEn = evoFamNameEn;
	}

	public String getEvoFamNameJa() {
		return evoFamNameJa;
	}

	public void setEvoFamNameJa(String evoFamNameJa) {
		this.evoFamNameJa = evoFamNameJa;
	}

	@Override
	public String toString() {
		return "EvoFam [evoFamId=" + evoFamId + ", evoFamCode=" + evoFamCode + ", evoFamNameEn=" + evoFamNameEn + ", evoFamNameJa="
				+ evoFamNameJa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(evoFamCode, evoFamId, evoFamNameEn, evoFamNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvoFam other = (EvoFam) obj;
		return Objects.equals(evoFamCode, other.evoFamCode) && Objects.equals(evoFamId, other.evoFamId)
				&& Objects.equals(evoFamNameEn, other.evoFamNameEn) && Objects.equals(evoFamNameJa, other.evoFamNameJa);
	}

}
