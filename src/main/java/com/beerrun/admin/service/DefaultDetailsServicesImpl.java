package com.beerrun.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerrun.admin.dao.DefaultDetailsDao;
import com.beerrun.model.DefaultDetails;

@Service("DefaultDetailsServices")
@Transactional
public class DefaultDetailsServicesImpl implements DefaultDetailsServices{

	@Autowired
	private DefaultDetailsDao defaultdetailsdao;

	@Override
	public List<DefaultDetails> getusersetupinfo() {
		// TODO Auto-generated method stub
		return defaultdetailsdao.getusersetupinfo();
	}

	@Override
	public void update(DefaultDetails defaultDetails) {
		// TODO Auto-generated method stub


		DefaultDetails entity=defaultdetailsdao.findbyId(defaultDetails.getId());

		if(entity!=null)
		{
			entity.setGsttaxvalue(defaultDetails.getGsttaxvalue());
			entity.setSalestaxstatusonof(defaultDetails.getSalestaxstatusonof());
			if(defaultDetails.getCountry() != null) {
				entity.setCountry(defaultDetails.getCountry());
			}
			if(defaultDetails.getWeightunit() != null) {
				entity.setWeightunit(defaultDetails.getWeightunit());
			}
			if(defaultDetails.getUnitname() != null) {
				entity.setUnitname(defaultDetails.getUnitname());
			}
			if(defaultDetails.getPostartingno() != null) {
				entity.setPostartingno(defaultDetails.getPostartingno());
			}
			if(defaultDetails.getBatchstartingno() != null) {
				entity.setBatchstartingno(defaultDetails.getBatchstartingno());
			}
			if(defaultDetails.getBillstartingno() != null) {
				entity.setBillstartingno(defaultDetails.getBillstartingno());
			}
			if(defaultDetails.getStatettb() != null) {
				entity.setStatettb(defaultDetails.getStatettb());
			}
		}

	}

	@Override
	public DefaultDetails findbyId(int id) {
		// TODO Auto-generated method stub
		return defaultdetailsdao.findbyId(id);
	}

	@Override
	public void updatedefault(DefaultDetails defaultDetails) {
		// TODO Auto-generated method stub


		DefaultDetails entity=defaultdetailsdao.findbyId(defaultDetails.getId());

		if(entity!=null)
		{
			if(defaultDetails.getGmailusername().equalsIgnoreCase(""))
			{

			}
			else
			{
				entity.setGmailusername(defaultDetails.getGmailusername());
			}

			if(defaultDetails.getGmailpassword().equalsIgnoreCase(""))
			{

			}
			else
			{
				entity.setGmailpassword(defaultDetails.getGmailpassword());	
			}

			if(defaultDetails.getClassname().equalsIgnoreCase(""))
			{

			}

			else
			{
				entity.setClassname(defaultDetails.getClassname());
			}
			if(defaultDetails.getDaysout().equalsIgnoreCase(""))
			{

			}
			else
			{
				entity.setDaysout(defaultDetails.getDaysout());
			}

			if(defaultDetails.getReturnsdays().equalsIgnoreCase(""))
			{

			}
			else
			{
				entity.setReturnsdays(defaultDetails.getReturnsdays());
			}

			if(defaultDetails.getBrewhousesize().equalsIgnoreCase(""))
			{

			}
			else
			{
				entity.setBrewhousesize(defaultDetails.getBrewhousesize());
			}
			if(defaultDetails.getDefaultshipday().equalsIgnoreCase(""))
			{

			}
			else
			{
				entity.setDefaultshipday(defaultDetails.getDefaultshipday());
			}


			entity.setPackdatestatus(defaultDetails.getPackdatestatus());
			if(defaultDetails.getAutoshipdepositstatus()==1) {
			entity.setAutoshipdepositstatus(defaultDetails.getAutoshipdepositstatus());
			}
			else {
				entity.setAutoshipdepositstatus(2);
			}
			entity.setSosignature(defaultDetails.getSosignature());
			

			entity.setBlsignature(defaultDetails.getBlsignature());
			entity.setInvoicesignature(defaultDetails.getInvoicesignature());
			entity.setAutoinvoicesignature(defaultDetails.getAutoinvoicesignature());
		}
	}

	

	@Override
	public DefaultDetails findByInvoiceNumber() {
		return defaultdetailsdao.findByInvoiceNumber();
	}
	
	@Override
	public Double getBrewHouseSize() {
		
		return defaultdetailsdao.getBrewHouseSize();
	}

}
