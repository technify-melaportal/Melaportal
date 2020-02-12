<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.Random"%> 
       
       <link href="<%=request.getContextPath()%>/static/css/jquery-confirm.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/static/assets/plugins/dropify/css/dropify.min.css" rel="stylesheet">
<style>
.button {
  background-color: #eaf0f7;
  border: none;
  color: black;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  cursor: pointer;
}
</style>
       
 <!-- Page Content-->
 <div class="page-wrapper">
    <jsp:include page="../layout/left-navigation.jsp"></jsp:include>
            <div class="page-content">
			<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
                <div class="container-fluid">
                    <!-- Page-Title -->
                    <c:choose>
                     <c:when test="${ empty masthead.name}">
                    <form action="${pageContext.request.contextPath}/aboutUs/saveCompany" method="post" enctype="multipart/form-data" id="uploadfile">
                    </c:when>
               <c:otherwise>
               <form action="${pageContext.request.contextPath}/aboutUs/editCompany" method="post" enctype="multipart/form-data" id="uploadfile">
                </c:otherwise>
          		</c:choose>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="float-right">
                                    <ol class="breadcrumb">                                  
                                        <li class="breadcrumb-item">
                                        
											<button type="button" class="button" style="background-color: #0F67F0;border-radius: 25px;" id="btn_cancel"><h4 class="page-title"><span style="color: white">Cancel</span></h4></button> 
                                           &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="button" style="background-color: #0F67F0;border-radius: 25px;margin-right: 50px;" id="btn_save"><h4 class="page-title"><span style="color: white">Save</span></h4></button>
                                           
                                            <button type="button" class="button" style="background-color: #0F67F0;border-radius: 25px;" id="btn_edit"><h4 class="page-title"><span style="color: white">Edit</span></h4></button> 
                                                
                                           </li>
                                    </ol>
                                </div>
                                <h4 class="page-title">Company</h4>
                            </div><!--end page-title-box-->
                        </div><!--end col-->
                    </div>
                    <!-- end page title end breadcrumb -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">                  
                                   
                                   <div class="row">    
                                       <div class="col-lg-9">            
                                            	<div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company Legal Name</label>
                                                
                                             
                                                 <div class="col-lg-8" id="txt_name">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="name" autocomplete="off" value="${masthead.name}" required="required">
                                                    <input class="form-control form-control-sm" type="hidden" id="companyid" style="border-color: #656d9a" name="companyid" autocomplete="off" value="${masthead.companyid}">
                                                </div>
                                               
                                                 <div class="col-lg-8" id="lbl_name">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.name}</label>
                                                </div>
                                                                                                                                  
                                                </div>
			                                       
                                                <div class="form-group row">
                                                 <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company Short Name</label>
                                                
                                                  <div class="col-lg-5" id="txt_shortname">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="shortname" autocomplete="off" value="${masthead.shortname}" maxlength="15">
                                                </div>
                                                 <label for="example-text-input" class="col-sm-3 col-form-label text-left" id="lbl_limit">15 character limit</label>
                                                
                                                 <div class="col-lg-8" id="lbl_shortname">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.shortname}</label>
                                                </div>
                                                                                                
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company URL</label>
                                               
                                                 <div class="col-lg-8" id="txt_url">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="url" autocomplete="off" value="${masthead.url}">
                                                </div>
                                               
                                                <div class="col-lg-8" id="lbl_url">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.url}</label>
                                                </div>
                                                 
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company LinkedIn</label>
                                                
                                                 <div class="col-lg-8" id="txt_linkedin">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="linkedin" autocomplete="off" value="${masthead.linkedin}">
                                                </div>
                                                
                                                <div class="col-lg-8" id="lbl_linkedin">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.linkedin}</label>
                                                </div>
                                              
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">What we do</label>
                                                
                                                 <div class="col-lg-8" id="txt_description">
                                                    <textarea class="form-control form-control-sm txtval" id="example-text-input-sm" style="border-color: #656d9a" name="description" rows="4">${masthead.description}</textarea>
                                                </div>
                                                
                                                <div class="col-lg-8" id="lbl_description">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.description}</label>
                                                </div>
                                             
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Address</label>
                                               
                                                 <div class="col-lg-8" id="txt_address">
                                                     <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="address" autocomplete="off" value="${masthead.address}">
                                                </div>
                                               
                                                <div class="col-lg-8" id="lbl_address">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.address}</label>
                                                </div>
                                               
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left"></label>
                                              
                                                 <div class="col-lg-3" id="txt_city">
                                                     <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="city" placeholder="City" autocomplete="off" value="${masthead.city}">
                                                </div>
                                                
                                                <div class="col-lg-3" id="lbl_city">
                                                     <label for="example-text-input" class="col-sm-8 col-form-label text-left" style="color: black">${masthead.city}</label>
                                                </div>
                                                
                                                <div class="col-lg-2" id="txt_state">
                                                     <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="state" placeholder="St" autocomplete="off" value="${masthead.state}" maxlength="2">
                                                </div>
                                               
                                                <div class="col-lg-2" id="lbl_state">
                                                     <label for="example-text-input" class="col-sm-6 col-form-label text-left" style="color: black">${masthead.state}</label>
                                                </div>
                                               
                                                <div class="col-lg-3" id="txt_pincode">
                                                     <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="pincode" placeholder="Pincode" autocomplete="off" value="${masthead.pincode}">
                                                </div>
                                                
                                                <div class="col-lg-3" id="lbl_pincode">
                                                     <label for="example-text-input" class="col-sm-8 col-form-label text-left" style="color: black">${masthead.pincode}</label>
                                                </div>
                                               
                                               </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left"></label>
                                               
                                                <div class="col-lg-4">
                                                <label for="example-text-input" class="col-sm-12 col-form-label text-center">CEO</label>
                                                </div>
                                               
                                                <div class="col-lg-5">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-center">Co-founder(Optional)</label>
                                                </div>
                                                                                                
                                                 </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Name</label>
                                               
                                                <div class="col-lg-4" id="txt_ceoname">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="ceoname" autocomplete="off" value="${masthead.ceoname}">
                                                </div>
                                               
                                                <div class="col-lg-4" id="lbl_ceoname">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.ceoname}</label>
                                                </div>
                                              
                                                <!--  <label for="example-text-input" class="col-sm-1 col-form-label text-left" >LinkedIn</label> -->
                                               
                                                 <div class="col-lg-4" id="txt_ceolinkedin">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="ceolinkedin" autocomplete="off" value="${masthead.ceolinkedin}">
                                                </div>
                                               
                                                <div class="col-lg-4" id="lbl_ceolinkedin">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.ceolinkedin}</label>
                                                </div>
                                               
                                                 </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">LinkedIn</label>
                                                
                                                 <div class="col-lg-4" id="txt_cofoundername">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="cofoundername" autocomplete="off" value="${masthead.cofoundername}">
                                                </div>
                                               
                                                <div class="col-lg-4" id="lbl_cofoundername">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.cofoundername}</label>
                                                </div>
                                               
                                              <!--   <label for="example-text-input" class="col-sm-1 col-form-label text-left">LinkedIn</label> -->
                                              
                                                 <div class="col-lg-4" id="txt_cofounderlinkedin">
                                                    <input class="form-control form-control-sm txtval" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="cofounderlinkedin" autocomplete="off" value="${masthead.cofounderlinkedin}">
                                                </div>
                                              
                                                <div class="col-lg-4" id="lbl_cofounderlinkedin">
                                                     <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${masthead.cofounderlinkedin}</label>
                                                </div>
                                            
                                            </div><div class="form-group row" id="txt_business">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Business Card(Only for KYC. Will NOT be visible to students)</label>
                                                
                                                 <div class="col-lg-4">
                                                    <input type="file" id="input-file-now" class="dropify txtval" name="businesscard1" value="${masthead.businesscard1}"/> 
                                                </div>
                                               
                                                <div class="col-lg-4">
                                                     <input type="file" id="input-file-now" class="dropify txtval" name="businesscard2" value="${masthead.businesscard2}"/> 
                                                </div>
                                                                                             
                                            
                                            </div>
                                                                             
                                        </div>
	                                     
	                                 	<div class="col-lg-3" id="txt_companylogo">
	                                    	<input type="file" id="input-file-now" class="dropify txtval" name="companylogo" value="${masthead.companylogo}"/>   
	                                     	<!-- <label class="custom-file-label" for="customFile">Logo</label>	 -->	
	                                     	<label for="example-text-input" class="col-lg-3 col-form-label text-left">Logo</label>		                                 
	                                    </div>
	                                    
	                                    <div class="col-lg-3" id="lbl_companylogo">
	                                    	<img alt="companylogo" src="${masthead.companylogo}"> 
	                                     	<!-- <label for="example-text-input" class="col-lg-3 col-form-label text-left">Logo</label>	 -->	                                 
	                                    </div>
	                                    
			                                     
                                    
                                    </div> 
                                                                     
                                     <!--  <div class="row" style="height: 200px"></div>    -->                                 
                                </div><!--end card-body--> 
                            </div><!--end card--> 
                        </div> <!--end col-->                               
                    </div><!--end row-->     
				  </form>
				  
                </div><!-- container -->

            </div>
            <!-- end page content -->
