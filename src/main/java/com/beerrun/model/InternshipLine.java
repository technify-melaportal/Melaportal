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
@Table(name="em_internshipline")
public class InternshipLine {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int intershiplineid;

	  @Column(name="intershipid", nullable=true)
	  private int intershipid;
	  
	  @Column(name="skills", nullable=true)
	  private String skills;
	  
	  @Column(name="importance", nullable=true)
	  private String importance;
	  
	  @Column(name="proficiency", nullable=true)
	  private String proficiency;
	  
	  @Column(name="status", nullable=true)
	  private int status;
	  
}
