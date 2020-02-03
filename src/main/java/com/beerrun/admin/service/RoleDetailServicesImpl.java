package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.RoleDetailDao;
import com.beerrun.model.RoleDetails;

@Service("RoleDetailServices")
@Transactional
public class RoleDetailServicesImpl implements RoleDetailServices{
	
	@Autowired
	private RoleDetailDao roledetailsdao;

	@Override
	public List<RoleDetails> getrolelist() {
		// TODO Auto-generated method stub
		return roledetailsdao.getroledetails();
	}

	@Override
	public RoleDetails findByroleId(int roleid) {
		// TODO Auto-generated method stub
		return roledetailsdao.findByroleId(roleid);
	}

	@Override
	public List<Object[]> getroledetailsList(){
		return roledetailsdao.getroledetailsList();
	}
	
	@Override
	public List<Object> getroleIdUserdetailsList(int roleId){
		return roledetailsdao.getroleIdUserdetailsList(roleId);
	}

	@Override
	public void saveRole(RoleDetails roleDetails) {
		roledetailsdao.saveRole(roleDetails);
		
	}
	
	
}
