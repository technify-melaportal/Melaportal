package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.InternshipLine;

public interface InternshipLineDao {
	
	public InternshipLine getInternshipLineId(int internshipid);
	
	public InternshipLine saveInternshipLine(InternshipLine internshipHeader);
	
	public List<InternshipLine> getInternshipLineList();
	
	public List<InternshipLine> getInternshipLineByHeaderId(int id);

}
