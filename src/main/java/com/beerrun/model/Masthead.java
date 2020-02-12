package com.beerrun.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="am_companydetails")
public class Masthead implements Serializable{
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int companyid;

  @Column(name="name", nullable=true)
  private String name;
  
  @Column(name="shortname", nullable=true)
  private String shortname;
  
  @Column(name="url", nullable=true)
  private String url;
  
  @Column(name="linkedin", nullable=true)
  private String linkedin;
  
  @Column(name="description", nullable=true)
  private String description;
  
  @Column(name="address", nullable=true)
  private String address;
 
  @Column(name="city", nullable=true)
  private String city;
  
  @Column(name="state", nullable=true)
  private String state;
  
  @Column(name="pincode", nullable=true)
  private String pincode;
  
  @Column(name="ceoname", nullable=true)
  private String ceoname;
  
  @Column(name="ceolinkedin", nullable=true)
  private String ceolinkedin;
  
  @Column(name="cofoundername", nullable=true)
  private String cofoundername;
  
  @Column(name="cofounderlinkedin", nullable=true)
  private String cofounderlinkedin;
  
  @Column(name="businesscard1", nullable=true)
  private String businesscard1;
  
  @Column(name="businesscard2", nullable=true)
  private String businesscard2;
  
  @Column(name="companylogo", nullable=true)
  private String companylogo;
  
}
