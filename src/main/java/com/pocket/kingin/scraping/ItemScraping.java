package com.pocket.kingin.scraping;

public class ItemScraping {
	private String ItemCode;
	private String ItemImg;
	private String ItemNameEn;
	private String ItemNameJa;
	private String ItemDescEn;
	private String ItemDescJa;
	private String ItemPriceBuyYe;
	private String ItemPriceSelYe;
	private String ItemPriceBuyBp;
	private String ItemPriceBuyCn;
	private String ItemPriceBuyAp;
	private String ItemFlin;
	private String ItemTypeCode;
	private String ItemPktCode;
	private String ItemCatCode;
	
	public ItemScraping() {

	}
	
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public String getItemImg() {
		return ItemImg;
	}
	public void setItemImg(String itemImg) {
		ItemImg = itemImg;
	}
	public String getItemNameEn() {
		return ItemNameEn;
	}
	public void setItemNameEn(String itemNameEn) {
		ItemNameEn = itemNameEn;
	}
	public String getItemNameJa() {
		return ItemNameJa;
	}
	public void setItemNameJa(String itemNameJa) {
		ItemNameJa = itemNameJa;
	}
	public String getItemDescEn() {
		return ItemDescEn;
	}
	public void setItemDescEn(String itemDescEn) {
		ItemDescEn = itemDescEn;
	}
	public String getItemDescJa() {
		return ItemDescJa;
	}
	public void setItemDescJa(String itemDescJa) {
		ItemDescJa = itemDescJa;
	}
	public String getItemPriceBuyYe() {
		return ItemPriceBuyYe;
	}
	public void setItemPriceBuyYe(String itemPriceBuyYe) {
		ItemPriceBuyYe = itemPriceBuyYe;
	}
	public String getItemPriceSelYe() {
		return ItemPriceSelYe;
	}
	public void setItemPriceSelYe(String itemPriceSelYe) {
		ItemPriceSelYe = itemPriceSelYe;
	}
	public String getItemPriceBuyBp() {
		return ItemPriceBuyBp;
	}
	public void setItemPriceBuyBp(String itemPriceBuyBp) {
		ItemPriceBuyBp = itemPriceBuyBp;
	}
	public String getItemPriceBuyCn() {
		return ItemPriceBuyCn;
	}
	public void setItemPriceBuyCn(String itemPriceBuyCn) {
		ItemPriceBuyCn = itemPriceBuyCn;
	}
	public String getItemPriceBuyAp() {
		return ItemPriceBuyAp;
	}
	public void setItemPriceBuyAp(String itemPriceBuyAp) {
		ItemPriceBuyAp = itemPriceBuyAp;
	}
	public String getItemFlin() {
		return ItemFlin;
	}
	public void setItemFlin(String itemFlin) {
		ItemFlin = itemFlin;
	}
	public String getItemTypeCode() {
		return ItemTypeCode;
	}
	public void setItemTypeCode(String itemTypeCode) {
		ItemTypeCode = itemTypeCode;
	}
	public String getItemPktCode() {
		return ItemPktCode;
	}
	public void setItemPktCode(String itemPktCode) {
		ItemPktCode = itemPktCode;
	}
	public String getItemCatCode() {
		return ItemCatCode;
	}
	public void setItemCatCode(String itemCatCode) {
		ItemCatCode = itemCatCode;
	}
	
	@Override
	public String toString() {
		return "ItemScraper [ItemCode=" + ItemCode + ", ItemImg=" + ItemImg + ", ItemNameEn=" + ItemNameEn
				+ ", ItemNameJa=" + ItemNameJa + ", ItemDescEn=" + ItemDescEn + ", ItemDescJa=" + ItemDescJa
				+ ", ItemPriceBuyYe=" + ItemPriceBuyYe + ", ItemPriceSelYe=" + ItemPriceSelYe + ", ItemPriceBuyBp="
				+ ItemPriceBuyBp + ", ItemPriceBuyCn=" + ItemPriceBuyCn + ", ItemPriceBuyAp=" + ItemPriceBuyAp
				+ ", ItemFlin=" + ItemFlin + ", ItemTypeCode=" + ItemTypeCode + ", ItemPktCode=" + ItemPktCode
				+ ", ItemCatCode=" + ItemCatCode + "]";
	}
	
	public String toCsv() {
		return ItemCode + "," + ItemImg + "," + ItemNameEn
				+ "," + ItemNameJa + "," + "\"" +ItemDescEn + "\"" + "," + ItemDescJa
				+ "," + ItemPriceBuyYe + "," + ItemPriceSelYe + ","
				+ ItemPriceBuyBp + "," + ItemPriceBuyCn + "," + ItemPriceBuyAp
				+ "," + ItemFlin + "," + ItemTypeCode + "," + ItemPktCode
				+ "," + ItemCatCode;
	}
	
	
}
