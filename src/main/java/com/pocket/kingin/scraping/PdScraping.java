package com.pocket.kingin.scraping;

public class PdScraping {
	private String pdCode;
	private String pdIndex;
	private String pdNameEn;
	private String pdNameJa;
	private String pdImg;
	private String pdCapRate;
	private String pdExp;
	private String pdHap;
	private String pdBaseHp;
	private String pdBaseAtk;
	private String pdBaseDef;
	private String pdBaseSpatk;
	private String pdBaseSpdef;
	private String pdBaseSpe;
	private String pdYielHp;
	private String pdYielAtk;
	private String pdYielDef;
	private String pdYielSpatk;
	private String pdYielSpdef;
	private String pdYielSpe;
	private String gndrMRate;
	private String gndrFRate;
	private String gndrNRate;
	private String eggCyc;
	private String expGrp;
	private String type1;
	private String type2;
	private String eggGrp1;
	private String eggGrp2;
	private String abil1;
	private String abil2;
	
	private String[] pdBase;
	private String[] pdYiel;
	
	public PdScraping() {
		this.pdBase = new String[6];
		this.pdYiel = new String[6];
	}
	public String getPdCode() {
		return pdCode;
	}
	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}
	public String getPdIndex() {
		return pdIndex;
	}
	public void setPdIndex(String pdIndex) {
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
	public String getPdCapRate() {
		return pdCapRate;
	}
	public void setPdCapRate(String pdCapRate) {
		this.pdCapRate = pdCapRate;
	}
	public String getPdExp() {
		return pdExp;
	}
	public void setPdExp(String pdExp) {
		this.pdExp = pdExp;
	}
	public String getPdHap() {
		return pdHap;
	}
	public void setPdHap(String pdHap) {
		this.pdHap = pdHap;
	}
	public String getPdBaseHp() {
		return pdBaseHp;
	}
	public void setPdBaseHp(String pdBaseHp) {
		this.pdBaseHp = pdBaseHp;
	}
	public String getPdBaseAtk() {
		return pdBaseAtk;
	}
	public void setPdBaseAtk(String pdBaseAtk) {
		this.pdBaseAtk = pdBaseAtk;
	}
	public String getPdBaseDef() {
		return pdBaseDef;
	}
	public void setPdBaseDef(String pdBaseDef) {
		this.pdBaseDef = pdBaseDef;
	}
	public String getPdBaseSpatk() {
		return pdBaseSpatk;
	}
	public void setPdBaseSpatk(String pdBaseSpatk) {
		this.pdBaseSpatk = pdBaseSpatk;
	}
	public String getPdBaseSpdef() {
		return pdBaseSpdef;
	}
	public void setPdBaseSpdef(String pdBaseSpdef) {
		this.pdBaseSpdef = pdBaseSpdef;
	}
	public String getPdBaseSpe() {
		return pdBaseSpe;
	}
	public void setPdBaseSpe(String pdBaseSpe) {
		this.pdBaseSpe = pdBaseSpe;
	}
	public String getPdYielHp() {
		return pdYielHp;
	}
	public void setPdYielHp(String pdYielHp) {
		this.pdYielHp = pdYielHp;
	}
	public String getPdYielAtk() {
		return pdYielAtk;
	}
	public void setPdYielAtk(String pdYielAtk) {
		this.pdYielAtk = pdYielAtk;
	}
	public String getPdYielDef() {
		return pdYielDef;
	}
	public void setPdYielDef(String pdYielDef) {
		this.pdYielDef = pdYielDef;
	}
	public String getPdYielSpatk() {
		return pdYielSpatk;
	}
	public void setPdYielSpatk(String pdYielSpatk) {
		this.pdYielSpatk = pdYielSpatk;
	}
	public String getPdYielSpdef() {
		return pdYielSpdef;
	}
	public void setPdYielSpdef(String pdYielSpdef) {
		this.pdYielSpdef = pdYielSpdef;
	}
	public String getPdYielSpe() {
		return pdYielSpe;
	}
	public void setPdYielSpe(String pdYielSpe) {
		this.pdYielSpe = pdYielSpe;
	}
	public String getGndrMRate() {
		return gndrMRate;
	}
	public void setGndrMRate(String gndrMRate) {
		this.gndrMRate = gndrMRate;
	}
	public String getGndrFRate() {
		return gndrFRate;
	}
	public void setGndrFRate(String gndrFRate) {
		this.gndrFRate = gndrFRate;
	}
	public String getGndrNRate() {
		return gndrNRate;
	}
	public void setGndrNRate(String gndrNRate) {
		this.gndrNRate = gndrNRate;
	}
	public String getEggCyc() {
		return eggCyc;
	}
	public void setEggCyc(String eggCyc) {
		this.eggCyc = eggCyc;
	}
	public String getExpGrp() {
		return expGrp;
	}
	public void setExpGrp(String expGrp) {
		this.expGrp = expGrp;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getEggGrp1() {
		return eggGrp1;
	}
	public void setEggGrp1(String eggGrp1) {
		this.eggGrp1 = eggGrp1;
	}
	public String getEggGrp2() {
		return eggGrp2;
	}
	public void setEggGrp2(String eggGrp2) {
		this.eggGrp2 = eggGrp2;
	}
	public String getAbil1() {
		return abil1;
	}
	public void setAbil1(String abil1) {
		this.abil1 = abil1;
	}
	public String getAbil2() {
		return abil2;
	}
	public void setAbil2(String abil2) {
		this.abil2 = abil2;
	}
	
	public String[] getPdBase() {
		return pdBase;
	}
	public void setPdBase(String[] pdBase) {
		this.pdBase = pdBase;
	}
	public String[] getPdYiel() {
		return pdYiel;
	}
	public void setPdYiel(String[] pdYiel) {
		this.pdYiel = pdYiel;
	}
	@Override
	public String toString() {
		return "PdScraping [pdCode=" + pdCode + ", pdIndex=" + pdIndex + ", pdNameEn=" + pdNameEn + ", pdNameJa="
				+ pdNameJa + ", pdImg=" + pdImg + ", pdCapRate=" + pdCapRate + ", pdXp=" + pdExp + ", pdHap=" + pdHap
				+ ", pdBaseHp=" + pdBaseHp + ", pdBaseAtk=" + pdBaseAtk + ", pdBaseDef=" + pdBaseDef + ", pdBaseSpatk="
				+ pdBaseSpatk + ", pdBaseSpdef=" + pdBaseSpdef + ", pdBaseSpe=" + pdBaseSpe + ", pdYielHp=" + pdYielHp
				+ ", pdYielAtk=" + pdYielAtk + ", pdYielDef=" + pdYielDef + ", pdYielSpatk=" + pdYielSpatk
				+ ", pdYielSpdef=" + pdYielSpdef + ", pdYielSpe=" + pdYielSpe + ", gndrMRate=" + gndrMRate
				+ ", gndrFRate=" + gndrFRate + ", gndrNRate=" + gndrNRate + ", eggCyc=" + eggCyc + ", expGrp=" + expGrp
				+ ", type1=" + type1 + ", type2=" + type2 + ", eggGrp1=" + eggGrp1 + ", eggGrp2=" + eggGrp2 + ", abil1="
				+ abil1 + ", abil2=" + abil2 + "]";
	}
	
	public String toCsv() {
		return pdCode + "," + pdIndex + "," + pdNameEn + ","
				+ pdNameJa + "," + pdImg + "," + pdCapRate + "," + pdExp + "," + pdHap
				+ "," + 
				
				this.pdBase[0] + "," + this.pdBase[1] + "," + this.pdBase[2] + ","
				+ this.pdBase[3] + "," + this.pdBase[4] + "," + this.pdBase[5] + "," 
				
				+ this.pdYiel[0] + "," + this.pdYiel[1] + "," + this.pdYiel[2] 
				+ "," + this.pdYiel[3]+ "," + this.pdYiel[4] + "," + this.pdYiel[5] 
				
				+ "," + gndrMRate
				+ "," + gndrFRate + "," + gndrNRate + "," + eggCyc + "," + expGrp
				+ "," + type1 + "," + type2 + "," + eggGrp1 + "," + eggGrp2 + ","
				+ abil1 + "," + abil2;
	}
	
}
