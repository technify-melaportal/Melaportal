	<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body">        
                    <!-- <h4 class="mt-0 header-title">Add User</h4> -->
                    <div class="progress" style="width:40%" id="progress">
		    			<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="50" style="width:100%">
		       			Processing... Please Wait...</div>
       				</div>
              		 <form method="post" action="<%=request.getContextPath()%>/users/addnewuser" id="navigationfrm">
               		<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
               					
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="example-text-input">First Name</label>
                                    <input class="form-control" type="text" name="firstName" id="firstname" required="required" autocomplete="off" style="text-transform:capitalize;">
									<label id="lbl_validate" style="color: red; font-style: italic;margin-left: 10px;"></label>                                
                            </div>
                           
                            <div class="form-group">
                                <label for="example-tel-input">Suffix</label>
                                    <input class="form-control" type="text" id="example-tel-input" name="suffix">
                            </div>
                            		
                            <div class="form-group row">
                                <label for="example-password-input" class="col-sm-3 col-form-label text-right">Username :</label>
                                <div class="col-sm-9">
                                 <label title="userName" id="username" for="userName" ></label><br/><input type="hidden" id="txtuser" name="userName"><br/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="example-number-input" class="col-sm-3 col-form-label text-right">Password :</label>
                                <div class="col-sm-9">
                                    <label id="password" for="password"></label><br/><input type="hidden" id="txtpass" name="password"><br/>
                                </div>
                            </div> 
                                                                        
                        </div>
	
	
                        <div class="col-lg-6">
                         	
                            <div class="form-group">
                                <label for="example-url-input">Role</label>
                                       <select class="custom-select" name="roleid" id="role" required  data-msg-required='Role is Required'>
										  <option value="">Select</option>
										 <c:forEach items="${roleList}" var="list">
										   <option value="${list.roleid }">${list.roleName}</option>
										 </c:forEach>
                                        </select>
                            </div> 
                               
                            
                            <button type="submit" class="btn btn-primary" id="btnSubmit">Save</button>
                             <!-- <button type="button" class="btn btn-danger">Cancel</button>  -->
                                                                          
                        </div>
                    </div>  
                    </form>                                                                    
                </div><!--end card-body-->
            </div><!--end card-->
        </div><!--end col-->
    </div><!--end row-->
                   
<script src="<%=request.getContextPath() %>/static/script/validation.js"></script>
<script TYPE="text/javascript">

$(document).ready(function() {
	 $('input:text:first').focus();
	    
	 $('input:text').bind("keydown", function(e) {
	    var n = $("input:text").length;
	    if (e.which == 13) 
	    { //Enter key
	      e.preventDefault(); //Skip default behavior of the enter key
	      var nextIndex = $('input:text').index(this) + 1;
	      if(nextIndex < n)
	        $('input:text')[nextIndex].focus();
	      else
	      {
	        $('input:text')[nextIndex-1].blur();
	        $('#btnSubmit').click();
	      }
	    }
	  });

	  $('#btnSubmit').click(function() {
		  $("#progress").show();
	    
	  });
	}); 
	
function username() {
	
	var firstname=""; var lastname="";
   firstname = document.getElementById("firstname").value;
   lastname = document.getElementById("lastname").value;
   var res = firstname.substring(0, 1);
   var res2 =lastname.substring(0, 1);
   var init=res+res2;
 
  // $('#username').val(res.concat(lastname));
   //$('#password').val(res.concat(lastname));
  document.getElementById("username").innerHTML = res.concat(lastname);
  document.getElementById("password").innerHTML = res.concat(lastname);;
  
  document.getElementById("txtuser").value = res.concat(lastname);
  document.getElementById("txtpass").value = res.concat(lastname);
  $('#username').val(res);
  $('#init').val(init);
  document.getElementById("password").value = lastname;
  $('#password').val(lastname);
  
  uservalidation();
  
}

function checkvalue(email)

{

if(email.length > 0)

   {

   if (email.indexOf(' ') >= 0)

      alert("email addresses cannot have spaces in them");

   else if (email.indexOf('@') == -1)

      alert("a valid email address must have an @ in it");

   }

}


</SCRIPT>
 
<script>
$(document).ready(function(){
	$(".msgg").fadeOut(5000);
	$("#progress").hide();
   	
});

</script>

	<!-- <script>
		$(function() {

		 $("#navigationfrm").validate({
			 nvalidHandler: function(form) {
	                
	             },

				submitHandler : function(form) {
					$('form input[type=submit]').attr('disabled',true);
					$("#progress").show();
					$.ajax({
						url : $(form).attr("action"),
						type : $(form).attr("method"),
						data : $(form).serialize(),
						success : function(data) {

							$(".fancybox-close-small").trigger("click");
							$('#site-content').html(data);
						}
					})

				}
			});

		});
	</script> -->
	