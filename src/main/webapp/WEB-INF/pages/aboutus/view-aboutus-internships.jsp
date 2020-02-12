<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Random"%>

<div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">        
                    <!-- <h4 class="mt-0 header-title">Add User</h4> -->
              		 <form method="post" action="<%=request.getContextPath()%>/aboutUs/updateInternship" id="navigationfrm">
               		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
               			
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group row">
                                <label for="example-text-input" class="col-sm-3 col-form-label text-left">Internship Title</label>
                                    <div class="col-sm-8">
                                   		 <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${inheader.intershiptitle}</label>
                                    </div>
                            </div>
                            
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Internship Short Name</label>
                                    <div class="col-sm-4">
                                   		<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${inheader.intershipshortname}</label>
                                    </div>
                            </div>
                            
                             <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Paid?</label>
	                                    <div class="col-sm-4">
	                                   		<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${inheader.paid}</label>
	                                    </div>
                            </div><div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">#Positions</label>
                                    <div class="col-sm-4">
                                   		<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${inheader.positions}</label>
                                    </div>
                            </div>
                                                              
                                  
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">What you will do</label>
                                    <div class="col-sm-9">
                                   		<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${inheader.description}</label>
                                    </div>
                            </div>
                                           					                                    
					         <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left">Skills Required and level of proficiency</label>
								
								<div class="col-sm-3">
								<div class="form-group">
								<label for="example-url-input">Skills</label>
	                                <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[0].skills}</label>
                            	
                                 </div>
                                 </div><div class="col-sm-3">
                                 <div class="form-group">             
                                     <label for="example-text-input">Importance</label>
                                   	<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[0].importance}</label>
                                   
                                  </div>
                                  </div><div class="col-sm-3">
                                  <div class="form-group">
                                     <label for="example-text-input">Proficiency</label>
	                                   	<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[0].proficiency}</label>
                            
                               </div>
                               </div>
                               	    
                           </div>                                        
                           <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-3">
								<div class="form-group">
	                                   <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[1].skills}</label>
                                 </div>
                                 </div><div class="col-sm-3">
                                 <div class="form-group">             
                                   	<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[1].importance}</label>
                                  </div>
                                  </div><div class="col-sm-3">
                                  <div class="form-group">
	                                   <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[1].proficiency}</label>
                               </div>
                               </div>
                              
					        </div>
					        <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-3">
								<div class="form-group">
	                                   <label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[2].skills}</label>
                            
                                 </div>
                                 </div><div class="col-sm-3">
                                 <div class="form-group">             
                                   	<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[2].importance}</label>
                                    
                                  </div>
                                  </div><div class="col-sm-3">
                                  <div class="form-group">
	                                   	<label for="example-text-input" class="col-sm-12 col-form-label text-left" style="color: black">${line[2].proficiency}</label>
                            
                               </div>
                               </div>
                            
					        </div>
					        
                        </div>
                    </div>  
                    </form>                                                                    
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
                   