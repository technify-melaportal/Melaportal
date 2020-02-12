package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.ImportanceList;
import com.beerrun.model.InternshipHeader;
import com.beerrun.model.ProficiencyList;
import com.beerrun.model.SkillList;

@Repository("internshipHeaderDao")
public class InternshipHeaderDaoImpl extends AbstractDao<Integer, InternshipHeader> implements InternshipHeaderDao{
	
	@Override
	public InternshipHeader getId(int internshipid)
	{
		InternshipHeader internshipHeader = getByKey(internshipid);
		
		return internshipHeader;
	}
	@Override
	public InternshipHeader saveInternshipHeader(InternshipHeader internshipHeader) {
		save(internshipHeader);
		return internshipHeader;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<InternshipHeader> getInternshipList() {
		Criteria criteria = createEntityCriteria();
		List<InternshipHeader> internshipHeader = (List<InternshipHeader>) criteria.list();
		return internshipHeader;	
	}
		
	@Override
	public List<SkillList> getSkillsDetails() {

		String sql = "select * from am_skillsdetails where status = '1' order by skillname asc;";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(SkillList.class);
		List<SkillList> skillsList = query.list();

		return skillsList;
	}
	
	@Override
	public List<ProficiencyList> getProficiencyDetails() {

		String sql = "select * from am_proficiencydetails where status = '1' order by proficiencyname asc;";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(ProficiencyList.class);
		List<ProficiencyList> proficiencyList = query.list();

		return proficiencyList;
	}
	
	@Override
	public List<ImportanceList> getImportanceDetails() {

		String sql = "select * from am_importancedetails where status = '1' order by importancename asc;";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.addEntity(ImportanceList.class);
		List<ImportanceList> importanceList = query.list();

		return importanceList;
	}

}
