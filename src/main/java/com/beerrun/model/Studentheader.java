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
@Table(name="sm_studentheader")
public class Studentheader implements Serializable{
	
  
private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int studentid;

  @Column(name="studentname", nullable=true)
  private String studentName;
  
  @Column(name="collegeid", nullable=true)
  private Integer collegeId;
  
  @Column(name="collegename", nullable=true)
  private String collegeName;
  
  @Column(name="city", nullable=true)
  private String city;
  
  @Column(name="state", nullable=true)
  private String state;
  
  @Column(name="departmentname", nullable=true)
  private String departmentName;
  
  @Column(name="year", nullable=true)
  private Integer year;
  
  @Column(name="officialemailid", nullable=true)
  private String officialEmailId;
  
  @Column(name="emailusername", nullable=true)
  private String emailUserName;
  
  
  @Column(name="emailhostname", nullable=true)
  private String emailHostName;
  
  @Column(name="emailhostid", nullable=false)
  private Integer emailHostId;
  
  @Column(name="collegeshortnameid", nullable=false)
  private Integer collegeShortNameId;
  
  @Column(name="cityid", nullable=false)
  private Integer cityId;
  
  @Column(name="stateid", nullable=false)
  private Integer stateId;
  
  @Column(name="departmentid", nullable=false)
  private Integer departmentId;
  
  @Column(name="yearid", nullable=false)
  private Integer yearId;
  
  @Column(name="status",nullable=false)
  private Integer status;

  @Column(name="resume", nullable=true)
  private String resume;
 
 
  
}
