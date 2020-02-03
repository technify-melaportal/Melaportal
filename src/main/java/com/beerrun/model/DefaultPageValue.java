package com.beerrun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	
	@Entity
	@Table(name="am_defaultpagevalue")
	public class DefaultPageValue {
		
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer pageid;
		
		@Column(name="pagename", nullable=true)
		private String pageName;
		
		@Column(name="status", nullable=true)
		private int status;

		public Integer getPageid() {
			return pageid;
		}

		public void setPageid(Integer pageid) {
			this.pageid = pageid;
		}

		public String getPageName() {
			return pageName;
		}

		public void setPageName(String pageName) {
			this.pageName = pageName;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		

}
