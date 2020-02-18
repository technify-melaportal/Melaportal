package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.Studentheader;

@Repository("studentDetailsDao")
public class StudentDetailsDaoImpl extends AbstractDao<Integer, Studentheader> implements StudentDetailsDao{

	@Override
	public Studentheader getId(int id) {
		Studentheader studentDetails = getByKey(id);
		
		return studentDetails;
	}

	@Override
	public List<Studentheader> getStudentDetails() {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("status", 1));
		List<Studentheader> studentDetails = (List<Studentheader>) criteria.list();
		return studentDetails;	
	}
	
	

}
