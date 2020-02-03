package com.beerrun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="adm_login_rights")
@Data
public class AdmLoginRights implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="rights_type")
	private String rightsType;
	
	@Column(name="rights_id")
	private int rightsId;
	
	/*private String actionIds;
	private String addlActionIds;
	private String remvActionIds;*/
	
	@Column (name="navigation_ids",nullable=true,columnDefinition=" text DEFAULT '' ")
	private String navigationIds;
	
	@Column(name="addl_navigation_ids")
	private String addl_navigation_ids;
	
	@Column(name="remv_navigation_ids")
	private String remv_navigation_ids;
	
	@Column(name="log_rig_description")
	private String logRigDescription;
	
	@Column(name="frm_tab_ids")
	private String frmTabIds;
	
	@Column(name="entered_by")
	private String enteredBy;
	
	@Column(name="entered_on")
	private String enteredOn;
	
	@Column(name="update_by")
	private String updateBy;
	
	@Column(name="update_on")
	private String updateOn;
	
	@Column(name="req_by")
	private String ReqBy; 
	
	@Column(name="req_date")
	private String ReqDate;
	
	@Column(name="req_status")
	private String ReqStatus;
	
	@Column(name="req_process_status")
	private String ReqProcessStatus; 
	
	@Column(name="approved_by")
	private String ApprovedBy;
	
	@Column(name="approval_date")
	private String ApprovalDate;
	
	@Column(name="req_description")
	private String ReqDescription; 
	
	@Column(name="req_history")
	private String ReqHistory;
	
	@Column(name="req_comments")
	private String ReqComments;
	
	@Column(name="status")
	private String status;
	
}
