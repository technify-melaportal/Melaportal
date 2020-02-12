package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.SkillList;

public interface SkillListDao {
	
	public List<SkillList> getSkillList();
	
	public SkillList getId(int id);
	
	public void saveSkill(SkillList skillList);

}
