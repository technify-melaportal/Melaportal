 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.Random"%> 
       
        <link href="<%=request.getContextPath()%>/static/css/jquery-confirm.css" rel="stylesheet">
        
 <!-- Page Content-->
 <div class="page-wrapper">
    <jsp:include page="../../layout/left-navigation.jsp"></jsp:include>
            <div class="page-content">
			<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
                <div class="container-fluid">
                    <!-- Page-Title -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="float-right">
                                    <ol class="breadcrumb">
                                    <ul><a onclick="addPopup()" style="margin: 5px;font-weight: bold;" href="#">+ Add New</a></ul>
                                     <ul><a id="excelExport" onclick="exportTableToExcel('datatable', 'Roles_List',[2, 3, 4])" style="margin: 10px;font-weight: bold;" href="#">Download Xls</a></ul>
                                   
                                        <!-- <li class="breadcrumb-item"><a href="javascript:void(0);">Home</a></li>
                                        <li class="breadcrumb-item"><a href="javascript:void(0);">Settings</a></li>
                                        <li class="breadcrumb-item active">Roles</li> -->
                                    </ol>
                                </div>
                                <h4 class="page-title">Roles</h4>
                            </div><!--end page-title-box-->
                        </div><!--end col-->
                    </div>
                    <!-- end page title end breadcrumb -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                  <%--  <button class="btn btn-primary px-4 btn-rounded float-right mt-0 mb-3 export_ico" id="excelExport" onclick="exportTableToExcel('datatable', 'Roles_List',[2, 3, 4])" style="margin:10px;"><img src="<%=request.getContextPath()%>/static/images/extract-icon.png" /> Download Xls</button>
                                   <button class="btn btn-primary px-4 btn-rounded float-right mt-0 mb-3" onclick="addPopup()">+ Add New</button>
                                    <h4 class="header-title mt-0">Role Details</h4>  --%>
                                    <div class="table-responsive dash-social">
                                        <table id="datatable" class="table">
                                            <thead class="thead-light">
                                            <tr>
                                               	<th>Role Name</th>
												<th class="text-center">No. User</th>
												<th class="text-center">View User</th>
                   								<th class="text-center">Edit</th>
												<th class="text-center">Delete</th> 
                                            </tr><!--end tr-->
                                            </thead>
        
                                            <tbody>
                                             <c:forEach items="${roleList}" var="roleListItr" varStatus="sno">
				 
											  <tr>
												<td>${roleListItr[1]}</td>
												<td class="text-center">${roleListItr[2]}</td>
												<td class="text-center"><a onclick="viewPopup(${roleListItr[0]},'${roleListItr[1]}')"><img src="<%=request.getContextPath()%>/static/images/search-user-22x22.png"></a></td>
												<td class="text-center"><a onclick="editPopup(${roleListItr[0]},'${roleListItr[1]}')"><i class="fas fa-edit text-info font-16"></i></a></td>
												<c:choose>
												<c:when test="${roleListItr[2] == 0}">
												<td class="text-center"><a onclick="deletePopup(${roleListItr[0]})"><i class="fas fa-trash-alt text-danger font-16"></i></a></td>
												 <td class="text-center"></td> 
												 </c:when>
												 <c:otherwise>
												 <td></td>
												</c:otherwise>
												</c:choose>
												</tr>
											 </c:forEach><!--end tr-->                                
                                            </tbody>
                                        </table>                    
                                    </div>                                         
                                </div><!--end card-body--> 
                            </div><!--end card--> 
                        </div> <!--end col-->                               
                    </div><!--end row-->     

                </div><!-- container -->

            </div>
            <!-- end page content -->
</div>

<!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/static/assets/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/assets/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/assets/plugins/datatables/dataTables.bootstrap4.min.js"></script>	
		<script src="<%=request.getContextPath()%>/static/js/jquery-confirm.js"></script> 
<script>
     // Datatable
     $('#datatable').DataTable();
     
     $(document).ready(function(){
      	 $(".msgg").fadeOut(5000); 
      	 var path = $("#path").val();
 		$("#img-role").attr("src",path+"/static/assets/images/role-blue-18.png");
      });
     
     var path = $("#path").val();   
     function addPopup(){    
          var href = path+'/users/editUserList?roleid=0&roleName=""';
         
         $.ajax({
                 async: false,
                 type: "GET",
                 url: href,
                 dataType: "html",
                 success: function (data) {
                   
    	           $.dialog({
        	             
                  		  modal: true,
              	             title: "Add Role",
              	             content:data,
              	             draggable: true,
              	             animation: 'scale',
              	             closeAnimation: 'scale',
              	             closeIcon: true,
              	             columnClass: 'col-md-12 col-md-offset-1',
              	             cancelButton: 'Cancel',
              	             cancelButtonClass: 'btn btn-danger',
              	            
    	        		 }); 
                 }
         }); 
     }
         
     function viewPopup(id,rolename){    
         var href = path+'/users/viewUserList?roleid='+id+'&roleName='+rolename;
         
        $.ajax({
                async: false,
                type: "GET",
                url: href,
                dataType: "html",
                success: function (data) {
                  
    	           $.dialog({
       	             
                 		  modal: true,
             	             title: "View User",
             	             content:data,
             	             draggable: true,
             	             animation: 'scale',
             	             closeAnimation: 'scale',
             	             closeIcon: true,
             	             columnClass: 'col-md-10 col-md-offset-1',
             	            
    	        		 }); 
                }
        }); 
    }
     
     function editPopup(id,rolename){    
         var href = path+'/users/editUserList?roleid='+id+'&roleName='+rolename;
         
        $.ajax({
                async: false,
                type: "GET",
                url: href,
                dataType: "html",
                success: function (data) {
                  
    	           $.dialog({
       	             
                 		  modal: true,
             	             title: "Edit Role",
             	             content:data,
             	             draggable: true,
             	             animation: 'scale',
             	             closeAnimation: 'scale',
             	             closeIcon: true,
             	             columnClass: 'col-md-10 col-md-offset-1',
             	             cancelButton: 'Cancel',
             	             cancelButtonClass: 'btn btn-danger',
             	            
    	        		 }); 
                }
        }); 
    }
     
    function deletePopup(id){    
      var href = path+'/users/getdeleteuser?id='+id;
        
       $.ajax({
               async: false,
               type: "GET",
               url: href,
               dataType: "html",
               success: function (data) {
                 
    	           $.dialog({
      	             
                		  modal: true,
            	             title: "Delete Role",
            	             content:data,
            	             draggable: true,
            	             animation: 'scale',
            	             closeAnimation: 'scale',
            	             closeIcon: true,
            	             columnClass: 'col-md-4 col-md-offset-1',
            	             cancelButton: 'Cancel',
            	             cancelButtonClass: 'btn btn-danger',
            	            
    	        		 }); 
               }
       }); 
    }
    
 </script>