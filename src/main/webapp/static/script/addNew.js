
//comment start

//var path = ('#path').val();
var path = $("#path").val();
function new_comment(){
	var result = true;
	var name=$("#addnew_comment").val();
	$("#comment option").each(function(){
		if($("#comment option[value='"+$(this).val()+"']").text().toLowerCase() == name.toLowerCase()){
			result = false;
		}
	})
	if(name != '' && result){
		$.ajax({
	       type: "get",
	       url: path+"/view/addNewComment",
	       data : {req:name},
	       dataType:"text",
	        async:false,
	       success: function(response){
	       	var $select = $('#addnew_comment'); 
	       	$(".add-options-comment").hide();        	 
	       	loadComment()
	       
	       }
		});
	}else{
		if(!result){
			$("#alert_comment").show();
			$("#addNewAlert_comment").html(""+name+" Already Exist !!!");
		}else{
			$("#alert_comment").show();
			$("#addNewAlert_comment").html("Please Enter New Comment to Add !!!");
		}
	}
}

function loadComment(){
	  $("#errorSig").hide();
	 $.ajax({
       type: "get",
       url: path+"/view/getCommentList",
       dataType:"json",
       async:false,
       success: function(response){ 
    	  
       	 var $select = $('#comment'); 
       	 $select.find('option').remove();     
       	  $.each(response, function(key, value) {        
               $select.append($('<option>').text(value).attr('value', key));
             });
       	$select.append($('<option>').text('Add New'));
       	var name=$("#addnew_comment").val();  
       	$('#comment').val($("#comment option:contains("+name+")").val());
       	$("#addnew_comment").val("");
       	$(".action-comment").show();
       	$("#alert_comment").hide();
       }
	 });	 
}

function addcomment(){
	
	var name=$("#comment option:selected").text();
	if(name == 'Add New'){
		$(".add-options-comment").show();
		$(".action-comment").hide();
		$("#addnew_comment").focus();
	}
}

$(document).ready(function() {
	
	$(".msgg").fadeOut(5000);
	
	$(".add-options-comment").hide();
	$("#alert_comment").hide();
	$("#add-newcomment").click(function(){
		
		$(".add-options-comment").show();
		$(".action-comment").hide();
		$("#addnew_comment").focus();
	})
	$("#cancel_comment").click(function(){
		$(".add-options-comment").hide();
		$(".action-comment").show();
		$("#alert_comment").hide();
	})
	
	 $("#cancel_comment").click(function() {
	        $("#addnew_comment").val("");
	    });
	     
});

//comment end
