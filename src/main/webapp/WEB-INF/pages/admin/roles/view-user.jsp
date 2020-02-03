<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-content">
<div class="container-fluid">
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">                  
                <div class="table-responsive dash-social">
                    <table id="datatable" class="table">
                        <thead>
                        	<tr>
                           		<th><h4 style="color: black;font-weight: bold;">${roleName}</h4></th>
                           	</tr>
                            </thead>

                            <tbody>
                               <c:forEach items="${roleuserNameList}" var="roleuserNameListItr" varStatus="sno">
				                  <tr>
									<th>${roleuserNameListItr[1]}</th>
								  </tr>
								</c:forEach>                              
                          </tbody>
                      </table>                    
                  </div>                                         
              </div><!--end card-body--> 
          </div><!--end card--> 
      </div> <!--end col-->                               
  </div><!--end row-->    
 </div>
 </div> 
  