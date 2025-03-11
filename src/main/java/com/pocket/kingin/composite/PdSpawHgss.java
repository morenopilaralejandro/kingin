package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Enc;
import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.Zone;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pd_spaw_hgss")
public class PdSpawHgss {
	@EmbeddedId
	private PdSpawHgssId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("zoneId")
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	@ManyToOne
	@MapsId("encId")
	@JoinColumn(name = "enc_id")
	private Enc enc;	
	
	@Column(name = "lv_max")
	private Long lvMax;
	
	@Column(name = "rate_m")
	private Long RateM;
	
	@Column(name = "rate_d")
	private Long RateD;
	
	@Column(name = "rate_n")
	private Long RateN;

	public PdSpawHgss() {}
	
	public PdSpawHgss(PdSpawHgssId id, Pd pd, Zone zone, Enc enc, Long lvMax, Long rateM, Long rateD, Long rateN) {
		super();
		this.id = id;
		this.pd = pd;
		this.zone = zone;
		this.enc = enc;
		this.lvMax = lvMax;
		RateM = rateM;
		RateD = rateD;
		RateN = rateN;
	}
	
	public PdSpawHgss(Pd pd, Zone zone, Enc enc, Boolean isHg, Boolean isSs, Long lvMin, Long lvMax, Long rateM, Long rateD, Long rateN) {
		super();
		this.id = new PdSpawHgssId(pd.getPdId(), zone.getZoneId(), enc.getEncId(), isHg, isSs, lvMin);
		this.pd = pd;
		this.zone = zone;
		this.enc = enc;
		this.lvMax = lvMax;
		RateM = rateM;
		RateD = rateD;
		RateN = rateN;
	}

	public PdSpawHgssId getId() {
		return id;
	}

	public void setId(PdSpawHgssId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Enc getEnc() {
		return enc;
	}

	public void setEnc(Enc enc) {
		this.enc = enc;
	}

	public Long getLvMax() {
		return lvMax;
	}

	public void setLvMax(Long lvMax) {
		this.lvMax = lvMax;
	}

	public Long getRateM() {
		return RateM;
	}

	public void setRateM(Long rateM) {
		RateM = rateM;
	}

	public Long getRateD() {
		return RateD;
	}

	public void setRateD(Long rateD) {
		RateD = rateD;
	}

	public Long getRateN() {
		return RateN;
	}

	public void setRateN(Long rateN) {
		RateN = rateN;
	}

	@Override
	public String toString() {
		return "PdSpawHgss [id=" + id + ", pd=" + pd + ", zone=" + zone + ", enc=" + enc + ", lvMax=" + lvMax
				+ ", RateM=" + RateM + ", RateD=" + RateD + ", RateN=" + RateN + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(RateD, RateM, RateN, enc, id, lvMax, pd, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdSpawHgss other = (PdSpawHgss) obj;
		return Objects.equals(RateD, other.RateD) && Objects.equals(RateM, other.RateM)
				&& Objects.equals(RateN, other.RateN) && Objects.equals(enc, other.enc) && Objects.equals(id, other.id)
				&& Objects.equals(lvMax, other.lvMax) && Objects.equals(pd, other.pd)
				&& Objects.equals(zone, other.zone);
	}

}
