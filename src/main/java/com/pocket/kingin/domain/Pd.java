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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd")
public class Pd implements InternatName {
	@Column(name = "pd_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long pdId;
	@Column(name = "pd_code", unique = true)
	private String pdCode;
	@Column(name = "pd_index")
	private Long pdIndex;
	@Column(name = "pd_name_en")
	private String pdNameEn;
	@Column(name = "pd_name_ja")
	private String pdNameJa;
	@Column(name = "pd_img")
	private String pdImg;
	@Column(name = "pd_cap_rate")
	private Long pdCapRate;
	@Column(name = "pd_exp")
	private Long pdExp;
	@Column(name = "pd_hap")
	private Long pdHap;
	private List<Long> pdBaseArr;
	@Column(name = "pd_base_hp")
	private Long pdBaseHp;
	@Column(name = "pd_base_atk")
	private Long pdBaseAtk;
	@Column(name = "pd_base_def")
	private Long pdBaseDef;
	@Column(name = "pd_base_spatk")
	private Long pdBaseSpatk;
	@Column(name = "pd_base_spdef")
	private Long pdBaseSpdef;
	@Column(name = "pd_base_spe")
	private Long pdBaseSpe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "egg_cyc_id", referencedColumnName = "egg_cyc_id")
	private EggCyc eggCyc;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exp_grp_id", referencedColumnName = "exp_grp_id")
	private ExpGrp expGrp;
	
	public Pd() {}
	
