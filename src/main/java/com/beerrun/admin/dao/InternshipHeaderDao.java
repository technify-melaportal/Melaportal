package com.beerrun.admin.dao;

import java.util.List;

import com.beerrun.model.ImportanceList;
import com.beerrun.model.InternshipHeader;
import com.beerrun.model.ProficiencyList;
import com.beerrun.model.SkillList;

public interface InternshipHeaderDao {
	
	public InternshipHeader getId(int internshipid);
	
	public InternshipHeader saveInternshipHeader(InternshipHeader internshipHeader);
	
	public List<InternshipHeader> getInternshipList();
	
	public List<SkillList> getSkillsDetails();
	
	public List<ProficiencyList> getProficiencyDetails();
	
	public List<ImportanceList> getImportanceDetails();

}
