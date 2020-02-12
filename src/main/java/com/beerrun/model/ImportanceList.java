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
@Table(name="am_importancedetails")
public class ImportanceList {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int importanceid;

	  @Column(name="importancename", nullable=true)
	  private String importancename;
	  
	  @Column(name="status", nullable=true)
	  private int status;

}
