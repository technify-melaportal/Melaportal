package com.beerrun.admin.service;

import java.util.List;

import com.beerrun.model.ImportanceList;
import com.beerrun.model.InternshipHeader;
import com.beerrun.model.InternshipLine;
import com.beerrun.model.ProficiencyList;
import com.beerrun.model.SkillList;

public interface InternshipService {
	
	public InternshipHeader getId(int internshipid);
	
	public InternshipHeader saveInternshipHeader(InternshipHeader internshipHeader);
	
	public List<InternshipHeader> getInternshipList();
	
	public InternshipLine getInternshipLineId(int internshipid);
	
	public InternshipLine saveInternshipLine(InternshipLine internshipHeader);
	
	public List<InternshipLine> getInternshipLineByHeaderId(int id);
	
	public List<InternshipLine> getInternshipLineList();
	
	public List<SkillList> getSkillsDetails();
	
	public List<ProficiencyList> getProficiencyDetails();
	
	public List<ImportanceList> getImportanceDetails();
	
	public List<SkillList> getSkillList();
	
	public SkillList getSkillId(int id);
	
	public void saveSkill(SkillList skillList);

}
