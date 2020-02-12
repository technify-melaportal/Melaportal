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
                                   		 <input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="intershiptitle" autocomplete="off">
                                    </div>
                            </div>
                            
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Internship Short Name</label>
                                    <div class="col-sm-3">
                                   		 <input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="intershipshortname" autocomplete="off" maxlength="15">
                                    </div>
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">15 character limit</label>
                            </div>
                            
                             <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">Paid?</label>
	                                    <div class="col-sm-2">
	                                   		 <select class="custom-select" name="paid" required="required" style="border-color: #656d9a">
											<option value=''>Select</option>
											<option value='Yes'>Yes</option>
											<option value='No'>No</option>
										</select>
	                                    </div>
                            </div><div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">#Positions</label>
                                    <div class="col-sm-2">
                                   		 <select class="custom-select" name="positions" required="required" style="border-color: #656d9a">
										<option value=''>Select</option>
										<option value='1'>1</option>
										<option value='2'>2</option>
										<option value='3-5'>3-5</option>
										<option value='6-10'>6-10</option>
										<option value='10-20'>10-20</option>
										<option value='20+'>20+</option>
									</select>
                                    </div>
                            </div>
                                                              
                                  
                            <div class="form-group row">
                                     <label for="example-text-input" class="col-sm-3 col-form-label text-left">What you will do</label>
                                    <div class="col-sm-9">
                                   		 <textarea class="form-control form-control-sm" id="example-text-input-sm" style="border-color: #656d9a" name="description" rows="3"></textarea>
                                    </div>
                            </div>
                                           					                                    
					         <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left">Skills Required and level of proficiency</label>
								
								<div class="col-sm-3">
								<div class="form-group">
								<label for="example-url-input">Skills</label>
	                                <select name="skills" id="skills" class="custom-select" style="border-color: #656d9a" onchange="addskills()">
										<option value="">Select</option>
										<c:forEach items="${skillList}" var="skill">
											<option value='${skill.skillname}'>${skill.skillname}</option>
										</c:forEach>
										<option value=''>Add New</option>	
									</select>
									
									<div class="add-options-skills">
										<input class="form-column-xl form-control" name="addnew_skills"
											id="addnew_skills" type="text" style="border-color: #656d9a"/> <a
											role="button" onclick="new_skills()">Save</a>&nbsp;&nbsp;&nbsp;&nbsp; <a role="button"
											class="icon icon-btn icon" id="cancel_skills">Cancel</a>
									</div>
					
									<div id="alert_skills">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<h6 style="color: red; text-align: center">
											<strong id="addNewAlert_skills"></strong>
										</h6>
									</div>
                            	
                                 </div>
                                 </div><div class="col-sm-3">
                                 <div class="form-group">             
                                     <label for="example-text-input">Importance</label>
                                     <select name="importance" id="importance" class="custom-select" style="border-color: #656d9a">
											<option value="">Select</option>
											<c:forEach items="${importanceList}" var="list">
											<option value='${list.importancename}'>${list.importancename}</option>
											</c:forEach>
										</select>
                                   
                                   
                                  </div>
                                  </div><div class="col-sm-3">
                                  <div class="form-group">
                                     <label for="example-text-input">Proficiency</label>
	                                <select name="proficiency" id="proficiency" class="custom-select" style="border-color: #656d9a">
										<option value="">Select</option>
										<c:forEach items="${proficiencyList}" var="list">
											<option value='${list.proficiencyname}'>${list.proficiencyname}</option>
										</c:forEach>
									</select>
                            
                               </div>
                               </div>
                               <!-- <div class="col-sm-3">
                                <div class="form-group">
                                     <label for="example-text-input">Explanatory Note</label>
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div> 
                                    
					        </div>	 -->		    
                           </div>                                        
                           <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-3">
								<div class="form-group">
	                                    <select name="skills1" id="skills1" class="custom-select" style="border-color: #656d9a">
										<option value="">Select</option>
										<c:forEach items="${skillList}" var="skill">
											<option value='${skill.skillname}'>${skill.skillname}</option>
										</c:forEach>
									</select>
                                 </div>
                                 </div><div class="col-sm-3">
                                 <div class="form-group">             
                                   	<select name="importance1" id="importance1" class="custom-select" style="border-color: #656d9a">
											<option value="">Select</option>
											<c:forEach items="${importanceList}" var="list">
											<option value='${list.importancename}'>${list.importancename}</option>
											</c:forEach>
										</select>
                                    
                                  </div>
                                  </div><div class="col-sm-3">
                                  <div class="form-group">
									<select name="proficiency1" id="proficiency1" class="custom-select" style="border-color: #656d9a">
										<option value="">Select</option>
										<c:forEach items="${proficiencyList}" var="list">
											<option value='${list.proficiencyname}'>${list.proficiencyname}</option>
										</c:forEach>
									</select>
                            
                               </div>
                               </div>
                               <!-- <div class="col-sm-3">
                               <div class="form-group">
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>	 -->
					        </div>
					        <div class="form-group row">
								<label for="example-text-input" class="col-sm-3 col-form-label text-left"></label>
								<div class="col-sm-3">
								<div class="form-group">
	                                   <select name="skills2" id="skills2" class="custom-select" style="border-color: #656d9a">
										<option value="">Select</option>
										<c:forEach items="${skillList}" var="skill">
											<option value='${skill.skillname}'>${skill.skillname}</option>
										</c:forEach>
									</select>
                            
                                 </div>
                                 </div><div class="col-sm-3">
                                 <div class="form-group">             
                                   		<select name="importance2" id="importance2" class="custom-select" style="border-color: #656d9a">
											<option value="">Select</option>
											<c:forEach items="${importanceList}" var="list">
											<option value='${list.importancename}'>${list.importancename}</option>
											</c:forEach>
										</select>
                                    
                                  </div>
                                  </div><div class="col-sm-3">
                                  <div class="form-group">
									<select name="proficiency2" id="proficiency2" class="custom-select" style="border-color: #656d9a">
										<option value="">Select</option>
										<c:forEach items="${proficiencyList}" var="list">
											<option value='${list.proficiencyname}'>${list.proficiencyname}</option>
										</c:forEach>
									</select>
                            
                               </div>
                               </div>
                               <!-- <div class="col-sm-3">
                               <div class="form-group">
                                   	<input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" autocomplete="off">
                              </div>
                                    
					        </div>	 -->
					        </div>
					        
                            
                            <div class="col-sm-6 ml-auto">
	                            <button type="submit" class="btn btn-primary" id="btnSubmit"> Save </button>
                             </div>                                      
                        </div>
                    </div>  
                    </form>                                                                    
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
    
   <script src="<%=request.getContextPath() %>/static/script/addNew.js"></script>
