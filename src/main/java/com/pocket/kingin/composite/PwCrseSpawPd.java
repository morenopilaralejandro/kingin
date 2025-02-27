package com.pocket.kingin.composite;

import java.util.Objects;

import com.pocket.kingin.domain.Pd;
import com.pocket.kingin.domain.PwCrse;
import com.pocket.kingin.domain.PwGrp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pw_crse_spaw_pd")
public class PwCrseSpawPd {
	@EmbeddedId
	private PwCrseSpawPdId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("pdId")
	@JoinColumn(name = "pd_id")
	private Pd pd;
	
	@ManyToOne
	@MapsId("pwCrseId")
	@JoinColumn(name = "pw_crse_id")
	private PwCrse pwCrse;
	
	@ManyToOne
	@MapsId("pwGrpId")
	@JoinColumn(name = "pw_grp_id")
	private PwGrp pwGrp;

	public PwCrseSpawPd() {}

	public PwCrseSpawPd(PwCrseSpawPdId id, Pd pd, PwCrse pwCrse, PwGrp pwGrp) {
		super();
		this.id = id;
		this.pd = pd;
		this.pwCrse = pwCrse;
		this.pwGrp = pwGrp;
	}
	
	public PwCrseSpawPd(Pd pd, PwCrse pwCrse, PwGrp pwGrp, Long step) {
		super();
		this.id = new PwCrseSpawPdId(pd.getPdId(), pwCrse.getPwCrseId(), pwGrp.getPwGrpId(), step);
		this.pd = pd;
		this.pwCrse = pwCrse;
		this.pwGrp = pwGrp;
	}

	public PwCrseSpawPdId getId() {
		return id;
	}

	public void setId(PwCrseSpawPdId id) {
		this.id = id;
	}

	public Pd getPd() {
		return pd;
	}

	public void setPd(Pd pd) {
		this.pd = pd;
	}

	public PwCrse getPwCrse() {
		return pwCrse;
	}

	public void setPwCrse(PwCrse pwCrse) {
		this.pwCrse = pwCrse;
	}

	public PwGrp getPwGrp() {
		return pwGrp;
	}

	public void setPwGrp(PwGrp pwGrp) {
		this.pwGrp = pwGrp;
	}

	@Override
	public String toString() {
		return "PwCrseSpawPd [id=" + id + ", pd=" + pd + ", pwCrse=" + pwCrse + ", pwGrp=" + pwGrp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pd, pwCrse, pwGrp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwCrseSpawPd other = (PwCrseSpawPd) obj;
		return Objects.equals(id, other.id) && Objects.equals(pd, other.pd) && Objects.equals(pwCrse, other.pwCrse)
				&& Objects.equals(pwGrp, other.pwGrp);
	}
	
}
