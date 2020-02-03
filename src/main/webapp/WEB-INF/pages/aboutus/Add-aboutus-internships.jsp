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
              		 <form method="post" action="<%=request.getContextPath()%>/aboutUs/saveInternship" id="navigationfrm">
               		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
               					
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group row">
                                <label for="example-text-input" class="col-sm-3 col-form-label text-left">Internship Title</label>
                                    <div class="col-sm-8">
                                   		 <input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                                    </div>
                            </div>
                            
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Internship Short Name</label>
                                    <div class="col-sm-4">
                                   		 <input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                                    </div>
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">15 character limit</label>
                            </div>
                            
                             <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Paid?</label>
	                                    <div class="col-sm-3">
	                                   		 <select class="custom-select" name="paid" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
	                                    </div>
                            
                                     <label for="example-text-input" class="col-sm-2 col-form-label text-left">#Positions</label>
                                    <div class="col-sm-3">
                                   		 <select class="custom-select" name="position" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                    </div>
                            </div>
                                  
                                  
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Department</label>
	                                    <div class="col-sm-3">
	                                   		 <select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
	                                    </div>
                            
                                     <label for="example-text-input" class="col-sm-2 col-form-label text-left">Year</label>
                                    <div class="col-sm-3">
                                   		 <select class="custom-select" name="year" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                    </div>
                            </div>
                                  
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">What you will do</label>
                                    <div class="col-sm-9">
                                   		 <textarea class="form-control form-control-sm" id="example-text-input-sm" style="border-color: #656d9a" name="whatyouwilldo" rows="8"></textarea>
                                    </div>
                            </div>
                                           					                                    
					         <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left">Bills Required and level of proficiency</label>
								
								<div class="col-sm-2">
								<div class="form-group">
								<label for="example-url-input">Skills</label>
	                                    <select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            	
                                 </div>
                                 </div><div class="col-sm-2">
                                 <div class="form-group">             
                                     <label for="example-text-input">Importance</label>
                                   	<select class="custom-select" name="year" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                   
                                  </div>
                                  </div><div class="col-sm-2">
                                  <div class="form-group">
                                     <label for="example-text-input">Proficiency</label>
	                                   	<select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                               </div>
                               </div><div class="col-sm-3">
                               <div class="form-group">
                                     <label for="example-text-input">Explanatory Note</label>
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>			    
                           </div>                                        
                           <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-2">
								<div class="form-group">
	                                    <select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                                 </div>
                                 </div><div class="col-sm-2">
                                 <div class="form-group">             
                                   	<select class="custom-select" name="year" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                    
                                  </div>
                                  </div><div class="col-sm-2">
                                  <div class="form-group">
	                                   	<select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                               </div>
                               </div><div class="col-sm-3">
                               <div class="form-group">
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>	
					        </div>
					        <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-2">
								<div class="form-group">
	                                    <select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                                 </div>
                                 </div><div class="col-sm-2">
                                 <div class="form-group">             
                                   	<select class="custom-select" name="year" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                    
                                  </div>
                                  </div><div class="col-sm-2">
                                  <div class="form-group">
	                                   	<select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                               </div>
                               </div><div class="col-sm-3">
                               <div class="form-group">
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>	
					        </div>
					        <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-2">
								<div class="form-group">
	                                    <select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                                 </div>
                                 </div><div class="col-sm-2">
                                 <div class="form-group">             
                                   	<select class="custom-select" name="year" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                    
                                  </div>
                                  </div><div class="col-sm-2">
                                  <div class="form-group">
	                                   	<select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                               </div></div>
                               <div class="col-sm-3">
                               <div class="form-group">
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>	
					        </div>
					        <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-2">
								<div class="form-group">
	                                    <select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                                 </div></div>
                                 <div class="col-sm-2">
                                 <div class="form-group">             
                                   	<select class="custom-select" name="year" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='I'>I</option>
										<option value='D'>D</option>
									</select>
                                    
                                  </div></div>
                                  <div class="col-sm-2">
                                  <div class="form-group">
	                                   	<select class="custom-select" name="department" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Y'>Yes</option>
											<option value='N'>No</option>
										</select>
                            
                               </div></div>
                               <div class="col-sm-3">
                               <div class="form-group">
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>	
                            </div>
                            
                            <div class="col-sm-6 ml-auto">
	                            <button type="submit" class="btn btn-primary" id="btnSubmit">Save </button>
                             </div>                                      
                        </div>
                    </div>  
                    </form>                                                                    
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
                   