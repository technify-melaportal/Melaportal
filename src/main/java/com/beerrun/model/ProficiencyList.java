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
@Table(name="am_proficiencydetails")
public class ProficiencyList {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int proficiencyid;

	  @Column(name="proficiencyname", nullable=true)
	  private String proficiencyname;
	  
	  @Column(name="status", nullable=true)
	  private int status;
}
