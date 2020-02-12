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
                     <form action="${pageContext.request.contextPath}/aboutUs/companyForm" method="post">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="page-title-box">
                                <div class="float-right">
                                    <ol class="breadcrumb">                                  
                                        <li class="breadcrumb-item">
                                          <button type="button" class="button" style="background-color: #0F67F0;border-radius: 25px;"><h4 class="page-title"><span style="color: white">I refuse</span></h4></button> 
                                           &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="button" style="background-color: #0F67F0;border-radius: 25px;margin-right: 60px;"><h4 class="page-title"><span style="color: white">I agree</span></h4></button>
                                          <%-- <a type="submit"><img src="<%=request.getContextPath()%>/static/images/RefuseB.png" id="img-refuse" style="padding-right: 10px"></a>
                                           <a type="submit"><img src="<%=request.getContextPath()%>/static/images/agreeB.png" id="img-agree"></a> --%></li>
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
                                             <p>Before we begin, please confirm your acceptance of these Terms & Conditions.
                                             <br>Though you have already clicked it before paying for the booth, it is reproduced below as a matter of abundant caution. 
                                             <br>If these terms are acceptable, please click on "I agree". If they are not, please click on "I refuse" and we will immediately give you a full refund.</p>
                                        </div>
                                        <div class="col-lg-8"> 
                                             <p><b>Commercial terms</b></p>
                                             <p style="border: 2px solid;padding: inherit;"><b><u>Booth fee:</u></b> Rs. 1,000 + GST. This entitles you to one table and one stream of interns with 15 minute slots.
												<br>Additional booths are available on payment of a fee.
												<br>Only booths purchased together will be together. Allocation is first-come first-served.
												<br><b><u>Intern Hire:</u></b> Rs. 5,000 + GST per intern hired, payable on the day they join.
												<br><b><u>Full-time Hire:</u></b> 8.33% of CTC + GST, payable on the day they join.</p>
                                             
                                        </div>
                                        <div class="col-lg-12"> 
                                             <p><b>Scorecards</b></p>
												<p style="border: 2px solid;padding: inherit;">Once a month, you need to fill out the Career Scorecard for each intern. This becomes their "credit score" which will be visible to future employers, so it has very high - and permanent - 
												<br>impact. It is a powerful tool to ensure the intern shows up for work every day, does great work, has an amazing attitude, is a good team player and finishes the work on time.
												<br>Conversely, the student will <u>anonymously</u> give you a Net Promoter Score: "Would I recommend this company to my friends or colleagues".
												<br>They will also give you reviews on What is great about this company, and What this company could do to improve.
												<br>This becomes visible in your company profile and will make a substantial impact on what kinds of interns join you. Remember, you want the best ones, and so do others, so your ratings
												<br>will tip the balance.
												<br><u>Grievance redressal:</u> We will entertain requests for review of the ratings from both sides so we can keep things on even keel.</p>
                                             
                                        </div>
                                        
                                         <div class="col-lg-12"> 
                                             <p><b>Model Code of Conduct</b></p>
												<p style="border: 2px solid;padding: inherit;">These are students who are pursuing professional careers that will span 30+ years and lead many of them to great heights in industry and entrepreneurship. You are laying the
												<br>foundation stone. Please note that this internship is NOT free labour. It is a requirement of their University Curriculum, so they are interning with you with the primary goal of further
												<br>professional training in their chosen field of specialization. </p>
                                             
                                        </div>
                                        
                                         <div class="col-lg-6"> 
												<p style="border: 2px solid;padding: inherit;"><b>Please do:</b>
												<br>1. Give them guidance on what they need to do.
												<br>2. Ask them to do usual and customary activity which you do every day.
												<br>3. Give them supervisory support and team support.
												<br>4. Set aside some time every week for feedback and perspectives.
												<br>5. Treat them as professionals. </p>
                                             
                                        </div>
                                        
                                         <div class="col-lg-6"> 
												<p style="border: 2px solid;padding: inherit;"><b>Please don't:</b>
												<br>1. Ignore them.
												<br>2. Expect them to guess what they are supposed to do.
												<br>3. Ill-treat them or be disrespectful of them.
												<br>4. Ask them to do work outside of their job description. If any changes are to be
												<br>made, it needs to be in consultation with their Head of Department.
												<br>5. Ask for any favours which you cannot document on their career scorecard</p>
                                             
                                        </div>
                                       
                                         <div class="col-lg-12"> 
												<p style="border: 2px solid;padding: inherit;"><b>Blacklisting:</b>
												<br>If we find you in violation of the Model Code of Conduct, we are obligated to bring it to the attention of the University for further action. There will be no warning.
												<br>We will also blacklist you, wherein your company or any company in which any of your co-founders are part of will be barred from participating in any intern mela or from hiring any interns
												<br>from any of our participating colleges for a period of 5 years. We will also inform your investors.</p>
                                             
                                        </div>
                                   </div>
                                               
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
     
 </script>

<script>
 
$(document).ready(function() {
	 $(".msgg").fadeOut(5000); 
	$("#loader").hide();
		var path = $("#path").val();
		$("#aboutus").addClass("active");
		$('#aboutus').click();
		$("#company").addClass("active");
		$("#img-company").attr("src",path+"/static/assets/images/startup18blue.png");					                
		  
	});
	
</script> 
		
 

