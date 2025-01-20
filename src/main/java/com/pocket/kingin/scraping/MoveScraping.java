package com.pocket.kingin.scraping;

public class MoveScraping {
	private String pdCode;
	private String pdName;
	private String moveName;
	private String moveLrnCode;
	private String lv;
	public String getPdCode() {
		return pdCode;
	}
	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public String getMoveName() {
		return moveName;
	}
	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}
	public String getMoveLrnCode() {
		return moveLrnCode;
	}
	public void setMoveLrnCode(String moveLrnCode) {
		this.moveLrnCode = moveLrnCode;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	
	@Override
	public String toString() {
		return "MoveScraping [pdCode=" + pdCode + ", pdName=" + pdName + ", moveName=" + moveName + ", moveLrnCode="
				+ moveLrnCode + ", lv=" + lv + "]";
	}
	
	public String toCsv() {
		return pdCode + "," + pdName + "," + moveName + ","
				+ moveLrnCode + "," + lv;
	}
	
}
