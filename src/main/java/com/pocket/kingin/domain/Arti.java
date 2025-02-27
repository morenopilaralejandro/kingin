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
@Table(name = "arti")
public class Arti implements InternatName {
	@Column(name = "arti_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long artiId;
	@Column(name = "arti_code", unique = true)
	private String artiCode;
	@Column(name = "arti_name_en")
	private String artiNameEn;
	@Column(name = "arti_name_ja")
	private String artiNameJa;
	@Column(name = "arti_view")
	private Long artiView;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "arti_type_id", referencedColumnName = "arti_type_id")
	private ArtiType artiType;

	public Arti() {}
	
	public Arti(Long artiId, String artiCode, String artiNameEn, String artiNameJa, Long artiView, ArtiType artiType) {
		super();
		this.artiId = artiId;
		this.artiCode = artiCode;
		this.artiNameEn = artiNameEn;
		this.artiNameJa = artiNameJa;
		this.artiView = artiView;
		this.artiType = artiType;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.artiNameEn);
		map.put("ja", this.artiNameJa);
		return map;
	}

	public Long getArtiId() {
		return artiId;
	}

	public void setArtiId(Long artiId) {
		this.artiId = artiId;
	}

	public String getArtiCode() {
		return artiCode;
	}

	public void setArtiCode(String artiCode) {
		this.artiCode = artiCode;
	}

	public String getArtiNameEn() {
		return artiNameEn;
	}

	public void setArtiNameEn(String artiNameEn) {
		this.artiNameEn = artiNameEn;
	}

	public String getArtiNameJa() {
		return artiNameJa;
	}

	public void setArtiNameJa(String artiNameJa) {
		this.artiNameJa = artiNameJa;
	}

	public Long getArtiView() {
		return artiView;
	}

	public void setArtiView(Long artiView) {
		this.artiView = artiView;
	}

	public ArtiType getArtiType() {
		return artiType;
	}

	public void setArtiType(ArtiType artiType) {
		this.artiType = artiType;
	}

	@Override
	public String toString() {
		return "Arti [artiId=" + artiId + ", artiCode=" + artiCode + ", artiNameEn=" + artiNameEn + ", artiNameJa="
				+ artiNameJa + ", artiView=" + artiView + ", artiType=" + artiType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(artiCode, artiId, artiNameEn, artiNameJa, artiType, artiView);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arti other = (Arti) obj;
		return Objects.equals(artiCode, other.artiCode) && Objects.equals(artiId, other.artiId)
				&& Objects.equals(artiNameEn, other.artiNameEn) && Objects.equals(artiNameJa, other.artiNameJa)
				&& Objects.equals(artiType, other.artiType) && Objects.equals(artiView, other.artiView);
	}

}
