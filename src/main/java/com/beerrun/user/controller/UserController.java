package com.beerrun.user.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beerrun.admin.service.DefaultDetailsServices;
import com.beerrun.admin.service.MastheadService;
import com.beerrun.admin.service.UserDetailsService;
import com.beerrun.common.ArchUtils;
import com.beerrun.common.Utils;
import com.beerrun.model.AdmLoginRights;
import com.beerrun.model.ApplicationMenu;
import com.beerrun.model.DefaultDetails;
import com.beerrun.model.LoginLogoutDetails;
import com.beerrun.model.Masthead;
import com.beerrun.model.UserDetails;
import com.beerrun.user.service.AdmLoginRightsService;
import com.beerrun.user.service.ApplicationMenuService;

@Controller
@RequestMapping(value="/user")
@SuppressWarnings({"unchecked","unused"})
@SessionAttributes({"userDetails"})
public class UserController {

	//	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private ApplicationMenuService applicationMenuService;

	@Autowired
	private AdmLoginRightsService admLoginRightsService;

	@Autowired
	private MastheadService mastheadService;
	
	@Autowired 
	private DefaultDetailsServices defaultDetailsServices;

	@RequestMapping(value="/loginVerify", method=RequestMethod.POST)
	public ModelAndView creditinitalVerification(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model, HttpSession session,HttpServletRequest req, HttpServletResponse res) {
		
		/*	logger.debug("loginVerify  userName :"+userName+", Psssword"+password);
		logger.info("loginVerify  userName :"+userName+", Psssword"+password);
		logger.fatal("loginVerify  userName :"+userName+", Psssword"+password);*/
		req.setAttribute("tenantId", "tenantId1");
		ModelAndView modelAndView = null;

		UserDetails userDetails = null;
		if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {

			UserDetails loginDtoUser = userService.findByUserName(userName);

			if(loginDtoUser == null) {
				modelAndView = new ModelAndView("login-page");
				modelAndView.addObject("errorMessage", "Your username is not recognized");
				return modelAndView;
			}else {

				userDetails = new UserDetails();
				userDetails = userService.getUserLoginDetails(userName, password);

				if(userDetails == null) {
					modelAndView = new ModelAndView("login-page");
					modelAndView.addObject("errorMessage", "Wrong password.Try again");
					return modelAndView;
				}
			}

			if ((userDetails != null) && (password.equals(userDetails.getPassword()))) {
					modelAndView = new ModelAndView("home");
				modelAndView.addObject("userDetails", userDetails);
			} else {
				modelAndView = new ModelAndView("login-page");
				modelAndView.addObject("errorMessage", "Wrong password.Try again");
				return modelAndView;	
			}
			
			System.out.println("dbname---------------"+userDetails.getDbname());
			req.setAttribute("tenantId", "tenantId2");
			String dbname = userDetails.getDbname().toString();
			session.setAttribute("dbname", dbname);
			
			// Login And Log Out Details;
			String rowId =  userService.getMaximumRowId(true, " ");

			if(Integer.valueOf(rowId) == 0) {
				rowId = "1";
			}else {
				rowId = String.valueOf(Integer.parseInt(rowId) + 1);
			}

			LoginLogoutDetails loginLogoutDetails = new LoginLogoutDetails();
			loginLogoutDetails.setlogintime(Utils.getCurrentTime());
			loginLogoutDetails.setName(userDetails.getName());
			System.out.println("userDetails.getName()------>"+userDetails.getName());
			loginLogoutDetails.setVersion("1.0");
			loginLogoutDetails.setRowId(rowId);
			loginLogoutDetails.setDateadded(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()).toString());
			userService.saveLoginAndLogoutDetails(loginLogoutDetails);
			session.setAttribute("userProfile", userDetails);
			session.setAttribute("userName", userDetails.getName());
			session.setAttribute("tenantId", "tenantId2");
			
			List<ApplicationMenu> list=applicationMenuService.getApplicationMenuList("");
			list=list==null?new ArrayList<ApplicationMenu>():list;

			session.setAttribute("Menulist", list);

			AdmLoginRights rightsbean=admLoginRightsService.getAdmLoginRights(" and userId="+userDetails.getUserrefno()+"");
			session.setAttribute("rightsbean", rightsbean);


			if(userDetails.getUserName().equalsIgnoreCase("demo")){
				Map<String,String> parentchildmap=applicationMenuService.getparentchildMaps("");
				parentchildmap=parentchildmap==null?new LinkedHashMap<String, String>():parentchildmap;
				session.setAttribute("parentchildmap", parentchildmap);
			}
			else {
				String navids=rightsbean.getNavigationIds();
				Map<String,String> parentchildmap=applicationMenuService.getParentChildNavicationMap("",navids);
				parentchildmap=parentchildmap==null?new LinkedHashMap<String, String>():parentchildmap;
				session.setAttribute("parentchildmap", parentchildmap);
			}

			Masthead company = mastheadService.getMasthead();
			session.setAttribute("company", company);
			
			DefaultDetails defaultDetails = defaultDetailsServices.findByInvoiceNumber();
			session.setAttribute("weight", defaultDetails.getWeightunit());
			session.setAttribute("volume", defaultDetails.getVolumeUnit());
			session.setAttribute("unitName", defaultDetails.getUnitname());
			session.setAttribute("unitShortName", defaultDetails.getUnitshortname());
			session.setAttribute("photo", userDetails.getPhoto());
			session.setAttribute("userrefno", userDetails.getUserrefno());
			
		 }

