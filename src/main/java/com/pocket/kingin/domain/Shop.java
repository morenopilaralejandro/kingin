package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

@Entity
@Table(name = "shop")
public class Shop implements InternatName {
	@Column(name = "shop_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long shopId;
	@Column(name = "shop_code", unique = true)
	private String shopCode;
	@Column(name = "shop_name_en")
	private String shopNameEn;
	@Column(name = "shop_name_ja")
	private String shopNameJa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
	private Zone zone;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curr_id", referencedColumnName = "curr_id")
	private Curr curr;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "shop_sell_item", joinColumns = @JoinColumn(name = "shop_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;
	
	@OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
	private List<ShopExchPd> shopExchPds;

	public Shop() {}
	
	public Shop(Long shopId, String shopCode, String shopNameEn, String shopNameJa, Zone zone, Curr curr) {
		super();
		this.shopId = shopId;
		this.shopCode = shopCode;
		this.shopNameEn = shopNameEn;
		this.shopNameJa = shopNameJa;
		this.zone = zone;
		this.curr = curr;
	}
	
	public String getHref(String lang) {
		String aux = "/" + lang + "/map/";
		if (this.zone.getZoneMain() == null) {
			aux += this.zone.getZoneCode();
		} else {
			aux += this.zone.getZoneMain().getZoneCode();
			aux += "#";
			aux += this.shopCode;
		}
		return aux;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.shopNameEn);
		map.put("ja", this.shopNameJa);
		return map;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopNameEn() {
		return shopNameEn;
	}

	public void setShopNameEn(String shopNameEn) {
		this.shopNameEn = shopNameEn;
	}

	public String getShopNameJa() {
		return shopNameJa;
	}

	public void setShopNameJa(String shopNameJa) {
		this.shopNameJa = shopNameJa;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Curr getCurr() {
		return curr;
	}

	public void setCurr(Curr curr) {
		this.curr = curr;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<ShopExchPd> getShopExchPds() {
		return shopExchPds;
	}

	public void setShopExchPds(List<ShopExchPd> shopExchPds) {
		this.shopExchPds = shopExchPds;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopCode=" + shopCode + ", shopNameEn=" + shopNameEn + ", shopNameJa="
				+ shopNameJa + ", zone=" + zone + ", curr=" + curr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(curr, shopCode, shopId, shopNameEn, shopNameJa, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(curr, other.curr) && Objects.equals(shopCode, other.shopCode)
				&& Objects.equals(shopId, other.shopId) && Objects.equals(shopNameEn, other.shopNameEn)
				&& Objects.equals(shopNameJa, other.shopNameJa) && Objects.equals(zone, other.zone);
	}

}
