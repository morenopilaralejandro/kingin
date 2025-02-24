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
@Table(name = "gndr")
public class Gndr implements InternatName {
	@Column(name = "gndr_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long gndrId;
	@Column(name = "gndr_code", unique = true)
	private String gndrCode;
	@Column(name = "gndr_name_en")
	private String gndrNameEn;
	@Column(name = "gndr_name_ja")
	private String gndrNameJa;
	@Column(name = "gndr_sym")
	private String gndrSym;

	public Gndr() {}

	public Gndr(Long gndrId, String gndrCode, String gndrNameEn, String gndrNameJa, String gndrSym) {
		super();
		this.gndrId = gndrId;
		this.gndrCode = gndrCode;
		this.gndrNameEn = gndrNameEn;
		this.gndrNameJa = gndrNameJa;
		this.gndrSym = gndrSym;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.gndrNameEn);
		map.put("ja", this.gndrNameJa);
		return map;
	}

	public Long getGndrId() {
		return gndrId;
	}

	public void setGndrId(Long gndrId) {
		this.gndrId = gndrId;
	}

	public String getGndrCode() {
		return gndrCode;
	}

	public void setGndrCode(String gndrCode) {
		this.gndrCode = gndrCode;
	}

	public String getGndrNameEn() {
		return gndrNameEn;
	}

	public void setGndrNameEn(String gndrNameEn) {
		this.gndrNameEn = gndrNameEn;
	}

	public String getGndrNameJa() {
		return gndrNameJa;
	}

	public void setGndrNameJa(String gndrNameJa) {
		this.gndrNameJa = gndrNameJa;
	}

	public String getGndrSym() {
		return gndrSym;
	}

	public void setGndrSym(String gndrSym) {
		this.gndrSym = gndrSym;
	}
	
	@Override
	public String toString() {
		return "Gndr [gndrId=" + gndrId + ", gndrCode=" + gndrCode + ", gndrNameEn=" + gndrNameEn + ", gndrNameJa="
				+ gndrNameJa + ", gndrSym=" + gndrSym + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gndrCode, gndrId, gndrNameEn, gndrNameJa, gndrSym);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gndr other = (Gndr) obj;
		return Objects.equals(gndrCode, other.gndrCode) && Objects.equals(gndrId, other.gndrId)
				&& Objects.equals(gndrNameEn, other.gndrNameEn) && Objects.equals(gndrNameJa, other.gndrNameJa)
				&& Objects.equals(gndrSym, other.gndrSym);
	}

}
