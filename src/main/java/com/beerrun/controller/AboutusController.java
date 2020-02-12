package com.beerrun.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beerrun.admin.service.InternshipService;
import com.beerrun.admin.service.MastheadService;
import com.beerrun.common.Defs;
import com.beerrun.model.ImportanceList;
import com.beerrun.model.InternshipHeader;
import com.beerrun.model.InternshipLine;
import com.beerrun.model.Masthead;
import com.beerrun.model.ProficiencyList;
import com.beerrun.model.SkillList;


@Controller
@RequestMapping("/aboutUs")
public class AboutusController {
	
	@Autowired
	private MastheadService mastheadService;
	
	@Autowired
	private InternshipService internshipService;
	
	
	@RequestMapping(value= {"/company"},method=RequestMethod.GET)
	public ModelAndView company(HttpServletRequest request, ModelMap model)
	{
		
		Masthead masthead = mastheadService.getMasthead();
		ModelAndView modelAndView = null;
		if(masthead !=null) {
			modelAndView = new ModelAndView("companyform");
		}else {
			modelAndView = new ModelAndView("company");
		}
		
		model.addAttribute("masthead", masthead);
		return  modelAndView;
	}
	
	@RequestMapping(value= {"/companyForm"},method=RequestMethod.POST)
	public ModelAndView companyForm()
	{
		
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("companyform");
		
		return  modelAndView;
	}
	
	@RequestMapping(value = { "/saveCompany" }, method = RequestMethod.POST)
	public String saveCompany(@Validated Masthead masthead, BindingResult result,
			ModelMap model,@RequestParam("companylogo") MultipartFile companylogo, @RequestParam("businesscard1") MultipartFile businesscard1,
			@RequestParam("businesscard2") MultipartFile businesscard2, HttpServletRequest request)throws IOException {
				
		Masthead masthead1 = mastheadService.save(masthead);
		int companyid= masthead1.getCompanyid();
		String path = "",path1="",path2="",name="",name1="",name2="";
		if (!companylogo.getOriginalFilename().isEmpty()) {
	    	  
	    	  String rootPath = (Defs.rootpath_upload1);
				File dir = new File(rootPath );
				if (!dir.exists())
					dir.mkdirs();
				String newFileName = checkForSpecialCharsAndGetNewFileName(companylogo.getOriginalFilename());
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + newFileName);
				
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
	          name = newFileName;
	          path = Defs.IpAddress1+newFileName;
	         outputStream.write(companylogo.getBytes());
	         outputStream.flush();
	         outputStream.close();
	        
	      }
		
