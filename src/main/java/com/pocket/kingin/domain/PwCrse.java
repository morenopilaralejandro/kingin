package com.pocket.kingin.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pocket.kingin.composite.PwCrseLocItem;
import com.pocket.kingin.composite.PwCrseSpawPd;
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
@Table(name = "pw_crse")
public class PwCrse implements InternatName {
	@Column(name = "pw_crse_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long pwCrseId;
	@Column(name = "pw_crse_code", unique = true)
	private String pwCrseCode;
	@Column(name = "pw_crse_name_en")
	private String pwCrseNameEn;
	@Column(name = "pw_crse_name_ja")
	private String pwCrseNameJa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pw_unlc_id", referencedColumnName = "pw_unlc_id")
	private PwUnlc pwUnlc;
	
	@OneToMany(mappedBy = "pwCrse", fetch = FetchType.LAZY)
	private List<PwCrseSpawPd> pwCrseSpawPd;
	
	@OneToMany(mappedBy = "pwCrse", fetch = FetchType.LAZY)
	private List<PwCrseLocItem> pwCrseLocItem;

	public PwCrse() {}
	
	public PwCrse(Long pwCrseId, String pwCrseCode, String pwCrseNameEn, String pwCrseNameJa, PwUnlc pwUnlc) {
		super();
		this.pwCrseId = pwCrseId;
		this.pwCrseCode = pwCrseCode;
		this.pwCrseNameEn = pwCrseNameEn;
		this.pwCrseNameJa = pwCrseNameJa;
		this.pwUnlc = pwUnlc;
	}

	@Override
	public Map<String, String> getInternatName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("en", this.pwCrseNameEn);
		map.put("ja", this.pwCrseNameJa);
		return map;
	}

	public Long getPwCrseId() {
		return pwCrseId;
	}

	public void setPwCrseId(Long pwCrseId) {
		this.pwCrseId = pwCrseId;
	}

	public String getPwCrseCode() {
		return pwCrseCode;
	}

	public void setPwCrseCode(String pwCrseCode) {
		this.pwCrseCode = pwCrseCode;
	}

	public String getPwCrseNameEn() {
		return pwCrseNameEn;
	}

	public void setPwCrseNameEn(String pwCrseNameEn) {
		this.pwCrseNameEn = pwCrseNameEn;
	}

	public String getPwCrseNameJa() {
		return pwCrseNameJa;
	}

	public void setPwCrseNameJa(String pwCrseNameJa) {
		this.pwCrseNameJa = pwCrseNameJa;
	}

	public PwUnlc getPwUnlc() {
		return pwUnlc;
	}

	public void setPwUnlc(PwUnlc pwUnlc) {
		this.pwUnlc = pwUnlc;
	}
	
	public List<PwCrseSpawPd> getPwCrseSpawPd() {
		return pwCrseSpawPd;
	}

	public void setPwCrseSpawPd(List<PwCrseSpawPd> pwCrseSpawPd) {
		this.pwCrseSpawPd = pwCrseSpawPd;
	}

	public List<PwCrseLocItem> getPwCrseLocItem() {
		return pwCrseLocItem;
	}

	public void setPwCrseLocItem(List<PwCrseLocItem> pwCrseLocItem) {
		this.pwCrseLocItem = pwCrseLocItem;
	}

	@Override
	public String toString() {
		return "PwCrse [pwCrseId=" + pwCrseId + ", pwCrseCode=" + pwCrseCode + ", pwCrseNameEn=" + pwCrseNameEn
				+ ", pwCrseNameJa=" + pwCrseNameJa + ", pwUnlc=" + pwUnlc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pwCrseCode, pwCrseId, pwCrseNameEn, pwCrseNameJa, pwUnlc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PwCrse other = (PwCrse) obj;
		return Objects.equals(pwCrseCode, other.pwCrseCode) && Objects.equals(pwCrseId, other.pwCrseId)
				&& Objects.equals(pwCrseNameEn, other.pwCrseNameEn) && Objects.equals(pwCrseNameJa, other.pwCrseNameJa)
				&& Objects.equals(pwUnlc, other.pwUnlc);
	}

}
