<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">        
                    <!-- <h4 class="mt-0 header-title">Add User</h4> -->
                    
              		 <form method="post" action="<%=request.getContextPath()%>/users/edituser" id="navigationfrm">
               		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
               					
                    <div class="row">
                        <div class="col-lg-6">
                            
                              <div class="form-group">
                                <label for="example-search-input">Email</label>
                                    <input class="form-control" type="text" name="email" value="${userDetails.email }"/>
									<input type="hidden" name="userid" value="${userDetails.userrefno }"/>
									<input type="hidden" name="userrefno" value="${userDetails.userrefno }" />
                            </div> 
                                                                       
                        </div>
	
	
                        <div class="col-lg-6">
                         	
                            <div class="form-group">
                                <label for="example-url-input">Role</label>
                                       <select class="custom-select" name="roleid" id="role" required  data-msg-required='Role is Required'>
										  <option value="">Select</option>
										 <c:forEach items="${roleList}" var="list">
										   <option value='${list.roleid}' <c:if test="${list.roleid ==userDetails.roleid}">selected</c:if>>${list.roleName}</option>
										 </c:forEach>
                                        </select>
                            </div> 
                               
                            
                            <button type="submit" class="btn btn-primary" id="btnSubmit">Update</button>
                             <!-- <button type="button" class="btn btn-danger">Cancel</button>  -->
                                                                          
                        </div>
                    </div>  
                    </form>                                                                    
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
    
    