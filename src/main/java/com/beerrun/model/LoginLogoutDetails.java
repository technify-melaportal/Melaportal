package com.beerrun.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="am_loginlogoutdetails")
public class LoginLogoutDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="name", nullable=true)
	private String name;

	@Column(name="logintime", nullable=true)
	private String logintime;

	@Column(name="logouttime", nullable=true)
	private String logouttime;

	@Column(name="version", nullable=true)
	private String version;

	@Column(name="duration", nullable=true)
	private String duration;

	@Column(name="rowid", nullable=true)
	private String rowId;

	@Column(name="dateadded", nullable=true)
	private String dateadded;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlogintime() {
		return logintime;
	}

	public void setlogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getlogouttime() {
		return logouttime;
	}

	public void setlogouttime(String logouttime) {
		this.logouttime = logouttime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDateadded() {
		return dateadded;
	}

	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
