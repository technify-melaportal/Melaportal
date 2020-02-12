package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.InternshipHeaderDao;
import com.beerrun.admin.dao.InternshipLineDao;
import com.beerrun.admin.dao.SkillListDao;
import com.beerrun.model.ImportanceList;
import com.beerrun.model.InternshipHeader;
import com.beerrun.model.InternshipLine;
import com.beerrun.model.ProficiencyList;
import com.beerrun.model.SkillList;

@Transactional
@Service("internshipService")
public class InternshipServiceImpl implements InternshipService{

	@Autowired
	private InternshipHeaderDao internshipHeaderDao;
	
	@Autowired
	private InternshipLineDao internshipLineDao;
	
	@Autowired
	private SkillListDao skillListDao;
	
	@Override
	public InternshipHeader getId(int internshipid) {
		return internshipHeaderDao.getId(internshipid);
	}

	@Override
	public InternshipHeader saveInternshipHeader(InternshipHeader internshipHeader) {
		return internshipHeaderDao.saveInternshipHeader(internshipHeader);
	}

	@Override
	public List<InternshipHeader> getInternshipList() {
		return internshipHeaderDao.getInternshipList();
	}

	@Override
	public InternshipLine getInternshipLineId(int internshipid) {
		return internshipLineDao.getInternshipLineId(internshipid);
	}

	@Override
	public InternshipLine saveInternshipLine(InternshipLine internshipHeader) {
		return internshipLineDao.saveInternshipLine(internshipHeader);
	}

	@Override
	public List<InternshipLine> getInternshipLineList() {
		return internshipLineDao.getInternshipLineList();
	}
	
	@Override
	public List<InternshipLine> getInternshipLineByHeaderId(int id) {
		return internshipLineDao.getInternshipLineByHeaderId(id);
	}

	@Override
	public List<SkillList> getSkillsDetails() {
		return internshipHeaderDao.getSkillsDetails();
	}

	@Override
	public List<ProficiencyList> getProficiencyDetails() {
		return internshipHeaderDao.getProficiencyDetails();
	}

	@Override
	public List<ImportanceList> getImportanceDetails() {
		return internshipHeaderDao.getImportanceDetails();
	}

	@Override
	public List<SkillList> getSkillList() {
		return skillListDao.getSkillList();
	}

	@Override
	public SkillList getSkillId(int id) {
		return skillListDao.getId(id);
	}

	@Override
	public void saveSkill(SkillList skillList) {
		skillListDao.saveSkill(skillList);		
	}

}
