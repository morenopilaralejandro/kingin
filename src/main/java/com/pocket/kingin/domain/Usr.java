package com.pocket.kingin.domain;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr")
public class Usr {
	@Column(name = "usr_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long usrId;
	@Column(name = "usr_uuid", unique = true)
	private String usrUuid;
	@Column(name = "usr_name")
	private String usrName;
	@Column(name = "usr_pass")
	private String usrPass;
	@Column(name = "usr_mail")
	private String usrMail;	
	
	@OneToMany(mappedBy = "usr")
	private List<Fc> fcs;

	public Usr() {}

	public Usr(Long usrId, String usrUuid, String usrName, String usrPass, String usrMail) {
		super();
		this.usrId = usrId;
		this.usrUuid = usrUuid;
		this.usrName = usrName;
		this.usrPass = usrPass;
		this.usrMail = usrMail;
	}

	public Long getUsrId() {
		return usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrUuid() {
		return usrUuid;
	}

	public void setUsrUuid(String usrUuid) {
		this.usrUuid = usrUuid;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPass() {
		return usrPass;
	}

	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}

	public String getUsrMail() {
		return usrMail;
	}

	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}
	
	public List<Fc> getFcs() {
		return fcs;
	}

	public void setFcs(List<Fc> fcs) {
		this.fcs = fcs;
	}

	@Override
	public String toString() {
		return "Usr [usrId=" + usrId + ", usrUuid=" + usrUuid + ", usrName=" + usrName + ", usrPass=" + usrPass
				+ ", usrMail=" + usrMail + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(usrId, usrMail, usrName, usrPass, usrUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usr other = (Usr) obj;
		return Objects.equals(usrId, other.usrId) && Objects.equals(usrMail, other.usrMail)
				&& Objects.equals(usrName, other.usrName) && Objects.equals(usrPass, other.usrPass)
				&& Objects.equals(usrUuid, other.usrUuid);
	}
	
}
