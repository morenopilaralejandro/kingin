package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.composite.ItemLocHgss;
import com.pocket.kingin.composite.PdSpawHgss;
import com.pocket.kingin.composite.PdSpawSaf;
import com.pocket.kingin.internat.InternatName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone")
public class Zone implements InternatName {
	@Column(name = "zone_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long zoneId;
	@Column(name = "zone_code", unique = true)
	private String zoneCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_name_id", referencedColumnName = "zone_name_id")
	private ZoneName zoneName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zone_main_id", referencedColumnName = "zone_id")
	private Zone zoneMain;
	
	@OneToMany(mappedBy = "zone", fetch = FetchType.LAZY)
	private List<Shop> shops;	
	
	@OneToMany(mappedBy = "zone", fetch = FetchType.LAZY)
	private List<PdSpawHgss> pdSpawHgss;
	
	@OneToMany(mappedBy = "zone", fetch = FetchType.LAZY)
	private List<ItemLocHgss> itemLocHgss;
	
	@OneToMany(mappedBy = "zone", fetch = FetchType.LAZY)
	private List<PdSpawSaf> pdSpawSaf;

	public Zone() {}
	
	public Zone(Long zoneId, String zoneCode, ZoneName zoneName, Zone zoneMain) {
		super();
		this.zoneId = zoneId;
		this.zoneCode = zoneCode;
		this.zoneName = zoneName;
		this.zoneMain = zoneMain;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.zoneName.getZoneNameEn());
		map.put("ja", this.zoneName.getZoneNameJa());
		return map;
	}

	public Map<String, String> getInternatNameCompound() {
		Map<String, String> map = new HashMap<String, String>();
		String auxEn = "";
		String auxJa = "";
		if (this.zoneMain == null) {
			auxEn = this.zoneName.getZoneNameEn();
			auxJa = this.zoneName.getZoneNameJa();
		} else {
			auxEn = this.zoneMain.getZoneName().getZoneNameEn() + " - " + this.zoneName.getZoneNameEn();
			auxJa = this.zoneMain.getZoneName().getZoneNameJa() + " - " + this.zoneName.getZoneNameJa();			
		}
		map.put("en", auxEn);
		map.put("ja", auxJa);
		return map;
	}
	
	public String getHref(String lang) {
		String aux = "/" + lang + "/map/";
		if (this.zoneMain == null) {
			aux += this.zoneCode;
		} else {
			aux += this.zoneMain.getZoneCode();
			aux += "#";
			aux += this.zoneCode;
		}
		return aux;
	}
	
	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public ZoneName getZoneName() {
		return zoneName;
	}

	public void setZoneName(ZoneName zoneName) {
		this.zoneName = zoneName;
	}

	public Zone getZoneMain() {
		return zoneMain;
	}

	public void setZoneMain(Zone zoneMain) {
		this.zoneMain = zoneMain;
	}

	public List<PdSpawHgss> getPdSpawHgss() {
		return pdSpawHgss;
	}
	
	public List<PdSpawHgss> getPdSpawHgssOrdered() {
		pdSpawHgss.sort((o1, o2)
                -> o1.getEnc().getEncId().compareTo(
                        o2.getEnc().getEncId()));
		return pdSpawHgss;
	}
	
	public int getPdSpawHgssColspan() {
		int colspan = 1;
		for (PdSpawHgss psh : pdSpawHgss) {
			if (psh.getRateD() != null || 
					psh.getRateN() != null) {
				colspan = 3;
			}
		}
		return colspan;
	}

	public void setPdSpawHgss(List<PdSpawHgss> pdSpawHgss) {
		this.pdSpawHgss = pdSpawHgss;
	}

	public List<ItemLocHgss> getItemLocHgss() {
		return itemLocHgss;
	}
	
	public List<ItemLocHgss> getItemLocHgssOrdered() {
		itemLocHgss.sort((o1, o2) -> o1.getItemObt().getItemObtId().compareTo(o2.getItemObt().getItemObtId()));
		return itemLocHgss;
	}

	public void setItemLocHgss(List<ItemLocHgss> itemLocHgss) {
		this.itemLocHgss = itemLocHgss;
	}

	public List<PdSpawSaf> getPdSpawSaf() {
		return pdSpawSaf;
	}

	public void setPdSpawSaf(List<PdSpawSaf> pdSpawSaf) {
		this.pdSpawSaf = pdSpawSaf;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", zoneCode=" + zoneCode + ", zoneName=" + zoneName + ", zoneMain=" + zoneMain
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(zoneCode, zoneId, zoneMain, zoneName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zone other = (Zone) obj;
		return Objects.equals(zoneCode, other.zoneCode) && Objects.equals(zoneId, other.zoneId)
				&& Objects.equals(zoneMain, other.zoneMain) && Objects.equals(zoneName, other.zoneName);
	}
	
}