</div>

<!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/static/assets/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/assets/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/assets/plugins/datatables/dataTables.bootstrap4.min.js"></script>	
		 <script src="<%=request.getContextPath()%>/static/js/jquery-confirm.js"></script> 
		 
		  <script src="<%=request.getContextPath()%>/static/assets/plugins/dropify/js/dropify.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/pages/jquery.form-upload.init.js"></script>
<script>
  // Datatable
  $('#datatable').DataTable();
  
  $(document).ready(function(){
  	 $(".msgg").fadeOut(5000); 
  	 var path = $("#path").val();
  	$("#aboutus").addClass("active");
	$('#aboutus').click();
	$("#company").addClass("active");
	$("#img-company").attr("src",path+"/static/assets/images/startup18blue.png");	
	
	var companyid = $("#companyid").val();
	if(companyid != ''){
		$("#btn_save").hide();
		$("#btn_cancel").hide();
		
		 $("#txt_name").hide();
			$("#txt_shortname").hide();
			$("#lbl_limit").hide();
			$("#txt_url").hide();
			$("#txt_linkedin").hide();
			$("#txt_description").hide();
			$("#txt_address").hide();
			$("#txt_city").hide();
			$("#txt_state").hide();
			$("#txt_pincode").hide();
			$("#txt_ceoname").hide();
			$("#txt_ceolinkedin").hide();
			$("#txt_cofoundername").hide();
			$("#txt_cofounderlinkedin").hide();
			$("#txt_business").hide();
			$("#txt_companylogo").hide();
			
			$("#lbl_name").show();
			$("#lbl_shortname").show();
			$("#lbl_url").show();
			$("#lbl_linkedin").show();
			$("#lbl_description").show();
			$("#lbl_address").show();
			$("#lbl_city").show();
			$("#lbl_state").show();
			$("#lbl_pincode").show();
			$("#lbl_ceoname").show();
			$("#lbl_ceolinkedin").show();
			$("#lbl_cofoundername").show();
			$("#lbl_cofounderlinkedin").show(); 
			$("#lbl_companylogo").show();
		    
	}else{
		$("#btn_save").show();
		$("#btn_cancel").show();
		$("#btn_edit").hide();
		
		 	$("#txt_name").show();
			$("#txt_shortname").show();
			$("#lbl_limit").show();
			$("#txt_url").show();
			$("#txt_linkedin").show();
			$("#txt_description").show();
			$("#txt_address").show();
			$("#txt_city").show();
			$("#txt_state").show();
			$("#txt_pincode").show();
			$("#txt_ceoname").show();
			$("#txt_ceolinkedin").show();
			$("#txt_cofoundername").show();
			$("#txt_cofounderlinkedin").show();
			$("#txt_business").show();
			$("#txt_companylogo").show();
			
			$("#lbl_name").hide();
			$("#lbl_shortname").hide();
			$("#lbl_url").hide();
			$("#lbl_linkedin").hide();
			$("#lbl_description").hide();
			$("#lbl_address").hide();
			$("#lbl_city").hide();
			$("#lbl_state").hide();
			$("#lbl_pincode").hide();
			$("#lbl_ceoname").hide();
			$("#lbl_ceolinkedin").hide();
			$("#lbl_cofoundername").hide();
			$("#lbl_cofounderlinkedin").hide(); 
			$("#lbl_companylogo").hide();
	}
  });

  $("#btn_edit").click(function( event ) {
	  	$("#btn_save").show();
	  	$("#btn_edit").hide();
	    $("#txt_name").show();
		$("#txt_shortname").show();
		$("#lbl_limit").show();
		$("#txt_url").show();
		$("#txt_linkedin").show();
		$("#txt_description").show();
		$("#txt_address").show();
		$("#txt_city").show();
		$("#txt_state").show();
		$("#txt_pincode").show();
		$("#txt_ceoname").show();
		$("#txt_ceolinkedin").show();
		$("#txt_cofoundername").show();
		$("#txt_cofounderlinkedin").show();
		$("#txt_business").hide();
		$("#txt_companylogo").show();
		
		$("#lbl_name").hide();
		$("#lbl_shortname").hide();
		$("#lbl_url").hide();
		$("#lbl_linkedin").hide();
		$("#lbl_description").hide();
		$("#lbl_address").hide();
		$("#lbl_city").hide();
		$("#lbl_state").hide();
		$("#lbl_pincode").hide();
		$("#lbl_ceoname").hide();
		$("#lbl_ceolinkedin").hide();
		$("#lbl_cofoundername").hide();
		$("#lbl_cofounderlinkedin").hide(); 
		$("#lbl_companylogo").hide();
  });
  
  $("#btn_cancel").click(function( event ) {
	  
	  $(".txtval").val('');
		
  });
 </script>


