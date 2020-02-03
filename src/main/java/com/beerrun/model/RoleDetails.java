package com.beerrun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="am_roledetails")
@Data
public class RoleDetails {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleid;
	
	@Column (name="rolename",nullable=true)
	private String roleName;
	
	@Column (name="createdby",nullable=true)
	private String createdBy;
	
	@Column (name="datecreated",nullable=true)
	private String dateCreated;
	
	@Column (name="status",nullable=true,columnDefinition=" tinyint(4) DEFAULT '1' ")
	private int status;
	
	@Column (name="navigation_ids",nullable=true,columnDefinition=" text DEFAULT '' ")
	private String navigationIds;

}
