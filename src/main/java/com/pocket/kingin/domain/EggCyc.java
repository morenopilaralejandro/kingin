package com.pocket.kingin.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "egg_cyc")
public class EggCyc {
	@Column(name = "egg_cyc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long eggCycId;
	@Column(name = "egg_cyc_code", unique = true)
	private String eggCycCode;
	@Column(name = "egg_cyc_val")
	private Long eggCycVal;
	
	public EggCyc() {}
	
	public EggCyc(Long eggCycId, String eggCycCode, Long eggCycVal) {
		super();
		this.eggCycId = eggCycId;
		this.eggCycCode = eggCycCode;
		this.eggCycVal = eggCycVal;
	}

	public Long getEggCycId() {
		return eggCycId;
	}

	public void setEggCycId(Long eggCycId) {
		this.eggCycId = eggCycId;
	}

	public String getEggCycCode() {
		return eggCycCode;
	}

	public void setEggCycCode(String eggCycCode) {
		this.eggCycCode = eggCycCode;
	}

	public Long getEggCycVal() {
		return eggCycVal;
	}

	public void setEggCycVal(Long eggCycVal) {
		this.eggCycVal = eggCycVal;
	}

	@Override
	public String toString() {
		return "EggCyc [eggCycId=" + eggCycId + ", eggCycCode=" + eggCycCode + ", eggCycVal=" + eggCycVal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(eggCycCode, eggCycId, eggCycVal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EggCyc other = (EggCyc) obj;
		return Objects.equals(eggCycCode, other.eggCycCode) && Objects.equals(eggCycId, other.eggCycId)
				&& Objects.equals(eggCycVal, other.eggCycVal);
	}

}
