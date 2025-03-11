package com.pocket.kingin.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.pocket.kingin.domain.Enc;
import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.SafBlk;
import com.pocket.kingin.domain.Zone;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "pd_spaw_saf")
public class PdSpawSaf {
	@EmbeddedId
	private PdSpawSafId id;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "saf_blk1_id", referencedColumnName = "saf_blk_id")
	private SafBlk safBlk1;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "saf_blk2_id", referencedColumnName = "saf_blk_id")
	private SafBlk safBlk2;
	
	@Column(name = "lv_max")
	private Long lvMax;
	
	@Column(name = "amount1")
	private Long amount1;
	
	@Column(name = "amount2")
	private Long amount2;
	
	@Column(name = "days")
	private Long days;
	
	@Transient
	private List<SafBlk> safBlks;
	
	@Transient
	private List<Long> amounts;

	public PdSpawSaf() {}

	public PdSpawSaf(PdSpawSafId id, Pd pd, Zone zone, Enc enc, SafBlk safBlk1, SafBlk safBlk2, Long lvMax,
			Long amount1, Long amount2, Long days) {
		super();
		this.id = id;
		this.pd = pd;
		this.zone = zone;
		this.enc = enc;
		this.safBlk1 = safBlk1;
		this.safBlk2 = safBlk2;
		this.lvMax = lvMax;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.days = days;
	}
	
	public PdSpawSaf(Pd pd, Zone zone, Enc enc, SafBlk safBlk1, SafBlk safBlk2, Long lvMin, Long lvMax,
			Long amount1, Long amount2, Long days) {
		super();
		this.id = new PdSpawSafId(pd.getPdId(), zone.getZoneId(), enc.getEncId(), lvMin);
		this.pd = pd;
		this.zone = zone;
		this.enc = enc;
		this.safBlk1 = safBlk1;
		this.safBlk2 = safBlk2;
		this.lvMax = lvMax;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.days = days;
		
		this.safBlks.add(safBlk1);
		this.safBlks.add(safBlk2);
		this.amounts.add(amount1);
		this.amounts.add(amount2);
	}

	public PdSpawSafId getId() {
		return id;
	}

	public void setId(PdSpawSafId id) {
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

	public SafBlk getSafBlk1() {
		return safBlk1;
	}

	public void setSafBlk1(SafBlk safBlk1) {
		this.safBlk1 = safBlk1;
	}

	public SafBlk getSafBlk2() {
		return safBlk2;
	}

	public void setSafBlk2(SafBlk safBlk2) {
		this.safBlk2 = safBlk2;
	}

	public Long getLvMax() {
		return lvMax;
	}

	public void setLvMax(Long lvMax) {
		this.lvMax = lvMax;
	}

	public Long getAmount1() {
		return amount1;
	}

	public void setAmount1(Long amount1) {
		this.amount1 = amount1;
	}

	public Long getAmount2() {
		return amount2;
	}

	public void setAmount2(Long amount2) {
		this.amount2 = amount2;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public List<SafBlk> getSafBlks() {
		this.safBlks = new ArrayList<SafBlk>();
		this.safBlks.add(safBlk1);
		if (safBlk2 != null) {
			this.safBlks.add(safBlk2);	
		}
		return safBlks;
	}

	public void setSafBlks(List<SafBlk> safBlks) {
		this.safBlks = safBlks;
	}

	public List<Long> getAmounts() {
		this.amounts = new ArrayList<Long>();
		this.amounts.add(amount1);
		if (safBlk2 != null) {
			this.amounts.add(amount2);
		}
		return amounts;
	}

	public void setAmounts(List<Long> amounts) {
		this.amounts = amounts;
	}

	@Override
	public String toString() {
		return "PdSpawSaf [id=" + id + ", pd=" + pd + ", zone=" + zone + ", enc=" + enc + ", safBlk1=" + safBlk1
				+ ", safBlk2=" + safBlk2 + ", lvMax=" + lvMax + ", amount1=" + amount1 + ", amount2=" + amount2
				+ ", days=" + days + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount1, amount2, days, enc, id, lvMax, pd, safBlk1, safBlk2, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdSpawSaf other = (PdSpawSaf) obj;
		return Objects.equals(amount1, other.amount1) && Objects.equals(amount2, other.amount2)
				&& Objects.equals(days, other.days) && Objects.equals(enc, other.enc) && Objects.equals(id, other.id)
				&& Objects.equals(lvMax, other.lvMax) && Objects.equals(pd, other.pd)
				&& Objects.equals(safBlk1, other.safBlk1) && Objects.equals(safBlk2, other.safBlk2)
				&& Objects.equals(zone, other.zone);
	}

}
