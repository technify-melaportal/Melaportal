<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="com.beerrun.admin.controller.UserDetailsController"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<%=request.getContextPath()%>/static/css/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/custom.css"  rel="stylesheet" />

<div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">        
                <form method="post" action="<%=request.getContextPath()%>/users/saveupdaterole" id="navigationfrm">
                    <!-- <h4 class="mt-0 header-title">Add User</h4> -->
                    <h4 class="mt-0 header-title">Role Name :   
					<c:if test="${roledetails.roleid==0}">
					<input type='text' name="roleName" value="${roledetails.roleName}">					
					</c:if>
					<c:if test="${roledetails.roleid!=0}">
					${roledetails.roleName}		
					<input type='hidden' name="roleName" value="${roledetails.roleName}">	
					</c:if>					
					</h4>
              		 
              		 <input type='hidden' name="roleid" value="${roledetails.roleid}">
					<input type='hidden' name="status" value="${roledetails.status}">
               		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
               					
                                                   <!--  <div class="custom-control custom-checkbox">
                                                        <input type="checkbox" class="custom-control-input checkEnable" id="checkEnableId_" data-parsley-multiple="groups" data-parsley-mincheck="2">
                                                        <label class="custom-control-label" for="horizontalCheckbox"></label>
                                                    </div> -->
                                            
	                    <div class="table-responsive dash-social">
	                    <table id="datatable" class="table">
	                        <thead>
	                        	<tr>
	                           		<th><h4 style="color: black;font-weight: bold;">Menu Name</h4></th>
									<th class='text-center'><h4 style="color: black;font-weight: bold;">Action</h4></th>
	                           	</tr>
	                            </thead>
	
	                            <tbody>
	                               <%
									Map parentchildmap=(Map)request.getAttribute("parentchildmap");
									Map NavigationsMap=(Map)request.getAttribute("NavigationsMap");
									Map roleparentchildmap=(Map)request.getAttribute("roleparentchildmap");
									List rolenavidList=(List)request.getAttribute("rolenavidList");
									UserDetailsController.RoleMenuTree(out,NavigationsMap,parentchildmap,1,roleparentchildmap,rolenavidList);
									//System.out.println("roleparentchildmap===>"+roleparentchildmap);
									//System.out.println("rolenavidList===>"+rolenavidList);
									
							       %>   
							                                 
	                          </tbody>
	                      </table>                    
	                  	</div>   
                                                         
                            <button type="submit" class="btn btn-primary" id="btnSubmit">Update</button>
                           </form>                                                  
                                                                                     
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
    
    <script>
    
    $(".checkEnable").change(function(){
    	 var checkEnableid= this.id;
    	 console.log("checkEnableid====>"+checkEnableid);	
    	 var level=$(this).attr('level');
    	 console.log("level====>"+level);	
    	 var parentId=$(this).attr('parentId');
    	 console.log("parentId====>"+parentId);	
    	 var currentId=$(this).attr('currentId');
    	 console.log("currentId====>"+currentId);	
    	
   	 if ($(this).is(':checked')){
   		 //ON
   		
   		 console.log("ON");	
   		
   		 if(level=="1"){
   	   	
   	   	
   		 $(".checkEnable_"+currentId).each(function(){
			
   			var checkEnableid1= this.id;
       	// console.log("checkEnableid1====>"+checkEnableid1);	
       	 var level1=$(this).attr('level');
       	// console.log("level1====>"+level1);	
       	 var parentId1=$(this).attr('parentId');
       	// console.log("parentId1====>"+parentId1);	
       	 var currentId1=$(this).attr('currentId');
       	// console.log("currentId1====>"+currentId1);	
     
     	 $(".checkEnable_"+currentId1).prop("checked", true);// On 2,3rd level
       	 
		});	
   		 
   		 }
   		
   		 if(level=="2"){
   			 var n = $('.checkEnable_'+parentId+':checkbox:checked' ).length; 
   			 if(n==1)
				 {
				 $("#checkEnableId_"+parentId).prop("checked", true);//on level 1
				 }
   			 $(".checkEnable_"+currentId).prop("checked", true);// on level2
   			 
   		 }
   		 
   		
   		 if(level=="3"){
   			 var n = $('.checkEnable_'+parentId+':checkbox:checked' ).length; 
   			 if(n==1)
				 {
				 $("#checkEnableId_"+parentId).prop("checked", true);//On level2
				var c= $('#checkEnableId_'+parentId).attr('parentId');
				 $("#checkEnableId_"+c).prop("checked", true);//On Top level 1
				 
				 }
   			 $(".checkEnable_"+currentId).prop("checked", true);//On Level 3
   			
   		 }
   		 
   		 
   		
   	 }
   	 /******************************************/
   	 else {	
   		 //OFF
   	  
   		 console.log("OFF====>");	
   		 
   		 if(level=="1"){ 
   		 $(".checkEnable_"+currentId).each(function(){
 			
    		var checkEnableid1= this.id;
        	// console.log("checkEnableid1====>"+checkEnableid1);	
        	 var level1=$(this).attr('level');
        	// console.log("level1====>"+level1);	
        	 var parentId1=$(this).attr('parentId');
        	// console.log("parentId1====>"+parentId1);	
        	 var currentId1=$(this).attr('currentId');
        	// console.log("currentId1====>"+currentId1);	
        	
      	 $(".checkEnable_"+currentId1).prop("checked", false);// off 2,3 level
        	 
 		});		
   		 }
   		 
   		 
   		 if(level=="2"){
   			 var n = $('.checkEnable_'+parentId+':checkbox:checked' ).length; 
   			 console.log("nnn====>"+n);
   			 if(n==0)
   				 {
   				 $("#checkEnableId_"+parentId).prop("checked", false);//OFF level 1
   				 }
   			 
   			 $(".checkEnable_"+currentId).prop("checked", false);//OFF level 3
   		 }
   		 
   		 
   		 if(level=="3"){
   			 var n = $('.checkEnable_'+parentId+':checkbox:checked' ).length; 
   			// alert("off eee===>"+n);
   			 if(n==1)
			 {
			 $("#checkEnableId_"+parentId).prop("checked", false);//OFF level 2
			
			 			 
			 var c= $('#checkEnableId_'+parentId).attr('parentId');
			// alert("off eee  cs ss===>"+c);
			 
			 var nt = $('.checkEnable_'+c+':checkbox:checked' ).length; 
			// alert("off ntnt   cs ss===>"+nt);
			 
				 if(nt==0)
				 {
				 $("#checkEnableId_"+c).prop("checked", false);//OFF Top level 1
				 }
			 
			 }
			 $(".checkEnable_"+currentId).prop("checked", false);//OFF Level 3
   		 }
   		 
   		 
   	 }
   });
    
    </script>