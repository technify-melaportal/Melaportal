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
@Table(name="am_skillsdetails")
public class SkillList {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int skillid;

	  @Column(name="skillname", nullable=true)
	  private String skillname;
	  
	  @Column(name="status", nullable=true)
	  private int status;
	  
}
