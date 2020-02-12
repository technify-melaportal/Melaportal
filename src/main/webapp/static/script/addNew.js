
//skills start

//var path = ('#path').val();
var path = $("#path").val();
function new_skills(){
	var result = true;
	var name=$("#addnew_skills").val();
	$("#skills option").each(function(){
		if($("#skills option[value='"+$(this).val()+"']").text().toLowerCase() == name.toLowerCase()){
			result = false;
		}
	})
	if(name != '' && result){
		$.ajax({
	       type: "get",
	       url: path+"/aboutUs/addNewSkills",
	       data : {req:name},
	       dataType:"text",
	        async:false,
	       success: function(response){
	       	var $select = $('#addnew_skills'); 
	       	$(".add-options-skills").hide();        	 
	       	loadskills()
	       
	       }
		});
	}else{
		if(!result){
			$("#alert_skills").show();
			$("#addNewAlert_skills").html(""+name+" Already Exist !!!");
		}else{
			$("#alert_skills").show();
			$("#addNewAlert_skills").html("Please Enter New Skill to Add !!!");
		}
	}
}

function loadskills(){
	  $("#errorSig").hide();
	 $.ajax({
       type: "get",
       url: path+"/aboutUs/getSkillsList",
       dataType:"json",
       async:false,
       success: function(response){ 
    	  
       	 var $select = $('#skills'); 
       	 $select.find('option').remove();     
       	  $.each(response, function(key, value) {        
               $select.append($('<option>').text(value).attr('value', key));
             });
       	$select.append($('<option>').text('Add New'));
       	var name=$("#addnew_skills").val();  
       	$('#skills').val($("#skills option:contains("+name+")").val());
       	$("#addnew_skills").val("");
       	$(".action-skills").show();
       	$("#alert_skills").hide();
       }
	 });	 
}

function addskills(){
	
	var name=$("#skills option:selected").text();
	if(name == 'Add New'){
		$(".add-options-skills").show();
		$(".action-skills").hide();
		$("#addnew_skills").focus();
	}
}

$(document).ready(function() {
	
	$(".msgg").fadeOut(5000);
	
	$(".add-options-skills").hide();
	$("#alert_skills").hide();
	$("#add-newskills").click(function(){
		
		$(".add-options-skills").show();
		$(".action-skills").hide();
		$("#addnew_skills").focus();
	})
	$("#cancel_skills").click(function(){
		$(".add-options-skills").hide();
		$(".action-skills").show();
		$("#alert_skills").hide();
	})
	
	 $("#cancel_skills").click(function() {
	        $("#addnew_skills").val("");
	    });
	     
});

//skills end
