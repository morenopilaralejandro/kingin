package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.GearCall;
import com.pocket.kingin.domain.Pd;

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
public class GearFougPd {
	@EmbeddedId
	private GearFougPdId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("gearCallId")
	@JoinColumn(name = "gear_call_id")
	private GearCall gearCall;
	
	@ManyToOne
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@Column(name = "lv")
	private Long lv;

	public GearFougPd() {}

	public GearFougPd(GearFougPdId id, GearCall gearCall, Pd pd, Long lv) {
		super();
		this.id = id;
		this.gearCall = gearCall;
		this.pd = pd;
		this.lv = lv;
	}
	
	public GearFougPd(GearCall gearCall, Pd pd, Long lv, Long ordr) {
		super();
		this.id = new GearFougPdId(gearCall.getGearCallId(), pd.getPdId(), ordr);
		this.gearCall = gearCall;
		this.pd = pd;
		this.lv = lv;
	}

	public GearFougPdId getId() {
		return id;
	}

	public void setId(GearFougPdId id) {
		this.id = id;
	}

	public GearCall getGearCall() {
		return gearCall;
	}

	public void setGearCall(GearCall gearCall) {
		this.gearCall = gearCall;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public Long getLv() {
		return lv;
	}

	public void setLv(Long lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "GearFougPd [id=" + id + ", gearCall=" + gearCall + ", pd=" + pd + ", lv=" + lv + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gearCall, id, lv, pd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GearFougPd other = (GearFougPd) obj;
		return Objects.equals(gearCall, other.gearCall) && Objects.equals(id, other.id) && Objects.equals(lv, other.lv)
				&& Objects.equals(pd, other.pd);
	}
	
}
