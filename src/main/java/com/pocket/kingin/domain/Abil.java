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
	private Boolean abilIsRole;
	@Column(name = "abil_is_rece")
	private Boolean abilIsRece;
	@Column(name = "abil_is_entr")
	private Boolean abilIsEntr;
	@Column(name = "abil_is_trac")
	private Boolean abilIsTrac;
	@Column(name = "abil_is_sksw")
	private Boolean abilIsSksw;
	@Column(name = "abil_is_gast")
	private Boolean abilIsGast;
	@Column(name = "abil_is_mold")
	private Boolean abilIsMold;
	@Column(name = "abil_is_tran")
	private Boolean abilIsTran;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "abil_pass_eff", joinColumns = @JoinColumn(name = "abil_id"), inverseJoinColumns = @JoinColumn(name = "abil_eff_id"))
	private List<AbilEff> abilEffs;

	public Abil() {}

	public Abil(Long abilId, String abilCode, String abilNameEn, String abilNameJa, Boolean abilIsRole,
			Boolean abilIsRece, Boolean abilIsEntr, Boolean abilIsTrac, Boolean abilIsSksw, Boolean abilIsGast,
			Boolean abilIsMold, Boolean abilIsTran, List<AbilEff> abilEffs) {
		super();
		this.abilId = abilId;
		this.abilCode = abilCode;
		this.abilNameEn = abilNameEn;
		this.abilNameJa = abilNameJa;
		this.abilIsRole = abilIsRole;
		this.abilIsRece = abilIsRece;
		this.abilIsEntr = abilIsEntr;
		this.abilIsTrac = abilIsTrac;
		this.abilIsSksw = abilIsSksw;
		this.abilIsGast = abilIsGast;
		this.abilIsMold = abilIsMold;
		this.abilIsTran = abilIsTran;
		this.abilEffs = abilEffs;
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

	public Boolean getAbilIsRole() {
		return abilIsRole;
	}

	public void setAbilIsRole(Boolean abilIsRole) {
		this.abilIsRole = abilIsRole;
	}

	public Boolean getAbilIsRece() {
		return abilIsRece;
	}

	public void setAbilIsRece(Boolean abilIsRece) {
		this.abilIsRece = abilIsRece;
	}

	public Boolean getAbilIsEntr() {
		return abilIsEntr;
	}

	public void setAbilIsEntr(Boolean abilIsEntr) {
		this.abilIsEntr = abilIsEntr;
	}

	public Boolean getAbilIsTrac() {
		return abilIsTrac;
	}

	public void setAbilIsTrac(Boolean abilIsTrac) {
		this.abilIsTrac = abilIsTrac;
	}

	public Boolean getAbilIsSksw() {
		return abilIsSksw;
	}

	public void setAbilIsSksw(Boolean abilIsSksw) {
		this.abilIsSksw = abilIsSksw;
	}

	public Boolean getAbilIsGast() {
		return abilIsGast;
	}

	public void setAbilIsGast(Boolean abilIsGast) {
		this.abilIsGast = abilIsGast;
	}

	public Boolean getAbilIsMold() {
		return abilIsMold;
	}

	public void setAbilIsMold(Boolean abilIsMold) {
		this.abilIsMold = abilIsMold;
	}

	public Boolean getAbilIsTran() {
		return abilIsTran;
	}

	public void setAbilIsTran(Boolean abilIsTran) {
		this.abilIsTran = abilIsTran;
	}

	public List<AbilEff> getAbilEffs() {
		return abilEffs;
	}

	public void setAbilEffs(List<AbilEff> abilEffs) {
		this.abilEffs = abilEffs;
	}

	@Override
	public String toString() {
		return "Abil [abilId=" + abilId + ", abilCode=" + abilCode + ", abilNameEn=" + abilNameEn + ", abilNameJa="
				+ abilNameJa + ", abilIsRole=" + abilIsRole + ", abilIsRece=" + abilIsRece + ", abilIsEntr="
				+ abilIsEntr + ", abilIsTrac=" + abilIsTrac + ", abilIsSksw=" + abilIsSksw + ", abilIsGast="
				+ abilIsGast + ", abilIsMold=" + abilIsMold + ", abilIsTran=" + abilIsTran + ", abilEffs=" + abilEffs
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilCode, abilEffs, abilId, abilIsEntr, abilIsGast, abilIsMold, abilIsRece, abilIsRole,
				abilIsSksw, abilIsTrac, abilIsTran, abilNameEn, abilNameJa);
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
		return Objects.equals(abilCode, other.abilCode) && Objects.equals(abilEffs, other.abilEffs)
				&& Objects.equals(abilId, other.abilId) && Objects.equals(abilIsEntr, other.abilIsEntr)
				&& Objects.equals(abilIsGast, other.abilIsGast) && Objects.equals(abilIsMold, other.abilIsMold)
				&& Objects.equals(abilIsRece, other.abilIsRece) && Objects.equals(abilIsRole, other.abilIsRole)
				&& Objects.equals(abilIsSksw, other.abilIsSksw) && Objects.equals(abilIsTrac, other.abilIsTrac)
				&& Objects.equals(abilIsTran, other.abilIsTran) && Objects.equals(abilNameEn, other.abilNameEn)
				&& Objects.equals(abilNameJa, other.abilNameJa);
	}

}
