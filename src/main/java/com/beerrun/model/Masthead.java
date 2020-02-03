package com.beerrun.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="am_companydetails")
public class Masthead implements Serializable{
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int companyid;

  @Column(name="companyname", nullable=true)
  private String companyName;
  
  @Column(name="add1", nullable=true)
  private String add1;
  
  @Column(name="add2", nullable=true)
  private String add2;
  
  @Column(name="city", nullable=true)
  private String city;
  
  @Column(name="state", nullable=true)
  private String state;
  
  @Column(name="country", nullable=true)
  private String country;
  
  @Column(name="zip", nullable=true)
  private String zip;
  
  @Column(name="phone", nullable=true)
  private String phone;
  
  @Column(name="fax", nullable=true)
  private String fax;
  
  @Column(name="website", nullable=true)
  private String website;
  
  @Column(name="email", nullable=true)
  private String email;
  
  @Column(name="logo", nullable=true)
  private String logo;
  
  @Column(name="dateadded", nullable=true)
  private String dateAdded;
  
  @Column(name="createdby", nullable=true)
  private String createdBy;
  
  @Column(name="licenseno", nullable=true)
  private String licenseNo;
  
  @Column(name="mastheadlogo", nullable=true)
  private String mastheadLogo;
  
  @Column(name="adminemails", nullable=true)
  private String adminEmails;
  
  @Column(name="refname", nullable=true)
  private String refName;
  
  @Column(name="type", nullable=true,columnDefinition=" enum('Company','Warehouse') DEFAULT NULL ")
  private String type;

  @Column(name="countryid", nullable=true)
  private Integer countryId;
  
  public int getCompanyid() {
		return companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
public String getCompanyName() {
	return companyName;
}



public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getAdd1() {
	return add1;
}

public void setAdd1(String add1) {
	this.add1 = add1;
}

public String getAdd2() {
	return add2;
}

public void setAdd2(String add2) {
	this.add2 = add2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getFax() {
	return fax;
}

public void setFax(String fax) {
	this.fax = fax;
}

public String getWebsite() {
	return website;
}

public void setWebsite(String website) {
	this.website = website;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLogo() {
	return logo;
}

public void setLogo(String logo) {
	this.logo = logo;
}

public String getDateAdded() {
	return dateAdded;
}

public void setDateAdded(String dateAdded) {
	this.dateAdded = dateAdded;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getLicenseNo() {
	return licenseNo;
}

public void setLicenseNo(String licenseNo) {
	this.licenseNo = licenseNo;
}

public String getMastheadLogo() {
	return mastheadLogo;
}

public void setMastheadLogo(String mastheadLogo) {
	this.mastheadLogo = mastheadLogo;
}

public String getAdminEmails() {
	return adminEmails;
}

public void setAdminEmails(String adminEmails) {
	this.adminEmails = adminEmails;
}

public String getRefName() {
	return refName;
}

public void setRefName(String refName) {
	this.refName = refName;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Integer getCountryId() {
	return countryId;
}

public void setCountryId(Integer countryId) {
	this.countryId = countryId;
}
  
  
}
