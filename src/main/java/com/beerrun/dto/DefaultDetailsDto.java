package com.beerrun.dto;

import java.util.List;

import com.beerrun.model.DefaultDetails;

public class DefaultDetailsDto {
	
//	private List<DefaultDetails> defaultDetailsModellist;
	
	/*int salestaxstatusonof; 
	int id;
	String gsttaxvalue;*/
	
	private DefaultDetails defaultDetails;
		
	private List beerrunAddonsUpdateList;
	
	private int status;

	public DefaultDetails getDefaultDetails() {
		
		return defaultDetails;
	}

	public void setDefaultDetails(DefaultDetails defaultDetails) {
		this.defaultDetails = defaultDetails;
	}

	public List getBeerrunAddonsUpdateList() {
		return beerrunAddonsUpdateList;
	}

	public void setBeerrunAddonsUpdateList(List beerrunAddonsUpdateList) {
		this.beerrunAddonsUpdateList = beerrunAddonsUpdateList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	/*public int getSalestaxstatusonof() {
		return salestaxstatusonof;
	}
	public void setSalestaxstatusonof(int salestaxstatusonof) {
		this.salestaxstatusonof = salestaxstatusonof;
	}
	public String getGsttaxvalue() {
		return gsttaxvalue;
	}
	public void setGsttaxvalue(String gsttaxvalue) {
		this.gsttaxvalue = gsttaxvalue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	

}
