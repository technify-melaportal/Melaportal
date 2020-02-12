<%@page import="com.beerrun.user.controller.UserController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

	<%-- <%=UserController.formLeftNavication(session)%> --%>
           <!-- Left Sidenav -->
            <div class="left-sidenav">
                <div class="main-icon-menu">
                    <nav class="nav">
                    
                    	<a href="#MetricaStartups" class="nav-link" data-toggle="tooltip-custom" data-placement="top" title="" data-original-title="About Us" id="aboutus">
                        	<img alt="" src="<%=request.getContextPath()%>/static/images/startup26white.png">                          
                        </a>
                        
                        <a href="#MetricaJobs" class="nav-link" data-toggle="tooltip-custom" data-placement="top" title="" data-original-title="Interns" id="interns">
                        	<img alt="" src="<%=request.getContextPath()%>/static/images/interns26white.png">                          
                        </a>
                
                    </nav><!--end nav-->
                </div><!--end main-icon-menu-->

                <div class="main-menu-inner">
                    <div class="menu-body slimscroll">
                   	   <div id="MetricaStartups" class="main-icon-menu-pane">
                            <div class="title-box">
                                <h6 class="menu-title">About Us</h6>        
                            </div>
                            <ul class="nav">
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aboutUs/company" id="company"><img src="<%=request.getContextPath()%>/static/assets/images/startup18gray.png" id="img-company" style="margin: 5px;"> Company</a></li>   <!-- <i class="dripicons-view-thumb"></i> -->
                                <%-- <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aboutUs/cofounder"><img src="<%=request.getContextPath()%>/static/assets/images/cofounders18gray.png" id="img-cofounder" style="margin: 5px;"> Co-founders</a></li>  --%>       <!--  <i class="dripicons-user-id"></i> -->
                                 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aboutUs/internships"><img src="<%=request.getContextPath()%>/static/assets/images/internship18gray.png" id="img-interns" style="margin: 5px;"> Internships</a></li> 
                                 <%--  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aboutUs/scorecard"><img src="<%=request.getContextPath()%>/static/assets/images/scorecard18gray.png" id="img-scorecard" style="margin: 5px;"> Scorecard</a></li>  --%>
                            </ul>
                        </div>
                        <div id="MetricaJobs" class="main-icon-menu-pane">
                            <div class="title-box">
                                <h6 class="menu-title">Interns</h6>       
                            </div>
                            <ul class="nav">
                                 <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/search"><img src="<%=request.getContextPath()%>/static/assets/images/search18gray.png" id="img-search" style="margin: 5px;">  Directory</a></li><!-- <i class="dripicons-meter"></i> -->
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/shortlist"><img src="<%=request.getContextPath()%>/static/assets/images/shortlist18gray.png" id="img-shortlist" style="margin: 5px;">  Shortlisted</a></li>
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/invited"><img src="<%=request.getContextPath()%>/static/assets/images/Invited18gray.png" id="img-invited" style="margin: 5px;">   Invited</a></li><!-- <i class="dripicons-user-group"></i> -->
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/applications"><img src="<%=request.getContextPath()%>/static/assets/images/next18gray.png" id="img-application" style="margin: 5px;"> Applications</a></li>  
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/schedule"><img src="<%=request.getContextPath()%>/static/assets/images/schedule18gray.png" id="img-schedule" style="margin: 5px;">  Scheduled</a></li> <!-- <i class="dripicons-document"></i> -->
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/interviewing"><img src="<%=request.getContextPath()%>/static/assets/images/interview18gray.png" id="img-interview" style="margin: 5px;">  Interviewing</a></li>
                               <%--  <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/decision"><img src="<%=request.getContextPath()%>/static/assets/images/decision18gray.png" id="img-decision" style="margin: 5px;">  Decision</a></li>
                                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/interns/accepted"><img src="<%=request.getContextPath()%>/static/assets/images/accepted18gray.png" id="img-accepted" style="margin: 5px;">  Accepted</a></li> --%>
                            </ul>
                        </div><!-- end Forecast -->                    
                        
                    </div><!--end menu-body-->
                </div><!-- end main-menu-inner-->
            </div>
            <!-- end left-sidenav-->
                

        
        