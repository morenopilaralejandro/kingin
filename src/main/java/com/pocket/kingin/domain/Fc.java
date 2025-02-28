package com.pocket.kingin.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fc")
public class Fc {
	@Column(name = "fc_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long fcId;
	@Column(name = "fc_code")
	private String fcCode;
	@Column(name = "fc_name")
	private String fcName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
	private Usr usr;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vrs_id", referencedColumnName = "vrs_id")
	private Vrs vrs;

	public Fc() {}

	public Fc(Long fcId, String fcCode, String fcName, Usr usr, Vrs vrs) {
		super();
		this.fcId = fcId;
		this.fcCode = fcCode;
		this.fcName = fcName;
		this.usr = usr;
		this.vrs = vrs;
	}

	public Long getFcId() {
		return fcId;
	}

	public void setFcId(Long fcId) {
		this.fcId = fcId;
	}

	public String getFcCode() {
		return fcCode;
	}

	public void setFcCode(String fcCode) {
		this.fcCode = fcCode;
	}

	public String getFcName() {
		return fcName;
	}

	public void setFcName(String fcName) {
		this.fcName = fcName;
	}

	public Usr getUsr() {
		return usr;
	}

	public void setUsr(Usr usr) {
		this.usr = usr;
	}

	public Vrs getVrs() {
		return vrs;
	}

	public void setVrs(Vrs vrs) {
		this.vrs = vrs;
	}

	@Override
	public String toString() {
		return "Fc [fcId=" + fcId + ", fcCode=" + fcCode + ", fcName=" + fcName + ", usr=" + usr + ", vrs=" + vrs + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fcCode, fcId, fcName, usr, vrs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fc other = (Fc) obj;
		return Objects.equals(fcCode, other.fcCode) && Objects.equals(fcId, other.fcId)
				&& Objects.equals(fcName, other.fcName) && Objects.equals(usr, other.usr)
				&& Objects.equals(vrs, other.vrs);
	}

}