	public Pd(Long pdId, String pdCode, Long pdIndex, String pdNameEn, String pdNameJa, String pdImg, Long pdCapRate,
			Long pdExp, Long pdHap, Long pdBaseHp, Long pdBaseAtk, Long pdBaseDef,
			Long pdBaseSpatk, Long pdBaseSpdef, Long pdBaseSpe, EggCyc eggCyc, ExpGrp expGrp) {
		super();
		this.pdId = pdId;
		this.pdCode = pdCode;
		this.pdIndex = pdIndex;
		this.pdNameEn = pdNameEn;
		this.pdNameJa = pdNameJa;
		this.pdImg = pdImg;
		this.pdCapRate = pdCapRate;
		this.pdExp = pdExp;
		this.pdHap = pdHap;
		this.pdBaseHp = pdBaseHp;
		this.pdBaseAtk = pdBaseAtk;
		this.pdBaseDef = pdBaseDef;
		this.pdBaseSpatk = pdBaseSpatk;
		this.pdBaseSpdef = pdBaseSpdef;
		this.pdBaseSpe = pdBaseSpe;
		this.eggCyc = eggCyc;
		this.expGrp = expGrp;
		
		this.pdBaseArr.add(pdBaseHp);
		this.pdBaseArr.add(pdBaseAtk);
		this.pdBaseArr.add(pdBaseDef);
		this.pdBaseArr.add(pdBaseSpatk);
		this.pdBaseArr.add(pdBaseSpdef);
		this.pdBaseArr.add(pdBaseSpe);
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.pdNameEn);
		map.put("ja", this.pdNameJa);
		return map;
	}

	public Long getPdId() {
		return pdId;
	}

	public void setPdId(Long pdId) {
		this.pdId = pdId;
	}

	public String getPdCode() {
		return pdCode;
	}

	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}

	public Long getPdIndex() {
		return pdIndex;
	}

	public void setPdIndex(Long pdIndex) {
		this.pdIndex = pdIndex;
	}

	public String getPdNameEn() {
		return pdNameEn;
	}

	public void setPdNameEn(String pdNameEn) {
		this.pdNameEn = pdNameEn;
	}

	public String getPdNameJa() {
		return pdNameJa;
	}

	public void setPdNameJa(String pdNameJa) {
		this.pdNameJa = pdNameJa;
	}

	public String getPdImg() {
		return pdImg;
	}

	public void setPdImg(String pdImg) {
		this.pdImg = pdImg;
	}

	public Long getPdCapRate() {
		return pdCapRate;
	}

	public void setPdCapRate(Long pdCapRate) {
		this.pdCapRate = pdCapRate;
	}

	public Long getPdExp() {
		return pdExp;
	}

	public void setPdExp(Long pdExp) {
		this.pdExp = pdExp;
	}

	public Long getPdHap() {
		return pdHap;
	}

	public void setPdHap(Long pdHap) {
		this.pdHap = pdHap;
	}

	public List<Long> getPdBaseArr() {
		return pdBaseArr;
	}

	public void setPdBaseArr(List<Long> pdBaseArr) {
		this.pdBaseArr = pdBaseArr;
	}

	public Long getPdBaseHp() {
		return pdBaseHp;
	}

	public void setPdBaseHp(Long pdBaseHp) {
		this.pdBaseHp = pdBaseHp;
	}

	public Long getPdBaseAtk() {
		return pdBaseAtk;
	}

	public void setPdBaseAtk(Long pdBaseAtk) {
		this.pdBaseAtk = pdBaseAtk;
	}

	public Long getPdBaseDef() {
		return pdBaseDef;
	}

	public void setPdBaseDef(Long pdBaseDef) {
		this.pdBaseDef = pdBaseDef;
	}

	public Long getPdBaseSpatk() {
		return pdBaseSpatk;
	}

	public void setPdBaseSpatk(Long pdBaseSpatk) {
		this.pdBaseSpatk = pdBaseSpatk;
	}

	public Long getPdBaseSpdef() {
		return pdBaseSpdef;
	}

	public void setPdBaseSpdef(Long pdBaseSpdef) {
		this.pdBaseSpdef = pdBaseSpdef;
	}

	public Long getPdBaseSpe() {
		return pdBaseSpe;
	}

	public void setPdBaseSpe(Long pdBaseSpe) {
		this.pdBaseSpe = pdBaseSpe;
	}

	public EggCyc getEggCyc() {
		return eggCyc;
	}

	public void setEggCyc(EggCyc eggCyc) {
		this.eggCyc = eggCyc;
	}

	public ExpGrp getExpGrp() {
		return expGrp;
	}

	public void setExpGrp(ExpGrp expGrp) {
		this.expGrp = expGrp;
	}

	@Override
	public String toString() {
		return "Pd [pdId=" + pdId + ", pdCode=" + pdCode + ", pdIndex=" + pdIndex + ", pdNameEn=" + pdNameEn
				+ ", pdNameJa=" + pdNameJa + ", pdImg=" + pdImg + ", pdCapRate=" + pdCapRate + ", pdExp=" + pdExp
				+ ", pdHap=" + pdHap + ", pdBaseArr=" + pdBaseArr + ", pdBaseHp=" + pdBaseHp + ", pdBaseAtk="
				+ pdBaseAtk + ", pdBaseDef=" + pdBaseDef + ", pdBaseSpatk=" + pdBaseSpatk + ", pdBaseSpdef="
				+ pdBaseSpdef + ", pdBaseSpe=" + pdBaseSpe + ", eggCyc=" + eggCyc + ", expGrp=" + expGrp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(eggCyc, expGrp, pdBaseArr, pdBaseAtk, pdBaseDef, pdBaseHp, pdBaseSpatk, pdBaseSpdef,
				pdBaseSpe, pdCapRate, pdCode, pdExp, pdHap, pdId, pdImg, pdIndex, pdNameEn, pdNameJa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pd other = (Pd) obj;
		return Objects.equals(eggCyc, other.eggCyc) && Objects.equals(expGrp, other.expGrp)
				&& Objects.equals(pdBaseArr, other.pdBaseArr) && Objects.equals(pdBaseAtk, other.pdBaseAtk)
				&& Objects.equals(pdBaseDef, other.pdBaseDef) && Objects.equals(pdBaseHp, other.pdBaseHp)
				&& Objects.equals(pdBaseSpatk, other.pdBaseSpatk) && Objects.equals(pdBaseSpdef, other.pdBaseSpdef)
				&& Objects.equals(pdBaseSpe, other.pdBaseSpe) && Objects.equals(pdCapRate, other.pdCapRate)
				&& Objects.equals(pdCode, other.pdCode) && Objects.equals(pdExp, other.pdExp)
				&& Objects.equals(pdHap, other.pdHap) && Objects.equals(pdId, other.pdId)
				&& Objects.equals(pdImg, other.pdImg) && Objects.equals(pdIndex, other.pdIndex)
				&& Objects.equals(pdNameEn, other.pdNameEn) && Objects.equals(pdNameJa, other.pdNameJa);
	}

}
