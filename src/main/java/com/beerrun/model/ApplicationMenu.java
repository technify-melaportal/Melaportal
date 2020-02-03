package com.beerrun.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*import lombok.Data;*/

@Entity
@Table(name="arc_navigation")
@Data
public class ApplicationMenu {
	
	@Id
	@GeneratedValue
	@Column(name="navigation_id")
	private int navigationId;  
	
	@Column(name="parent_navigation_id")
	private int parentNavigationId;  
	
	@Column(name="navigation_name")
	private String navigationName; 
	
	@Column(name="href_link")
	private String hrefLink;
	
	@Column(name="action_id")
	private int actionId;
	
	@Column(name="url_qry")
	private String urlQry;
	
	@Column(name="is_leaf")
	private boolean isLeaf; 
	
	@Column(name="dsp_order")
	private int dspOrder; 
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="close_date",columnDefinition="date DEFAULT '1000-01-01'")
	private Date closeDate;
	
	@Column(name="tips")
	private String tips;
	
	@Column(name="entered_by")
	private String enteredBy; 
	
	@Column(name="entered_on",columnDefinition="datetime DEFAULT '1000-01-01 00:00:00'")
	private Date enteredOn; 
	
	@Column(name="update_by")
	private String updateBy;
	
	@Column(name="update_on",columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ")
	private Date updateOn;
	
	
	@Column(name="level_details",columnDefinition="enum('1','2','3') ")
	private String level;

	@Column(name="video_url")
	private String video_url;
	
}
