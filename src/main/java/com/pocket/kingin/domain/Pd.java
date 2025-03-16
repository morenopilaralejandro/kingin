package com.pocket.kingin.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.composite.PdBabyPd;
import com.pocket.kingin.composite.PdDimoGndr;
import com.pocket.kingin.composite.PdEvoPd;
import com.pocket.kingin.composite.PdHoldItem;
import com.pocket.kingin.composite.PdLrnMove;
import com.pocket.kingin.composite.PdSpawHgss;
import com.pocket.kingin.composite.PdSpawSaf;
import com.pocket.kingin.composite.PdYielStat;
import com.pocket.kingin.composite.PwCrseSpawPd;
import com.pocket.kingin.composite.ShopExchPd;
import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

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
	@Transient
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
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PdYielStat> pdYielStats;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pd_tra_abil", joinColumns = @JoinColumn(name = "pd_id"), inverseJoinColumns = @JoinColumn(name = "abil_id"))
	private List<Abil> abils;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pd_belo_egg_grp", joinColumns = @JoinColumn(name = "pd_id"), inverseJoinColumns = @JoinColumn(name = "egg_grp_id"))
	private List<EggGrp> eggGrps;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pd_evok_type", joinColumns = @JoinColumn(name = "pd_id"), inverseJoinColumns = @JoinColumn(name = "type_id"))
	private List<Type> types;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PdHoldItem> pdHoldItem;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PdDimoGndr> pdDimoGndr;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pd_shif_pd", joinColumns = @JoinColumn(name = "pd_id_ori"), inverseJoinColumns = @JoinColumn(name = "pd_id_alt"))
	private List<Pd> alts;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pd_shif_pd", joinColumns = @JoinColumn(name = "pd_id_alt"), inverseJoinColumns = @JoinColumn(name = "pd_id_ori"))
	private List<Pd> oris;
	
	@OneToMany(mappedBy = "pdSta", fetch = FetchType.LAZY)
	private List<PdEvoPd> pdEvoPd;
	
	@OneToMany(mappedBy = "pdPare", fetch = FetchType.LAZY)
	private List<PdBabyPd> pdBabyPd;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PdLrnMove> pdLrnMove;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<ShopExchPd> shopExchPd;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PdSpawHgss> pdSpawHgss;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PdSpawSaf> pdSpawSaf;
	
	@OneToMany(mappedBy = "pd", fetch = FetchType.LAZY)
	private List<PwCrseSpawPd> pwCrseSpawPd;
	
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
	}

	public String getPdIndexFormat() {
		String auxStr = "";
		Long auxIndex = 0L;
		if (this.oris.isEmpty()) {
			auxIndex = this.pdIndex;
		} else {
			auxIndex = this.oris.get(0).getPdIndex();
		}
		auxStr = String.format("%03d", auxIndex);
		return auxStr;
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
		this.pdBaseArr = new ArrayList<Long>();
		this.pdBaseArr.add(pdBaseHp);
		this.pdBaseArr.add(pdBaseAtk);
		this.pdBaseArr.add(pdBaseDef);
		this.pdBaseArr.add(pdBaseSpatk);
		this.pdBaseArr.add(pdBaseSpdef);
		this.pdBaseArr.add(pdBaseSpe);
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

	public List<PdYielStat> getPdYielStats() {
		return pdYielStats;
	}

	public void setPdYielStats(List<PdYielStat> pdYielStats) {
		this.pdYielStats = pdYielStats;
	}

	public List<Abil> getAbils() {
		return abils;
	}

	public void setAbils(List<Abil> abils) {
		this.abils = abils;
	}

	public List<EggGrp> getEggGrps() {
		return eggGrps;
	}

	public void setEggGrps(List<EggGrp> eggGrps) {
		this.eggGrps = eggGrps;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public List<PdHoldItem> getPdHoldItem() {
		return pdHoldItem;
	}

	public void setPdHoldItem(List<PdHoldItem> pdHoldItem) {
		this.pdHoldItem = pdHoldItem;
	}

	public List<PdDimoGndr> getPdDimoGndr() {
		return pdDimoGndr;
	}

	public void setPdDimoGndr(List<PdDimoGndr> pdDimoGndr) {
		this.pdDimoGndr = pdDimoGndr;
	}

	public List<Pd> getAlts() {
		return alts;
	}

	public void setAlts(List<Pd> alts) {
		this.alts = alts;
	}

	public List<PdEvoPd> getPdEvoPd() {
		return pdEvoPd;
	}

	public void setPdEvoPd(List<PdEvoPd> pdEvoPd) {
		this.pdEvoPd = pdEvoPd;
	}

	public List<PdBabyPd> getPdBabyPd() {
		return pdBabyPd;
	}

	public void setPdBabyPd(List<PdBabyPd> pdBabyPd) {
		this.pdBabyPd = pdBabyPd;
	}

	public List<PdLrnMove> getPdLrnMove() {
		return pdLrnMove;
	}

	public void setPdLrnMove(List<PdLrnMove> pdLrnMove) {
		this.pdLrnMove = pdLrnMove;
	}

	public List<ShopExchPd> getShopExchPd() {
		return shopExchPd;
	}

	public void setShopExchPd(List<ShopExchPd> shopExchPd) {
		this.shopExchPd = shopExchPd;
	}

	public List<PdSpawHgss> getPdSpawHgss() {
		return pdSpawHgss;
	}

	public void setPdSpawHgss(List<PdSpawHgss> pdSpawHgss) {
		this.pdSpawHgss = pdSpawHgss;
	}

	public List<PdSpawSaf> getPdSpawSaf() {
		return pdSpawSaf;
	}

	public void setPdSpawSaf(List<PdSpawSaf> pdSpawSaf) {
		this.pdSpawSaf = pdSpawSaf;
	}

	public List<PwCrseSpawPd> getPwCrseSpawPd() {
		return pwCrseSpawPd;
	}

	public void setPwCrseSpawPd(List<PwCrseSpawPd> pwCrseSpawPd) {
		this.pwCrseSpawPd = pwCrseSpawPd;
	}

	public List<Pd> getOris() {
		return oris;
	}

	public void setOris(List<Pd> oris) {
		this.oris = oris;
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
