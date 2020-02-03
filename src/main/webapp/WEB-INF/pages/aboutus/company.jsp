<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page import="java.util.Random"%> 
       
       <link href="<%=request.getContextPath()%>/static/css/jquery-confirm.css" rel="stylesheet">
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
                    <form action="${pageContext.request.contextPath}/aboutMe/personal2" method="post">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="float-right">
                                    <ol class="breadcrumb">                                  
                                        <li class="breadcrumb-item"><button type="submit" class="button"><h4 class="page-title">Save</h4></button></li>
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
                                       <div class="col-lg-12">                                                                                   
                                            <div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company Legal Name</label>
                                                <div class="col-sm-6">
                                                    <input class="form-control form-control-sm" type="text" id="example-text-input-lg" style="border-color: #656d9a" name="title" >
                                                </div>
                                                
                                                </div><div class="form-group row">
                                                 <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company Short Name</label>
                                                 <div class="col-sm-3">
                                                    <input class="form-control form-control-sm" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="firstName">
                                                </div>
                                                <label for="example-text-input" class="col-sm-3 col-form-label text-left">15 character limit</label>
                                                <br>
                                                
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company URL</label>
                                                 <div class="col-sm-6">
                                                    <input class="form-control form-control-sm" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="middleName">
                                                </div>
                                                
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Company LinkedIn</label>
                                                 <div class="col-sm-6">
                                                    <input class="form-control form-control-sm" type="text" id="example-text-input-sm" style="border-color: #656d9a" name="lastName">
                                                </div>
                                                
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">What we do</label>
                                                 <div class="col-sm-6">
                                                    <textarea class="form-control form-control-sm" id="example-text-input-sm" style="border-color: #656d9a" name="lastName" rows="8"></textarea>
                                                </div>
                                                
                                                </div><div class="form-group row">
                                                <label for="example-text-input" class="col-sm-2 col-form-label text-left">Address</label>
                                                 <div class="col-sm-6">
                                                    <textarea class="form-control form-control-sm" id="example-text-input-sm" style="border-color: #656d9a" name="lastName" rows="4"></textarea>
                                                </div>
                                            </div>
                                                                             
                                        </div>
                                      
                                    </div> 
                                    
                                 
                                      <div class="row" style="height: 200px"></div>                                    
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
  });

 </script>


