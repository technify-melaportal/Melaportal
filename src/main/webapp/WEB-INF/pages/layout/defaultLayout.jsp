<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%
String ransString  = "@$";
Random ran = new Random();
ransString += ran.nextInt(Integer.MAX_VALUE)+1;
%>
<!-- https://adminlte.io/themes/AdminLTE/pages/forms/general.html -->
<!--iconslink  https://getbootstrap.com/docs/3.3/components/ -->
<!--iconslink  http://astronautweb.co/snippet/font-awesome/ -->
<!-- https://craftpip.github.io/jquery-confirm/ -->

<html>

<head>
	 <meta charset="utf-8" />
        <title>MelaPortal</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A premium admin dashboard template by Mannatthemes" name="description" />
        <meta content="Mannatthemes" name="author" />

        <!-- App favicon -->
         
		<link rel="shortcut icon"  type="image/ico"  href="<%=request.getContextPath()%>/static/assets/images/favicon.ico"/> 

  <!-- DataTables -->
        <link href="<%=request.getContextPath()%>/static/assets/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <!-- Responsive datatable examples -->
        <link href="<%=request.getContextPath()%>/static/assets/plugins/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        
        <!-- App css -->
        <link href="<%=request.getContextPath()%>/static/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/css/metisMenu.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/static/assets/css/style.css" rel="stylesheet" type="text/css" />
        <%-- <link href="<%=request.getContextPath()%>/static/assets/plugins/fullcalendar/css/fullcalendar.min.css" rel="stylesheet" />   --%>
               
          <script src="<%=request.getContextPath()%>/static/js/export_excel_control.js?id=<%=ransString%>"></script>
          
     	<%-- <link href='<%=request.getContextPath()%>/static/fullcalender/fullcalendar.min.css' rel='stylesheet' />
		<link href='<%=request.getContextPath()%>/static/fullcalender/fullcalendar.print.min.css' rel='stylesheet' media='print' />
		<link href='<%=request.getContextPath()%>/static/fullcalender/scheduler.min.css' rel='stylesheet' />
		<link href="<%=request.getContextPath()%>/static/css/jquery-confirm.css" rel="stylesheet"> --%>
</head>
 
<body>
<div id="loader" class="loader" style=""></div>
		 <header id="header">
			<tiles:insertAttribute name="header" />
		</header> 
	
		<%-- <section id="sidemenu">
			<tiles:insertAttribute name="menu" />
		</section> --%>
		
		<%-- <section id="rightmenu">
			<tiles:insertAttribute name="right" />
		</section>  --%>
						
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
		 
		 <!-- jQuery  -->
		 
        <%-- <script src="<%=request.getContextPath()%>/static/assets/js/jquery.min.js"></script> --%>
        <script src="<%=request.getContextPath()%>/static/assets/js/bootstrap.bundle.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/waves.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/js/jquery.slimscroll.min.js"></script>
        
        <!-- App js -->
        <script src="<%=request.getContextPath()%>/static/assets/js/app.js"></script>

  <%--  <script src="<%=request.getContextPath()%>/static/assets/plugins/apexcharts/apexcharts.min.js"></script> 
         <script src="<%=request.getContextPath()%>/static/assets/pages/jquery.analytics_dashboard.init.js"></script>  --%>
         
 		<%--  <script src="<%=request.getContextPath()%>/static/assets/plugins/jquery-ui/jquery-ui.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/assets/plugins/moment/moment.js"></script>
        <script src='<%=request.getContextPath()%>/static/assets/plugins/fullcalendar/js/fullcalendar.min.js'></script>
        <script src='<%=request.getContextPath()%>/static/assets/pages/jquery.calendar.js'></script>  --%>
        
        <script src="<%=request.getContextPath()%>/static/jscolor/jscolor.js?id=<%=ransString%>"></script>
        
 	  <%--   <script src="<%=request.getContextPath()%>/static/js/plugin/jquery-validate/jquery.validate.min.js?id=<%=ransString%>"></script>  --%>
      
		<%-- <script src='<%=request.getContextPath()%>/static/fullcalender/lib/moment.min.js'></script>
		<script src='<%=request.getContextPath()%>/static/fullcalender/lib/jquery.min.js'></script>  
		<script src='<%=request.getContextPath()%>/static/fullcalender/fullcalendar.min.js'></script>
		<script src='<%=request.getContextPath()%>/static/fullcalender/scheduler.min.js'></script>  
		<script src="<%=request.getContextPath()%>/static/js/jquery-confirm.js"></script> --%>
		
		<!-- my script -->
<script type="text/javascript">
$(document).ready(function() {
	
	$('#loader').hide();
	
 	$(".menulink").click(function( event ) {
 		
		  event.preventDefault();
		  var href = $(this).attr('href');
		
		   $.ajax({
      		url: href,
      		type:"GET",
      		data: '', 
			beforeSend: function() {
      			$('#loader').show();
      	    },
      	    
      		success: function(data){
      		$('#loader').hide();
      		$('#site-content').html(data);
      		}
  			});
  		
		  
   }); 
 	
 	$('body').on('click', '.refresh_ico', function(event) {
 	
		  event.preventDefault();
		  var href = $(this).attr('href');
		
		   $.ajax({
    		url: href,
    		type:"GET",
    		data: '', 
    		success: function(data){
    			$('#site-content').html(data);}
			});	
		  
 }); 
 	
}); 						

</script>
</body>
</html>