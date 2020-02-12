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
@Table(name="em_internshipheader")
public class InternshipHeader {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int internshipid;

	  @Column(name="companyid", nullable=true)
	  private int companyid;
	  
	  @Column(name="intershiptitle", nullable=true)
	  private String intershiptitle;
	  
	  @Column(name="intershipshortname", nullable=true)
	  private String intershipshortname;
	  
	  @Column(name="paid", nullable=true)
	  private String paid;
	  
	  @Column(name="positions", nullable=true)
	  private String positions;
	  
	  @Column(name="description", nullable=true)
	  private String description;
	  
	  @Column(name="noofviews", nullable=true)
	  private int noofviews;
	  
	  @Column(name="noofshortlisted", nullable=true)
	  private int noofshortlisted;
	  
	  @Column(name="noofapplied", nullable=true)
	  private int noofapplied;  

	  @Column(name="status", nullable=true)
	  private int status;
}
