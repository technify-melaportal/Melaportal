<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.Random"%> 
       
       <link href="<%=request.getContextPath()%>/static/css/jquery-confirm.css" rel="stylesheet">
       
 <!-- Page Content-->
 <div class="page-wrapper">
    <jsp:include page="../layout/left-navigation.jsp"></jsp:include>
            <div class="page-content">
			<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
                <div class="container-fluid">
                    <!-- Page-Title -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="float-right">
                                    <ol class="breadcrumb">
                                    <ul><a id="excelExport" onclick="exportTableToExcel('datatable', 'Users_List',[5,6])" style="margin: 10px;font-weight: bold;" href="#">Download Xls</a></ul>
                                     <ul><a onclick="addPopup()" style="margin: 5px;font-weight: bold;" href="#">Confirm</a></ul>
                                      
                                  
                                    </ol>
                                </div>
                                <h4 class="page-title">Directory</h4>
                            </div><!--end page-title-box-->
                        </div><!--end col-->
                    </div>
                    <!-- end page title end breadcrumb -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">                  
                                    <span class="msgg" style="color:green;margin-left: 100px;font-size: 15px"><strong>${success}</strong></span> 
                                    <div class="table-responsive dash-social">
                                        <table id="datatable" class="table">
                                            <thead class="thead-light">
                                            <tr>
                                               	<th class="text-left">Name</th>
												<th class="text-left">College</th>
												<th class="text-left">Year</th>
												<th class="text-left">Department</th>
												<th class="text-center">Resume</th>
												<th class="text-center">Shortlist</th>
												<th class="text-center">Hide</th>
                                            </tr><!--end tr-->
                                            </thead>
        
                                            <tbody>
											  <c:forEach  var="list" items="${applicationList}">
											  <tr>		  
											 
												<td class="text-left">${list.studentName}</td>
												<td class="text-left">${list.collegeName}</td>
												<td class="text-left">${list.year}</td>
												<td class="text-left"> ${list.departmentName}</td>
												<td class="text-center"><a href="${list.resume}" target="_blank"><img src="<%=request.getContextPath()%>/static/assets/images/pdf18.png"></a></td>
												<td class="text-center"><a href="${list.studentid}"></a></td>
												<td class="text-center"><a href="${list.studentid}"></a></td>
											  </tr>
											  </c:forEach>  
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
  	$("#interns").addClass("active");
	$('#interns').click();
	$("#img-search").attr("src",path+"/static/assets/images/search18blue.png");	
	
  });
     
  var path = $("#path").val();   
 function addPopup(){    
      var href = path+'/users/add';
     
     $.ajax({
             async: false,
             type: "GET",
             url: href,
             dataType: "html",
             success: function (data) {
               console.log(data);
               
	           $.dialog({
    	             
              		  modal: true,
          	             title: "Add User",
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
     
 function editPopup(id){    
     var href = path+'/users/getEditUserList?id='+id;
     
    $.ajax({
            async: false,
            type: "GET",
            url: href,
            dataType: "html",
            success: function (data) {
              console.log(data);
              
	           $.dialog({
   	             
             		  modal: true,
         	             title: "Edit User",
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
             console.log(data);
             
	           $.dialog({
  	             
            		  modal: true,
        	             title: "Delete User",
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


