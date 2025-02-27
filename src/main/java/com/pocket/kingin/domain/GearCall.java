package com.pocket.kingin.domain;

import java.util.List;
import java.util.Objects;

import com.pocket.kingin.composite.GearFougPd;

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
@Table(name = "gear_call")
public class GearCall {
	@Column(name = "gear_call_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long gearCallId;
	@Column(name = "gear_call_code", unique = true)
	private String gearCallCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gear_day_id", referencedColumnName = "gear_day_id")
	private GearDay gearDay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gear_time_id", referencedColumnName = "gear_time_id")
	private GearTime gearTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "npc_id", referencedColumnName = "npc_id")
	private Npc npc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
	private Zone zone;
	
	@Column(name = "money")
	private Long money;
	
	@OneToMany(mappedBy = "gearCall", fetch = FetchType.LAZY)
	private List<GearFougPd> gearFougPd;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "gear_gift_item", joinColumns = @JoinColumn(name = "gear_call_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;
	
	public GearCall() {}

	public GearCall(Long gearCallId, String gearCallCode, GearDay gearDay, GearTime gearTime, Npc npc, Zone zone,
			Long money) {
		super();
		this.gearCallId = gearCallId;
		this.gearCallCode = gearCallCode;
		this.gearDay = gearDay;
		this.gearTime = gearTime;
		this.npc = npc;
		this.zone = zone;
		this.money = money;
	}

	public Long getGearCallId() {
		return gearCallId;
	}

	public void setGearCallId(Long gearCallId) {
		this.gearCallId = gearCallId;
	}

	public String getGearCallCode() {
		return gearCallCode;
	}

	public void setGearCallCode(String gearCallCode) {
		this.gearCallCode = gearCallCode;
	}

	public GearDay getGearDay() {
		return gearDay;
	}

	public void setGearDay(GearDay gearDay) {
		this.gearDay = gearDay;
	}

	public GearTime getGearTime() {
		return gearTime;
	}

	public void setGearTime(GearTime gearTime) {
		this.gearTime = gearTime;
	}

	public Npc getNpc() {
		return npc;
	}

	public void setNpc(Npc npc) {
		this.npc = npc;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public List<GearFougPd> getGearFougPd() {
		return gearFougPd;
	}

	public void setGearFougPd(List<GearFougPd> gearFougPd) {
		this.gearFougPd = gearFougPd;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GearCall [gearCallId=" + gearCallId + ", gearCallCode=" + gearCallCode + ", gearDay=" + gearDay
				+ ", gearTime=" + gearTime + ", npc=" + npc + ", zone=" + zone + ", money=" + money + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gearCallCode, gearCallId, gearDay, gearTime, money, npc, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GearCall other = (GearCall) obj;
		return Objects.equals(gearCallCode, other.gearCallCode) && Objects.equals(gearCallId, other.gearCallId)
				&& Objects.equals(gearDay, other.gearDay) && Objects.equals(gearTime, other.gearTime)
				&& Objects.equals(money, other.money) && Objects.equals(npc, other.npc)
				&& Objects.equals(zone, other.zone);
	}
	
}
