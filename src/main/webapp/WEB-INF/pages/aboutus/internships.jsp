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
                                     <ul><a onclick="addPopup()" style="margin: 5px;font-weight: bold;background-color: #0F67F0;border-radius: 25px;padding: 2px" href="#"><span style="color: white">+ Add New</span></a></ul>
                                      <ul><a id="excelExport" onclick="exportTableToExcel('datatable', 'Internship_List',[2])" style="margin: 10px;font-weight: bold;background-color: #0F67F0;border-radius: 25px;margin-right: 50px;padding: 2px" href="#"><span style="color: white">Download Xls</span></a></ul>
                                  
                                    </ol>
                                </div>
                                <h4 class="page-title">Internships</h4>
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
                                               	<th class="text-left">Short Name</th>
												<th class="text-center">Paid?</th>
												<!-- <th class="text-left">Department</th>
												<th class="text-left">Year</th> -->
												<th class="text-center">Details</th>
												<th class="text-center"># positions</th>
												<th class="text-center"># views</th>
												<th class="text-center"># short listed</th>
												<th class="text-center"># applied</th>
                                            </tr><!--end tr-->
                                            </thead>
        
                                            <tbody>
											 <c:forEach  var="list" items="${InternshipHeader}">
											  <tr>		  
											 
												<td class="text-left">${list.intershipshortname}</td>
												<td class="text-center">${list.paid}</td>
												<td class="text-center"><a onclick="editPopup(${list.internshipid})"><i class="dripicons-preview"></i></a></td>
												<td class="text-center"> ${list.positions}</td>
												<td class="text-center">${list.noofviews}</td>
												<td class="text-center">${list.noofshortlisted}</td>
												<td class="text-center">${list.noofapplied}</td>
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
  	$("#aboutus").addClass("active");
	$('#aboutus').click();
	$("#img-interns").attr("src",path+"/static/assets/images/internship18blue.png");	
  });
     
  var path = $("#path").val();   
 function addPopup(){    
      var href = path+'/aboutUs/addInternship';
     
     $.ajax({
             async: false,
             type: "GET",
             url: href,
             dataType: "html",
             success: function (data) {
               console.log(data);
               
	           $.dialog({
    	             
              		  modal: true,
          	             title: "Add New Internship",
          	             content:data,
          	             draggable: true,
          	             animation: 'scale',
          	             closeAnimation: 'scale',
          	             closeIcon: true,
          	             columnClass: 'col-md-8 col-md-offset-1',
          	             cancelButton: 'Cancel',
          	             cancelButtonClass: 'btn btn-danger',
          	            
	        		 }); 
             }
     }); 
 }
     
 function editPopup(id){    
     var href = path+'/aboutUs/getViewInternship?id='+id;
     
    $.ajax({
            async: false,
            type: "GET",
            url: href,
            dataType: "html",
            success: function (data) {
              console.log(data);
              
	           $.dialog({
   	             
             		  modal: true,
         	             title: "View Internship Details",
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

 </script>


