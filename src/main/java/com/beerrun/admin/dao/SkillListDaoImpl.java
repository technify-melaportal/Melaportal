package com.beerrun.admin.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.beerrun.init.AbstractDao;
import com.beerrun.model.SkillList;

@Repository("skillListDao")
public class SkillListDaoImpl extends AbstractDao<Integer, SkillList> implements SkillListDao{

	@Override
	public List<SkillList> getSkillList(){
		
		Criteria crit = createEntityCriteria().addOrder(Order.asc("skillname"));
		List<SkillList> list = crit.list();
		
		return list;
	}
	
	@Override
	public SkillList getId(int id) {
		SkillList skill = getByKey(id);
	   
		return skill;
	}

	@Override
	public void saveSkill(SkillList skillList) {
		persist(skillList);
		
	}
	
}
