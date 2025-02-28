package com.pocket.kingin.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	@Column(name = "team_id")
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long teamId;
	@Column(name = "team_uuid", unique = true)
	private String teamUuid;
	@Column(name = "team_date_crt")
	private Date teamDateCrt;
	@Column(name = "team_date_mod")
	private Date teamDateMod;
	@Column(name = "team_is_priv")
	private Boolean teamIsPriv;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
	private Usr usr;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "team_mem_po", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "po_id"))
	private List<Po> pos;

	public Team() {}

	public Team(Long teamId, String teamUuid, Date teamDateCrt, Date teamDateMod, Boolean teamIsPriv, Usr usr) {
		super();
		this.teamId = teamId;
		this.teamUuid = teamUuid;
		this.teamDateCrt = teamDateCrt;
		this.teamDateMod = teamDateMod;
		this.teamIsPriv = teamIsPriv;
		this.usr = usr;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamUuid() {
		return teamUuid;
	}

	public void setTeamUuid(String teamUuid) {
		this.teamUuid = teamUuid;
	}

	public Date getTeamDateCrt() {
		return teamDateCrt;
	}

	public void setTeamDateCrt(Date teamDateCrt) {
		this.teamDateCrt = teamDateCrt;
	}

	public Date getTeamDateMod() {
		return teamDateMod;
	}

	public void setTeamDateMod(Date teamDateMod) {
		this.teamDateMod = teamDateMod;
	}

	public Boolean getTeamIsPriv() {
		return teamIsPriv;
	}

	public void setTeamIsPriv(Boolean teamIsPriv) {
		this.teamIsPriv = teamIsPriv;
	}

	public Usr getUsr() {
		return usr;
	}

	public void setUsr(Usr usr) {
		this.usr = usr;
	}

	public List<Po> getPos() {
		return pos;
	}

	public void setPos(List<Po> pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamUuid=" + teamUuid + ", teamDateCrt=" + teamDateCrt + ", teamDateMod="
				+ teamDateMod + ", teamIsPriv=" + teamIsPriv + ", usr=" + usr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamDateCrt, teamDateMod, teamId, teamIsPriv, teamUuid, usr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(teamDateCrt, other.teamDateCrt) && Objects.equals(teamDateMod, other.teamDateMod)
				&& Objects.equals(teamId, other.teamId) && Objects.equals(teamIsPriv, other.teamIsPriv)
				&& Objects.equals(teamUuid, other.teamUuid) && Objects.equals(usr, other.usr);
	}

}
