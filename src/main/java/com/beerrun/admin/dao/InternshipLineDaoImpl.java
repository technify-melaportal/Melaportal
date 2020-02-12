package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.InternshipLine;

@Repository("internshipLineDao")
public class InternshipLineDaoImpl extends AbstractDao<Integer, InternshipLine> implements InternshipLineDao{

	@Override
	public InternshipLine getInternshipLineId(int id) {
		
		InternshipLine internshipLine = getByKey(id);
		
		return internshipLine;
	}

	@Override
	public InternshipLine saveInternshipLine(InternshipLine internshipLine) {
		save(internshipLine);
		return internshipLine;
	}

	@Override
	public List<InternshipLine> getInternshipLineList() {
		Criteria criteria = createEntityCriteria();
		List<InternshipLine> internshipLine = (List<InternshipLine>) criteria.list();
		return internshipLine;	
	}
	
	@Override
	public List<InternshipLine> getInternshipLineByHeaderId(int id) {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("intershipid", id))
				.add(Restrictions.eq("status", 1));
		List<InternshipLine> internshipLine = (List<InternshipLine>) criteria.list();
		return internshipLine;	
	}

}