		if (!businesscard1.getOriginalFilename().isEmpty()) {
	    	  
	    	  String rootPath = (Defs.rootpath_upload1);
				File dir = new File(rootPath );
				if (!dir.exists())
					dir.mkdirs();
				String newFileName = checkForSpecialCharsAndGetNewFileName(businesscard1.getOriginalFilename());
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + newFileName);
				
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
	          name1 = newFileName;
	          path1 = Defs.IpAddress1+newFileName;
	         outputStream.write(businesscard1.getBytes());
	         outputStream.flush();
	         outputStream.close();
	        
	      }
		
		if (!businesscard2.getOriginalFilename().isEmpty()) {
	    	  
	    	  String rootPath = (Defs.rootpath_upload1);
				File dir = new File(rootPath );
				if (!dir.exists())
					dir.mkdirs();
				String newFileName = checkForSpecialCharsAndGetNewFileName(businesscard2.getOriginalFilename());
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + newFileName);
				
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
	          name2 = newFileName;
	          path2 = Defs.IpAddress1+newFileName;
	         outputStream.write(businesscard2.getBytes());
	         outputStream.flush();
	         outputStream.close();
	        
	      }
		
		mastheadService.updatePath(name, path, path1, path2, companyid);
		
		model.addAttribute("success", "Company registered successfully");
		
		return "redirect:/aboutUs/company";
	}
 
 @RequestMapping(value = { "/editCompany" }, method = RequestMethod.POST)
	public String updateCompany(Masthead masthead, BindingResult result, ModelMap model, @RequestParam("companylogo") MultipartFile companylogo, @RequestParam("businesscard1") MultipartFile businesscard1,
			@RequestParam("businesscard2") MultipartFile businesscard2, HttpServletRequest request)throws IOException {

	 String path = "",name="";
	 Masthead masthead1 = mastheadService.updateMasthead(masthead);
	 int companyid= masthead1.getCompanyid();
	 
		if (!companylogo.getOriginalFilename().isEmpty()) {
	    	  
	    	  String rootPath = (Defs.rootpath_upload1);
				File dir = new File(rootPath );
				if (!dir.exists())
					dir.mkdirs();
				String newFileName = checkForSpecialCharsAndGetNewFileName(companylogo.getOriginalFilename());
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + newFileName);
				
				BufferedOutputStream outputStream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
	          name = newFileName;
	          path = Defs.IpAddress1+newFileName;
	         outputStream.write(companylogo.getBytes());
	         outputStream.flush();
	         outputStream.close();
	        
	        mastheadService.updateLogoPath(name, path, companyid);
	        
	      }
		
		
		
		model.addAttribute("success", "Updated successfully");
		return "redirect:/aboutUs/company";
	}
	
	@RequestMapping(value= {"/internships"},method=RequestMethod.GET)
	public ModelAndView internships(ModelMap model)
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("internships");
		
		List<InternshipHeader> InternshipHeader = internshipService.getInternshipList();
		model.addAttribute("InternshipHeader", InternshipHeader);
		
		return  modelAndView;
	}
	
	@RequestMapping(value = { "/addInternship" }, method = RequestMethod.GET)
	public ModelAndView addInternship(ModelMap model) {

		List<SkillList> skillList = internshipService.getSkillsDetails();
		model.addAttribute("skillList", skillList);
		
		List<ProficiencyList> proficiencyList = internshipService.getProficiencyDetails();
		model.addAttribute("proficiencyList", proficiencyList);
		
		List<ImportanceList> importanceList = internshipService.getImportanceDetails();
		model.addAttribute("importanceList", importanceList);
		
		return new ModelAndView("aboutus/Add-aboutus-internships");
	}	
	
	@RequestMapping(value = { "/saveInternship" }, method = RequestMethod.POST)
	public String saveInvoice(@RequestParam Map<String, Object> queryMap, ModelMap model,HttpServletRequest req, RedirectAttributes redirectAttributes, HttpServletRequest request) {

	 try {
		 
		System.out.println("queryMap===>"+queryMap);
		HttpSession session = request.getSession(true);
		String createdBy = (String) session.getAttribute("userName");
		String dbname = (String) session.getAttribute("dbname");
		Masthead masthead = mastheadService.getMasthead();
		int companyid = masthead.getCompanyid();
		
		InternshipHeader obj=new InternshipHeader();
				
		//InternshipHeader
		obj.setCompanyid(companyid);
		obj.setIntershiptitle((String)queryMap.get("intershiptitle"));
		obj.setIntershipshortname((String)queryMap.get("intershipshortname"));
		obj.setDescription((String)queryMap.get("description"));
		obj.setPaid((String)queryMap.get("paid"));
		obj.setPositions((String)queryMap.get("positions"));
		obj.setStatus(1);	
		
		InternshipHeader header = internshipService.saveInternshipHeader(obj);
		
		int internshipid = header.getInternshipid();
		
		InternshipLine objline = new InternshipLine();
		
		//InternshipLine
		objline.setIntershipid(internshipid);
		objline.setSkills((String)queryMap.get("skills"));
		objline.setImportance((String)queryMap.get("importance"));
		objline.setProficiency(queryMap.get("proficiency").toString());
		objline.setStatus(1);											 
		
		internshipService.saveInternshipLine(objline);
		
		//InternshipLine
		objline.setIntershipid(internshipid);
		objline.setSkills((String)queryMap.get("skills1"));
		objline.setImportance((String)queryMap.get("importance1"));
		objline.setProficiency(queryMap.get("proficiency1").toString());
		objline.setStatus(1);											 
		
		internshipService.saveInternshipLine(objline);
		
		//InternshipLine
		objline.setIntershipid(internshipid);
		objline.setSkills((String)queryMap.get("skills2"));
		objline.setImportance((String)queryMap.get("importance2"));
		objline.setProficiency(queryMap.get("proficiency2").toString());
		objline.setStatus(1);											 
		
		internshipService.saveInternshipLine(objline);
		
		redirectAttributes.addFlashAttribute("success", "Internship Created Successfully !!!");
		
		return "redirect:/aboutUs/internships";
	}catch (Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
	 return null;
	 
	}
	
	@RequestMapping(value="/getViewInternship", method=RequestMethod.GET)
	public String getViewInternship(@RequestParam("id") int id, ModelMap model){
		try {

			InternshipHeader header = internshipService.getId(id);
			model.addAttribute("inheader", header);
			
			List<InternshipLine> line = internshipService.getInternshipLineByHeaderId(id);
			model.addAttribute("line", line);
			
			return "aboutus/view-aboutus-internships";
			
		}catch (Exception e) {
			System.out.println(e);
		}

		return null;  
	}
	
	public String checkForSpecialCharsAndGetNewFileName (String originalFileName) {
		  final String[] splChars = {"#", "+", "$"};
		  String newString = originalFileName;
		  for (int i=0; i<splChars.length; i++)
		    newString = StringUtils.replace(newString, splChars[i], "");
		  return newString;
		}
	
	
	 @RequestMapping("/addNewSkills")
		public @ResponseBody String addNewSkills(@RequestParam(value = "req") String name){
		String SkillsName = null;
		SkillList skillList = null;
		try{
			skillList = new SkillList();
			skillList.setSkillname(name);
			internshipService.saveSkill(skillList);
			SkillsName = name;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SkillsName;
		}
	 
	 @RequestMapping("/getSkillsList")
		public @ResponseBody Map<Integer, String> getSkillList(){
			Map<Integer, String> skill = null;
			List<SkillList> skillList = null;
			try{
				skillList = internshipService.getSkillList();
				skill = new HashMap<Integer, String>();
				for(SkillList skilllist : skillList){
					skill.put(skilllist.getSkillid(), skilllist.getSkillname());
				}
			}catch(Exception e){
				e.printStackTrace();
			}return skill;
		}

}
