package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.Shop;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "move_cause_eff")
public class ShopExchPd {
	@EmbeddedId
	private ShopExchPdId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("shopId")
	@JoinColumn(name = "shop_id")
	private Shop shop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pd_id", referencedColumnName = "pd_id")
	private Pd pd;
	
	@Column(name = "price")
	private Long price;

	public ShopExchPd() {}

	public ShopExchPd(ShopExchPdId id, Shop shop, Pd pd, Long price) {
		super();
		this.id = id;
		this.shop = shop;
		this.pd = pd;
		this.price = price;
	}
	
	public ShopExchPd(Shop shop, Pd pd, Long price) {
		super();
		this.id = new ShopExchPdId(shop.getShopId());
		this.shop = shop;
		this.pd = pd;
		this.price = price;
	}

	public ShopExchPdId getId() {
		return id;
	}

	public void setId(ShopExchPdId id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShopExchPd [id=" + id + ", shop=" + shop + ", pd=" + pd + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pd, price, shop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopExchPd other = (ShopExchPd) obj;
		return Objects.equals(id, other.id) && Objects.equals(pd, other.pd) && Objects.equals(price, other.price)
				&& Objects.equals(shop, other.shop);
	}
	
}
