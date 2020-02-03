package com.beerrun.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beerrun.admin.service.MastheadService;
import com.beerrun.admin.service.RoleDetailServices;
import com.beerrun.admin.service.UserDetailsService;
import com.beerrun.common.ArchUtils;
import com.beerrun.common.Defs;
import com.beerrun.common.emailsend;
import com.beerrun.model.AdmLoginRights;
import com.beerrun.model.ApplicationMenu;
import com.beerrun.model.Masthead;
import com.beerrun.model.RoleDetails;
import com.beerrun.model.UserDetails;
import com.beerrun.user.controller.UserController;
import com.beerrun.user.service.AdmLoginRightsService;
import com.beerrun.user.service.ApplicationMenuService;


@Controller
@RequestMapping("/users")
@SuppressWarnings("unchecked")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;

	/*@Autowired
	private MessageSource messageSource;*/

	/*@Autowired
	private HttpServletRequest request;*/

	@Autowired
	private RoleDetailServices roledetails;

	@Autowired
	private MastheadService mastheadService;

	@Autowired
	private RoleDetailServices roleDetailServices;

	@Autowired
	private ApplicationMenuService applicationMenuService;
	
	@Autowired
	private AdmLoginRightsService admLoginRightsService;

	
	@RequestMapping(value= {"/roles"},method=RequestMethod.GET)
	public ModelAndView roles()
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("roles");
		List<Object[]> roleList=roleDetailServices.getroledetailsList();
		roleList=(List<Object[]>) (roleList==null?new ArrayList<>():roleList);
		modelAndView.addObject("roleList",roleList);

		return  modelAndView;
	}
	
	@RequestMapping(value= {"/getdeleterole"},method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleterole(@RequestParam("id") int roleid,RedirectAttributes attributes,ModelMap model)
	{
	
		model.addAttribute("roleid",roleid);
		return new ModelAndView("admin/roles/delete-role");
	}

	@RequestMapping(value= {"/deleterole"},method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView deleterolelist(@RequestParam("roleid") int roleid,RedirectAttributes attributes)
	{
		System.out.println("ente delete---"+roleid);
		userDetailsService.deleterole(roleid);
		attributes.addFlashAttribute("success", "Delete Role Successfully !!!");
		
		return new ModelAndView("redirect:/users/roles");
	}

	@RequestMapping(value= {"/userlist"},method=RequestMethod.GET)
	public ModelAndView listofusers()
	{
		ModelAndView modelAndView = null;
		modelAndView = new ModelAndView("users");

		List<UserDetails> userDetails=userDetailsService.getUserDetails();
		modelAndView.addObject("userDetails",userDetails);
		List<RoleDetails>roleList=roledetails.getrolelist();
		modelAndView.addObject("roleList",roleList);		
		return  modelAndView;
	}

	@RequestMapping(value= {"/add"},method=RequestMethod.GET)
	public ModelAndView newuser(ModelMap model) {

		try {

			List<UserDetails> userDetails=userDetailsService.getUserDetails();
			model.addAttribute("userDetails",userDetails);
			List<RoleDetails>roleList=roledetails.getrolelist();
			model.addAttribute("roleList",roleList);
			System.out.println(""+roleList.size());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return new ModelAndView("admin/user/user-add");
	}

	@RequestMapping(value = { "/addnewuser" }, method = RequestMethod.POST)
	public ModelAndView saveuser(UserDetails userDetails, BindingResult result,ModelMap model,HttpServletRequest req,RedirectAttributes attributes) throws AddressException, MessagingException	{

		ModelAndView modelAndView = null;
		String fullname="";
		String username = "";
		String toemai="";
		String companyname="";

		try {

			HttpSession session = req.getSession(true);
			String createdBy = (String) session.getAttribute("userName");
			
			List<UserDetails> usersdetails=userDetailsService.getUserDetails();
			Masthead  masthead = mastheadService.getMasthead();
			System.out.println("Get company name ::::::"+companyname);
			
			modelAndView=new ModelAndView("users","userDetails",usersdetails);

			userDetails.setStatus(1);
			userDetails.setTablePageValues("[10, 25, 50, 100, -1]");
			userDetails.setTablePageValues1("[10, 25, 50, 100, 'All']");
			userDetails.setName(userDetails.getFirstName()+" "+userDetails.getLastName());
			
			if(!masthead.getCompanyName().equalsIgnoreCase("")) {
				userDetails.setCompanyName(masthead.getCompanyName());
				System.out.println("Inside company---- :"+masthead.getCompanyName());
			}
			else {
				userDetails.setCompanyName("Demo Brewing...");
			}
			int userid = userDetailsService.savenewuser(userDetails);//save user
			
			//save admloginrights table
			AdmLoginRights admLoginRights = new AdmLoginRights();
			
			admLoginRights.setUserId(userid);
			admLoginRights.setRightsId(userDetails.getRoleid());
			admLoginRights.setStatus("1");
			admLoginRightsService.saveLoginRights(admLoginRights);
			

			String subject="Welcome to AirOpcenter";
			String name=userDetails.getName();
			
			System.out.println("The company name :"+masthead.getCompanyName());
			if(!masthead.getCompanyName().equalsIgnoreCase("")) {
				companyname=masthead.getCompanyName();
				System.out.println("Inside company---- :"+masthead.getCompanyName());
			}
			else {
				companyname="AirOpcenter...";
			}


			if(!userDetails.getUserName().equalsIgnoreCase(""))
			{
				username=userDetails.getUserName();
			}
			if(!userDetails.getEmail().equalsIgnoreCase(""))
			{
				toemai=userDetails.getEmail();
			}

			Vector<String> cctoadd =new Vector<String>();

			cctoadd.add(Defs.SUPPORT_CC_EMAIL_1);
			cctoadd.add(Defs.SUPPORT_CC_EMAIL_2);//(change it under help>Change Password)

				String body="Dear "+name+"<br/><br/>" +
										
						"Username : "+username+"<br/>" +
						"Password : "+username+" <br/><br/>" +
												
						""+createdBy+" of "+companyname+" has just added you to BeerRun.<br/><br/>"+
						
						
						"Where you can find help:<br/><br/>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. If you have any questions, you can write Sunny at sunny@beerrunsoftware.com.<br/><br/>" +
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. We can conduct training for your designated BeerRun Administrator and whoever else cares to join.<br/> " +
			
						"Your email address will be added to our updates email list.  We will never sell or give away your information.  This list will only be used for major AirOpcenter announcements."+
						"If you do not want to be on that list - you can either mail support@beerrunsoftware.com or the unsubscribe link at the bottom of the announcement emails.<br/><br/>"+			
	
						"We're glad you're here!<br/>"+
						"Your AirOpcenter team";

			emailsend obj_emailsend = new emailsend();
			//obj_emailsend.welcomeusermail(toemai, cctoadd, subject, body);
		}catch (Exception e) { e.printStackTrace();}

		attributes.addFlashAttribute("success", "User Added Successfully !!!");
		return new ModelAndView("redirect:/users/userlist");

	}



	@RequestMapping(value= {"/edituser"},method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateuser(UserDetails userDetails,RoleDetails roleDetails,RedirectAttributes attributes,@RequestParam("userid") int userid)
	{
		userDetailsService.edituser(userDetails);
		
		int roleid=roleDetails.getRoleid();
		System.out.println("roleid----"+roleid);
		
		userDetailsService.roleupdate(roleid,userid);

		attributes.addFlashAttribute("success", "Update User Successfully !!!");
		return new ModelAndView("redirect:/users/userlist");
	}

	@RequestMapping(value= {"/getdeleteuser"},method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteuser(@RequestParam("id") int userrefno,RedirectAttributes attributes,ModelMap model)
	{
//		userDetailsService.deleteuser(userrefno);
//		attributes.addFlashAttribute("success", "Update User Successfully !!!");
	
		model.addAttribute("userrefno",userrefno);
		System.out.println("model---"+model);
		return new ModelAndView("admin/user/delete-user");
	}

	@RequestMapping(value= {"/deleteuser"},method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView deleteuserlist(@RequestParam("refnumber") int userrefno,RedirectAttributes attributes)
	{
		System.out.println("ente delete---"+userrefno);
		userDetailsService.deleteuser(userrefno);
		attributes.addFlashAttribute("success", "Delete User Successfully !!!");
		
		return new ModelAndView("redirect:/users/userlist");
	}

	//edit load

	@RequestMapping(value = { "/getEditUserList" }, method = RequestMethod.GET)
	public String edituserlist(@RequestParam("id") int userrefno,ModelMap model)
	{

		try
		{

			UserDetails userDetails=userDetailsService.findById(userrefno);
			model.addAttribute("userDetails",userDetails);


			List<RoleDetails>roleList=roledetails.getrolelist();
			model.addAttribute("roleList",roleList);		

			return "admin/user/user-edit";

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}


	@RequestMapping(value = { "/userAlreadyExists" }, method = RequestMethod.POST)
	@ResponseBody
	public UserDetails packAlreadyExists(@RequestParam(value = "req") String userName,HttpServletRequest req) {

		req.setAttribute("tenantId", "tenantId1");
		System.out.println("already exist"+userName);
		UserDetails userDetails = userDetailsService.findByUserName(userName);

		return userDetails;

	}

	@RequestMapping(value = { "/viewUserList" }, method = RequestMethod.GET)
	public String viewUserList(@RequestParam("roleid") int roleid,@RequestParam("roleName") String roleName,Model model)
	{

		try
		{
			List<Object> roleuserNameList=roleDetailServices.getroleIdUserdetailsList(roleid);
			roleuserNameList=roleuserNameList==null?new ArrayList<>():roleuserNameList;
			model.addAttribute("roleuserNameList",roleuserNameList);
			model.addAttribute("roleName",roleName);

			return "admin/roles/view-user";

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	@RequestMapping(value = { "/saveupdaterole" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String SaveUpdateRole(@RequestParam("roleid") int roleid,@RequestParam("roleName") String roleName,@RequestParam("status") int status,Model model,HttpServletRequest request, RedirectAttributes redirectAttributes)
	{
		try
		{
			String roleDetailIds[]=request.getParameterValues("role_detail_id");
			roleDetailIds=roleDetailIds==null?new String[]{}:roleDetailIds;

			String navigation_ids=ArchUtils.getStringArrayToString(roleDetailIds,",");

			System.out.println("status===>"+status);
			System.out.println("navigation_ids===>"+navigation_ids);
			System.out.println("roleid===>"+roleid);
			System.out.println("roleName===>"+roleName);

			RoleDetails roleDetails = new RoleDetails();

			roleDetails.setRoleName(roleName);
			roleDetails.setCreatedBy("Super Admin");
			roleDetails.setRoleid(roleid);
			roleDetails.setNavigationIds(navigation_ids);
			if(roleid==0) {
				roleDetails.setStatus(1);
			}else {
				roleDetails.setStatus(status);
			}
			roleDetailServices.saveRole(roleDetails);

			if(roleid==0) {
				redirectAttributes.addFlashAttribute("success", "Role Created Successfully !!!");
			}else
			{
				redirectAttributes.addFlashAttribute("success", "Role Updated Successfully !!!");
			}

			return "redirect:/users/roles";
		}catch (Exception e) {

		}
		/*try
		{
			List<Object> roleuserNameList=roleDetailServices.getroleIdUserdetailsList(roleid);
			roleuserNameList=roleuserNameList==null?new ArrayList<>():roleuserNameList;
			model.addAttribute("roleuserNameList",roleuserNameList);
			model.addAttribute("roleName",roleName);

			return "admin/roles/view-user";

		}
		catch(Exception e)
		{
			System.out.println(e);
		}*/


		return null;
	}

	@RequestMapping(value = { "/editUserList" }, method = RequestMethod.GET)
	public String editUserList(@RequestParam(value="roleName") String roleName,@RequestParam(value="roleid") int roleid,Model model)
	{
		System.out.println("roleName==>"+roleName+"  roleid--->"+roleid);
		try
		{
			List<ApplicationMenu> menuList=applicationMenuService.getApplicationMenuList("");
			menuList=menuList==null?new ArrayList<ApplicationMenu>():menuList;

			Map NavigationsMap=ArchUtils.ListToLinkedHashMap(menuList,Arrays.asList(new String[]{"navigationId"}),"");
			NavigationsMap=NavigationsMap==null?new LinkedHashMap<String, ApplicationMenu>():NavigationsMap;
			model.addAttribute("NavigationsMap",NavigationsMap);

			Map<String,String> parentchildmap=applicationMenuService.getparentchildMaps("");
			parentchildmap=parentchildmap==null?new LinkedHashMap<String, String>():parentchildmap;
			model.addAttribute("parentchildmap",parentchildmap);

			String navids="";
			RoleDetails roledetails=null;
			if(roleid!=0)
			{
				roledetails=roleDetailServices.findByroleId(roleid);
			}
			roledetails=roledetails==null?new RoleDetails():roledetails;
			model.addAttribute("roledetails",roledetails);


			Map<String,String> roleparentchildmap=null;
			navids=roledetails.getNavigationIds();
			navids=navids==null?"":navids;

			roleparentchildmap=applicationMenuService.getParentChildNavicationMap("",navids);	
			roleparentchildmap=roleparentchildmap==null?new LinkedHashMap<String, String>():roleparentchildmap;
			model.addAttribute("roleparentchildmap",roleparentchildmap);

			List rolenavidList=ArchUtils.getTokensList(navids, ",");
			model.addAttribute("rolenavidList",rolenavidList);

			return "admin/roles/edit-user";

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public static void RoleMenuTree(JspWriter out, Map<String,ApplicationMenu> NavigationMaps,Map<String,String> parentchildmap,int parentid,Map<String,String> roleparentchildmap,List<String> rolenavidList) throws ServletException, IOException {


		String childlist=ArchUtils.nullCheck(parentchildmap.get(""+parentid));
		List<String> childs=ArchUtils.getTokensList(childlist, ",");
		childs=(List<String>) (childs==null?new ArrayList<>():childs);

		for(String childid:childs)
		{

			ApplicationMenu bean=NavigationMaps.get(childid);
			String parent="data-tt-parent-id='"+parentid+"'";
			out.print("<tr data-tt-id='"+bean.getNavigationId()+"' "+parent+" >" ); 
			boolean checkboxEnable=false;
			/* for(String rolechild:rolechilds)
				{*/
			if(UserController.IsCheckParentEnable(bean.getNavigationId()+"",roleparentchildmap,NavigationMaps)){
				// break;
				checkboxEnable=true;
			}
			else
			{
				checkboxEnable=false; 
			}
			/*}*/

			if(rolenavidList.contains(bean.getNavigationId()+"")) { 
				checkboxEnable=true; 
			}

			switch(bean.getLevel())
			{
			case "1":

				out.print("<th>"+bean.getNavigationName()+"</th>");
				out.print("<th class='text-center'>");
				out.print("<label class='switch roles-switch'>");
				out.print("<input type='checkbox' id='checkEnableId_"+bean.getNavigationId()+"' class='checkEnable' level='1' parentId='"+bean.getParentNavigationId()+"' currentId='"+bean.getNavigationId()+"' ");
				if(bean.isLeaf()) {
					out.print(" name='role_detail_id' value='"+bean.getNavigationId()+"' ");
				}		

				if(checkboxEnable)
				{
					out.print(" checked ");
				}
				out.print(">");

				out.print("<span class='slider slider-gst round'></span>");
				out.print("</label>");
				out.print("</th>");

				break;

			case "2":

				out.print("<th class='tr-color'>"+bean.getNavigationName()+"</th>");
				out.print("<th class='text-center'>");
				out.print("<label class='switch roles-switch'>");
				out.print("<input  type='checkbox'  id='checkEnableId_"+bean.getNavigationId()+"' class='checkEnable checkEnable_"+bean.getParentNavigationId()+" checkEnable_"+bean.getNavigationId()+"  ' level='2' parentId='"+bean.getParentNavigationId()+"' currentId='"+bean.getNavigationId()+"' ");
				if(bean.isLeaf()) {
					out.print(" name='role_detail_id' value='"+bean.getNavigationId()+"' ");
				}	
				if(checkboxEnable)
				{
					out.print(" checked ");
				}
				out.print(">");

				out.print("<span class='slider slider-gst round'></span>");
				out.print("</label>");
				out.print("</th>");

				break;

			case "3":

				out.print("<th class='tr-color-red'>"+bean.getNavigationName()+"</th>");
				out.print("<th class='text-center'>");
				out.print("<label class='switch roles-switch'>");
				out.print("<input  type='checkbox'  id='checkEnableId_"+bean.getNavigationId()+"' class='checkEnable   checkEnable_"+bean.getParentNavigationId()+" checkEnable_"+bean.getNavigationId()+" ' level='3' parentId='"+bean.getParentNavigationId()+"' currentId='"+bean.getNavigationId()+"' ");
				if(bean.isLeaf()) {
					out.print(" name='role_detail_id' value='"+bean.getNavigationId()+"' ");
				}	
				if(checkboxEnable)
				{
					out.print(" checked ");
				}
				out.print(">");

				out.print("<span class='slider slider-gst round'></span>");
				out.print("</label>");
				out.print("</th>");

				break;

			}

			out.print("</tr>");


			if(!bean.isLeaf())
			{
				String navchildlist=ArchUtils.nullCheck(parentchildmap.get(""+bean.getNavigationId()));
				List<String> navchilds=ArchUtils.getTokensList(navchildlist, ",");
				if(navchilds!=null && navchilds.size()!=0)
					RoleMenuTree(out,NavigationMaps,parentchildmap,bean.getNavigationId(),roleparentchildmap,rolenavidList);
			}
		} 
	}
	
	@RequestMapping(value= {"/getForgetPassword"},method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getEmailForForgetPossword(@RequestParam("email") String email,RedirectAttributes attributes,HttpSession session,HttpServletRequest req, HttpServletResponse res) throws MessagingException
	{
		ModelAndView modelAndView = null;
		req.setAttribute("tenantId", "tenantId1");
		UserDetails userDetails = userDetailsService.sendForgetPassword(email);

		String user="",pass="",toemail="",ccemail="",bccemail="",subject="",content="",pdfname="",file="";
		
		toemail = email;
		user = Defs.AUTHENTICATOR_EMAIL_ADDRESS;
		pass = Defs.AUTHENTICATOR_EMAIL_PASSWORD;
		
		subject = "BeerRun UserName and Password.";
		content = "User Name :" + userDetails.getUserName().toString()+"\n"+ "Password :" +userDetails.getPassword().toString()+"\n\n\n";
		content = content + "Best wishes\n";
		content = content + "Beerrun Support Team.";
		
		if(userDetails.getEmail() != null) {
		emailsend obj_emailsend = new emailsend();
		//obj_emailsend.sendMail(user, pass, toemail, ccemail, bccemail,  subject,  content,  pdfname, file);
		
		modelAndView = new ModelAndView("login-page");
		modelAndView.addObject("success", "Password has been sent to your mail");
		}else {
			attributes.addFlashAttribute("error", "Your email is not recognised");
		}
		return modelAndView;
	}
}
