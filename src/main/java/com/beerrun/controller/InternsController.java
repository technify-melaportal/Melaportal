package com.beerrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beerrun.admin.service.ApplicationDetailsService;
import com.beerrun.model.ApplicationDetails;
import com.beerrun.model.Studentheader;
import com.beerrun.model.UserDetails;


@Controller
@RequestMapping("/interns")
public class InternsController {
	
	@Autowired
	private ApplicationDetailsService applicationDetailsService;
	
	@RequestMapping(value= {"/search"},method=RequestMethod.GET)
	public ModelAndView search(ModelMap model)
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("search");
		
		List<Studentheader> applicationList = applicationDetailsService.getStudentDetails();
		model.addAttribute("applicationList", applicationList);
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/shortlist"},method=RequestMethod.GET)
	public ModelAndView shortlist(ModelMap model)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("shortlist");
		
		List<ApplicationDetails> applicationList = applicationDetailsService.getShortlistedDetails();
		model.addAttribute("applicationList", applicationList);
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/add"},method=RequestMethod.GET)
	public ModelAndView newuser(ModelMap model) {

		
		return new ModelAndView("interns/select_internship_popup");
	}
	
	@RequestMapping(value= {"/invited"},method=RequestMethod.GET)
	public ModelAndView invited(ModelMap model)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("invited");
		
		List<ApplicationDetails> applicationList = applicationDetailsService.getInvitedDetails();
		model.addAttribute("applicationList", applicationList);
		
		
		return  modelAndView;
	}

	@RequestMapping(value= {"/applications"},method=RequestMethod.GET)
	public ModelAndView applications(ModelMap model)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("applications");
		
		List<ApplicationDetails> applicationList = applicationDetailsService.getApplicationDetails();
		model.addAttribute("applicationList", applicationList);
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/schedule"},method=RequestMethod.GET)
	public ModelAndView schedule(UserDetails userDetails)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("schedule");
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/interviewing"},method=RequestMethod.GET)
	public ModelAndView interviewing(UserDetails userDetails)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("interviewing");
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/decision"},method=RequestMethod.GET)
	public ModelAndView decision(UserDetails userDetails)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("decision");
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/accepted"},method=RequestMethod.GET)
	public ModelAndView accepted(UserDetails userDetails)
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("accepted");
		
		return  modelAndView;
	}
	
	
}
