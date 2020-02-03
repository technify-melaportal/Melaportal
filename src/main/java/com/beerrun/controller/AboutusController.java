package com.beerrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.beerrun.admin.service.UserDetailsService;
import com.beerrun.common.Defs;
import com.beerrun.model.UserDetails;


@Controller
@RequestMapping("/aboutUs")
public class AboutusController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value= {"/company"},method=RequestMethod.GET)
	public ModelAndView company(HttpServletRequest request)
	{
		HttpSession session = request.getSession(true);
		int userrefno = (int) session.getAttribute("userrefno");
		
		UserDetails userDetails = userDetailsService.findById(userrefno);
		ModelAndView modelAndView = null;
		if(userDetails !=null) {
		if(userDetails.getFirstName() == null || userDetails.getFirstName().isEmpty()) {
			modelAndView = new ModelAndView("home");
		}else {
			modelAndView = new ModelAndView("home");
		}
		}else {
			modelAndView = new ModelAndView("home");
		}
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/companyForm"},method=RequestMethod.POST)
	public ModelAndView companyForm()
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("company");
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/cofounder"},method=RequestMethod.GET)
	public ModelAndView cofounder(UserDetails userDetails)
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("cofounder");
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/internships"},method=RequestMethod.GET)
	public ModelAndView internships(UserDetails userDetails)
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("internships");
		
		return  modelAndView;
	}
	
	@RequestMapping(value = { "/addInternship" }, method = RequestMethod.GET)
	public ModelAndView addInternship() {

		return new ModelAndView("aboutus/Add-aboutus-internships");
	}
	
	@RequestMapping(value= {"/scorecard"},method=RequestMethod.GET)
	public ModelAndView scorecard(UserDetails userDetails)
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("scorecard");
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/personal3"},method=RequestMethod.POST)
	public ModelAndView personal3(@RequestParam("file") MultipartFile file, UserDetails userDetails, HttpServletRequest request)throws IOException
	{
		HttpSession session = request.getSession(true);
		String dbname = (String) session.getAttribute("dbname");
		if (!file.getOriginalFilename().isEmpty()) {
	    	  
	    	 // String rootPath = (Defs.rootpath_upload+dbname+"/"+Defs.receive_pdf);
	    	  String rootPath = (Defs.rootpath_upload1);
				File dir = new File(rootPath );
				if (!dir.exists())
					dir.mkdirs();
				String newFileName = checkForSpecialCharsAndGetNewFileName(file.getOriginalFilename());
				//File serverFile = new File(dir.getAbsolutePath()+ File.separator + file.getOriginalFilename());
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + newFileName);
				
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
	         String name = newFileName;
	         //String path = Defs.IpAddress+dbname+"/"+Defs.receive_pdf+newFileName;
	         String path = Defs.IpAddress1+newFileName;
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();
	        
	         userDetailsService.updatePhtoPath(name, path, userDetails);
	        
	      }
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("personal3");
		UserDetails userDetails1=userDetailsService.findById(userDetails.getUserrefno());
		modelAndView.addObject("userDetails",userDetails1);
		
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/personal4"},method=RequestMethod.POST)
	public ModelAndView personal4(UserDetails userDetails)
	{
		ModelAndView modelAndView = null;
		userDetailsService.updateVideoPath(userDetails);
		modelAndView = new ModelAndView("personal4");
		UserDetails userDetails1=userDetailsService.findById(userDetails.getUserrefno());
		modelAndView.addObject("userDetails",userDetails1);
		
		return  modelAndView;
	}
	
	public String checkForSpecialCharsAndGetNewFileName (String originalFileName) {
		  final String[] splChars = {"#", "+", "$"};
		  String newString = originalFileName;
		  for (int i=0; i<splChars.length; i++)
		    newString = StringUtils.replace(newString, splChars[i], "");
		  return newString;
		}

}
