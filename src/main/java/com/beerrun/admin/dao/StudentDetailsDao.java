package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.Studentheader;

public interface StudentDetailsDao {
	
	public Studentheader getId(int id);
		
	public List<Studentheader> getStudentDetails();

}
