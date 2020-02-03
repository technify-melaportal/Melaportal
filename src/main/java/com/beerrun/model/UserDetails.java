package com.beerrun.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="am_userdetails")
@Data
public class UserDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int userrefno;

	  @Column(name="initial", nullable=true)
	  private String initial;
	  
	  @Column(name="salutation", nullable=true)
	  private String salutation;
	  
	  @Column(name="title", nullable=true)
	  private String title;
	  
	  @Column(name="firstname", nullable=true)
	  private String firstName;
	  
	  @Column(name="middlename", nullable=true)
	  private String middleName;
	  
	  @Column(name="lastname", nullable=true)
	  private String lastName;
	  
	  @Column(name="alias", nullable=true)
	  private String alias;
	  
	  @Column(name="suffix", nullable=true)
	  private String suffix;
	  
	  @Column(name="email", nullable=true)
	  private String email;
	  
	  @Column(name="role", nullable=true)
	  private String role;
	  
	  @Column(name="username", nullable=true)
	  private String userName;
	  
	  @Column(name="password", nullable=true)
	  private String password;
	  
	  @Column(name="name", nullable=true)
	  private String name;
	  
	  @Column(name="licensenumber", nullable=true)
	  private String licenseNumber;
	  
	  @Column(name="createdby", nullable=true)
	  private String createdby;
	  
	  @Column(name="datecreated", nullable=true)
	  private String datecreated;
	  
	  @Column(name="status", nullable=true)
	  private int status;
	  	  
	  @Column(name="roleid", nullable=true)
	  private Integer roleid;
	  
	  @Column(name="onlinestatus", nullable=true)
	  private String onlinestatus;
	  
	  @Column(name="companyname", nullable=true)
	  private String companyName;
	  
	  @Column(name="type", nullable=true)
	  private String type;
	  
	  @Column(name="adminstatus", nullable=true)
	  private String adminstatus;
	  
	  @Column(name="brewpadstatus", nullable=true)
	  private int brewpadstatus;
	  
	  @Column(name="transfername", nullable=true)
	  private String transfername;
	  
	  @Column(name="ccstatus", nullable=true)
	  private int ccstatus;

	  @Column(name="tablepagevalues", nullable=true)
	  private String tablePageValues;
	  
	  @Column(name="tablepagevalues1", nullable=true)
	  private String tablePageValues1;
	  
	  @Column(name="defaultvalue", nullable=true)
	  private String defaultValue;
	  
	  @Column(name="dbname", nullable=true)
	  private String dbname;
	  
	  @Column(name="sessiontimeout", nullable=true)
	  private String sessiontimeout;
	  
	  @Column(name="photo", nullable=true)
	  private String photo;
	  
	  @Column(name="video", nullable=true)
	  private String video;
	 
}
