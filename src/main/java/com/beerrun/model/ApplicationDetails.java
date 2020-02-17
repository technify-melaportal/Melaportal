package com.beerrun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="em_applicationdetails")
public class ApplicationDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;

	  @Column(name="companyid", nullable=true)
	  private int companyid;
	  
	  @Column(name="companyname", nullable=true)
	  private String companyname;
	  
	  @Column(name="studentid", nullable=true)
	  private int studentid;
	  
	  @Column(name="studentname", nullable=true)
	  private String studentname;
	  
	  @Column(name="collegeid", nullable=true)
	  private int collegeid;
	  
	  @Column(name="collegename", nullable=true)
	  private String collegename;
	  
	  @Column(name="year", nullable=true)
	  private String year;
	  
	  @Column(name="department", nullable=true)
	  private String department;
	  
	  @Column(name="intershipid", nullable=true)
	  private Integer intershipid;
	  
	  @Column(name="intershipname", nullable=true)
	  private String intershipname;
	  
	  @Column(name="status", nullable=true)
	  private int status;
	  
	  @Column(name="schduletime", nullable=true)
	  private String schduletime;
	  	  
	  @Column(name="rejectreason", nullable=true)
	  private String rejectreason;
	  
	  @Column(name="resume", nullable=true)
	  private String resume;

}