		return modelAndView;
	}

	@RequestMapping(value="/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");

		List<UserDetails> users = userService.getAllUsers();
		modelAndView.addObject("users", users);

		return modelAndView;
	}
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView edditingTeam(@RequestParam Integer id) {
		//System.out.println("==========================="+id);
		ModelAndView modelAndView = new ModelAndView("home");

		//userService.updateUser(team);

		String message = "User was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value="/delete-{id}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id,RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("home");
		userService.deleteuser(id);
		redirectAttributes.addFlashAttribute("success", "User Deleted Successfully !!!");
		return new ModelAndView("redirect:/users/userlist");
		
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (@RequestParam("userName") String name, HttpSession session){

		if((name != null) && (!name.isEmpty())) {

			String rowId = userService.getMaximumRowId(false, name);

			LoginLogoutDetails loginLogoutDetails = new LoginLogoutDetails();
			loginLogoutDetails.setlogouttime(Utils.getCurrentTime());
			loginLogoutDetails.setName(name);
			loginLogoutDetails.setRowId(rowId);
			loginLogoutDetails.setDateadded(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()).toString());
			userService.saveLoginAndLogoutDetails(loginLogoutDetails);
		}

		session.removeAttribute("userProfile");
		session.removeAttribute("userName");
		session.removeAttribute("rightsbean");
		session.removeAttribute("company");
		session.removeAttribute("Menulist");
		session.removeAttribute("parentchildmap");
		session.invalidate();

		return "login-page";
	}

	public static String formLeftNavication(HttpSession session)
	{

		/*AdmLoginRights rightsbean=(AdmLoginRights)session.getAttribute("rightsbean");
		String navids=rightsbean.getNavigationIds();*/

		List<ApplicationMenu> list=(List<ApplicationMenu>)session.getAttribute("Menulist");
		list=list==null?new ArrayList<ApplicationMenu>():list;
		//System.out.println("Q   list---->"+list);

		Map<String,ApplicationMenu> NavigationsMap=(Map<String,ApplicationMenu>)ArchUtils.ListToLinkedHashMap(list,Arrays.asList(new String[]{"navigationId"}),"");
		NavigationsMap=NavigationsMap==null?new LinkedHashMap<String,ApplicationMenu>():NavigationsMap;

		//System.out.println("Q   NavigationsMap---->"+NavigationsMap);

		Map<String,String> parentchildmap=(Map<String,String>)session.getAttribute("parentchildmap");
		parentchildmap=parentchildmap==null?new LinkedHashMap<String, String>():parentchildmap;

		//System.out.println("Q   parentchildmap---->"+parentchildmap);

		String navtree=outLeftNavication("1",parentchildmap,NavigationsMap); 

		//System.out.println("navtree===>"+navtree);
		return navtree;

	}

	public static String outLeftNavication(String parentid,Map<String,String> parentchildmap,Map<String,ApplicationMenu> NavigationMaps){

		String childlist=ArchUtils.nullCheck(parentchildmap.get(""+parentid));

		List<String> childs=ArchUtils.getTokensList(childlist, ",");

		String result="";
		for(String childid:childs)
		{
			ApplicationMenu beanMenu=NavigationMaps.get(childid);

			String currentDate=ArchUtils.getCurrentDate(false);
			Date today = new Date();  

			if(IsStageHaveALeaf(childid,parentchildmap,NavigationMaps)){

				String name=beanMenu.getNavigationName();
				
				String urllink=ArchUtils.nullCheck(beanMenu.getHrefLink(),"##");
				String icon=ArchUtils.nullCheck(beanMenu.getIcon());
				String MenuName=ArchUtils.nullCheck(beanMenu.getNavigationName());


				String subchilds=ArchUtils.nullCheck(parentchildmap.get(""+childid));
				List<String> subchildlist=ArchUtils.getTokensList(subchilds, ",");

				if(subchildlist.size()==0 || subchildlist==null)
				{

					if(beanMenu.getLevel().equalsIgnoreCase("3"))
					{
						//System.out.println("a level 3 ");
						result=result+"<li><a class='menulink' href='"+beanMenu.getHrefLink()+"'>"+MenuName+"</a></li>";

					}
					if(beanMenu.getLevel().equalsIgnoreCase("2"))
					{
						//System.out.println("a level 3 ");						                                                                                                         
						result=result+"<li>";
						result=result+"<li class='nav-item'><a class='nav-link menulink' href='"+beanMenu.getHrefLink()+"'><i class='ti-control-record'></i>"+MenuName+"</a></li>";
						
					}
				}
				else
				{

					if(beanMenu.getLevel().equalsIgnoreCase("1"))
					{
						//System.out.println("b level 1 ");
						result=result+"<li>";
						result=result+"<a href='javascript: void(0);'><i class='ti-crown'></i><span>"+MenuName+"</span><span class='menu-arrow'><i class='mdi mdi-chevron-right'></i></span></a>";

					}

					if(beanMenu.getLevel().equalsIgnoreCase("2"))
					{
						//System.out.println("b level 2 ");
  						result=result+"<li>";
						result=result+"<a href='javascript: void(0);'><i class='ti-control-record'></i>"+MenuName+" <span class='menu-arrow left-has-menu'><i class='mdi mdi-chevron-right'></i></span></a>";
					}
					

				}
				

				if(subchildlist!=null && subchildlist.size()!=0)
				{

					if(beanMenu.getLevel().equalsIgnoreCase("1"))
					{
						//System.out.println("c level 1 ");
						result=result+"<ul class='nav-second-level' aria-expanded='false'>";
					}


					if(beanMenu.getLevel().equalsIgnoreCase("2"))
					{
						//System.out.println("c level 2 ");
						result=result+"<ul class='nav-second-level' aria-expanded='false'>";
					}


					result=result+outLeftNavication(childid,parentchildmap,NavigationMaps);

					result=result+"</ul></li>";

				}
				
			}

		}	
		return result;
	}

	public static boolean  IsStageHaveALeaf(String parentid,Map<String,String> parentchildmap,Map<String,ApplicationMenu> NavigationMaps )
	{	

		boolean isHaveLeaf=false;
		String childlist=ArchUtils.nullCheck(parentchildmap.get(""+parentid));
		List<String> childs=ArchUtils.getTokensList(childlist, ",");
		ApplicationMenu pbean=NavigationMaps.get(parentid);
		//System.out.println("parant id---"+parentid);


		if(!pbean.isLeaf())
		{
			//System.out.println("pbean===>"+pbean);
			for(String childid:childs)
			{
				ApplicationMenu bean=(ApplicationMenu)NavigationMaps.get(childid);
				if(!bean.isLeaf())
				{

					String subchilds=ArchUtils.nullCheck(parentchildmap.get(""+childid));
					List<String> subchildlist=ArchUtils.getTokensList(subchilds, ",");
					if(subchildlist!=null && subchildlist.size()!=0)
					{
						isHaveLeaf=isHaveLeaf | IsStageHaveALeaf(  childid, parentchildmap, NavigationMaps);
					}
				}
				else { 
					//System.out.println("A===isHaveLeaf >");
					return true;
				}
			}
			//System.out.println("B===isHaveLeaf >"+isHaveLeaf);
			return isHaveLeaf;
		}
		else {
			//System.out.println("pbean t===>"+pbean);
			//System.out.println("C===isHaveLeaf >");
			return true;
		}
	}
	public static boolean  IsCheckParentEnable(String parentid,Map<String,String> parentchildmap,Map<String,ApplicationMenu> NavigationMaps )
	{	

		boolean isHaveLeaf=false;
		String childlist=ArchUtils.nullCheck(parentchildmap.get(""+parentid));
		List<String> childs=ArchUtils.getTokensList(childlist, ",");
		ApplicationMenu pbean=NavigationMaps.get(parentid);
		//System.out.println("parant id---"+parentid);


		/*if(!pbean.isLeaf())
		{*/
		//System.out.println("pbean===>"+pbean);
		for(String childid:childs)
		{
			ApplicationMenu bean=(ApplicationMenu)NavigationMaps.get(childid);
			if(!bean.isLeaf())
			{

				String subchilds=ArchUtils.nullCheck(parentchildmap.get(""+childid));
				List<String> subchildlist=ArchUtils.getTokensList(subchilds, ",");
				if(subchildlist!=null && subchildlist.size()!=0)
				{
					isHaveLeaf=isHaveLeaf | IsStageHaveALeaf(  childid, parentchildmap, NavigationMaps);
				}
			}
			else { 
				//System.out.println("A===isHaveLeaf >isHaveLeaf-->"+isHaveLeaf);
				return true;

			}
		}
		//System.out.println("B===isHaveLeaf >"+isHaveLeaf);
		return isHaveLeaf;
		/*}
		else {
			System.out.println("pbean t===>"+pbean);
			System.out.println("C===isHaveLeaf >");
			return true;
		}*/
	}
	
	@RequestMapping(value="/getProfile", method = RequestMethod.GET)
	public ModelAndView getProfile(@RequestParam("userid") int userid, HttpSession session, ModelMap model){

		UserDetails userDetails = userService.findById(userid);
		model.addAttribute("userDetails", userDetails);
		
		return new ModelAndView("profile");
	}
	
}
