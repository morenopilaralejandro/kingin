package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "abil")
public class Abil implements InternatName {
	@Column(name = "abil_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long abilId;
	@Column(name = "abil_code", unique = true)
	private String abilCode;
	@Column(name = "abil_name_en")
	private String abilNameEn;
	@Column(name = "abil_name_ja")
	private String abilNameJa;
	@Column(name = "abil_is_role")
	private boolean Role;
	@Column(name = "abil_is_rece")
	private boolean Rece;
	@Column(name = "abil_is_entr")
	private boolean Entr;
	@Column(name = "abil_is_trac")
	private boolean Trac;
	@Column(name = "abil_is_sksw")
	private boolean Sksw;
	@Column(name = "abil_is_gast")
	private boolean Gast;
	@Column(name = "abil_is_mold")
	private boolean Mold;
	@Column(name = "abil_is_tran")
	private boolean Tran;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "abil_pass_eff", joinColumns = @JoinColumn(name = "abil_id"), inverseJoinColumns = @JoinColumn(name = "abil_eff_id"))
	private List<AbilEff> abilEffs;

	public Abil() {}

	public Abil(Long abilId, String abilCode, String abilNameEn, String abilNameJa, boolean role, boolean rece,
			boolean entr, boolean trac, boolean sksw, boolean gast, boolean mold, boolean tran) {
		super();
		this.abilId = abilId;
		this.abilCode = abilCode;
		this.abilNameEn = abilNameEn;
		this.abilNameJa = abilNameJa;
		Role = role;
		Rece = rece;
		Entr = entr;
		Trac = trac;
		Sksw = sksw;
		Gast = gast;
		Mold = mold;
		Tran = tran;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.abilNameEn);
		map.put("ja", this.abilNameJa);
		return map;
	}

	public Long getAbilId() {
		return abilId;
	}

	public void setAbilId(Long abilId) {
		this.abilId = abilId;
	}

	public String getAbilCode() {
		return abilCode;
	}

	public void setAbilCode(String abilCode) {
		this.abilCode = abilCode;
	}

	public String getAbilNameEn() {
		return abilNameEn;
	}

	public void setAbilNameEn(String abilNameEn) {
		this.abilNameEn = abilNameEn;
	}

	public String getAbilNameJa() {
		return abilNameJa;
	}

	public void setAbilNameJa(String abilNameJa) {
		this.abilNameJa = abilNameJa;
	}

	public boolean isRole() {
		return Role;
	}

	public void setRole(boolean role) {
		Role = role;
	}

	public boolean isRece() {
		return Rece;
	}

	public void setRece(boolean rece) {
		Rece = rece;
	}

	public boolean isEntr() {
		return Entr;
	}

	public void setEntr(boolean entr) {
		Entr = entr;
	}

	public boolean isTrac() {
		return Trac;
	}

	public void setTrac(boolean trac) {
		Trac = trac;
	}

	public boolean isSksw() {
		return Sksw;
	}

	public void setSksw(boolean sksw) {
		Sksw = sksw;
	}

	public boolean isGast() {
		return Gast;
	}

	public void setGast(boolean gast) {
		Gast = gast;
	}

	public boolean isMold() {
		return Mold;
	}

	public void setMold(boolean mold) {
		Mold = mold;
	}

	public boolean isTran() {
		return Tran;
	}

	public void setTran(boolean tran) {
		Tran = tran;
	}

	@Override
	public String toString() {
		return "Abil [abilId=" + abilId + ", abilCode=" + abilCode + ", abilNameEn=" + abilNameEn + ", abilNameJa="
				+ abilNameJa + ", Role=" + Role + ", Rece=" + Rece + ", Entr=" + Entr + ", Trac=" + Trac + ", Sksw="
				+ Sksw + ", Gast=" + Gast + ", Mold=" + Mold + ", Tran=" + Tran + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Entr, Gast, Mold, Rece, Role, Sksw, Trac, Tran, abilCode, abilId, abilNameEn, abilNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abil other = (Abil) obj;
		return Entr == other.Entr && Gast == other.Gast && Mold == other.Mold && Rece == other.Rece
				&& Role == other.Role && Sksw == other.Sksw && Trac == other.Trac && Tran == other.Tran
				&& Objects.equals(abilCode, other.abilCode) && Objects.equals(abilId, other.abilId)
				&& Objects.equals(abilNameEn, other.abilNameEn) && Objects.equals(abilNameJa, other.abilNameJa);
	}

}
