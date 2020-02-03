<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">        
                    <!-- <h4 class="mt-0 header-title">Add User</h4> -->
                    
              		 <form method="post" action="<%=request.getContextPath()%>/users/deleterole" id="navigationfrm">
               		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
               					
                    <div class="row">
	                    <div class="col-lg-6">
	                        	<h6 class="mt-0 header-title">Are you sure ?</h6>
	           					 <input type="hidden" name="refnumber" id="userref" value="${roleid}">
	           			</div>
	                     <div class="col-lg-6">   
	                    
                           		<button type="submit" class="btn btn-primary" id="btnSubmit">Yes</button>
                             	<!-- <button type="button" class="btn btn-danger">Cancel</button>  -->
                             	
                         </div>
                    </div>  
                    </form>                                                                    
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
