
//Physical count History delete start here.
function deleteHistory(id){
	var contextpath=$("#contextpath").val();
	
	$.ajax({
		   type: "get",
	       url: contextpath+"/inventory/historyDeletePhysicalCount",
	       data : {req:id},
	       dataType:"json",
	       async:false,
	       success: function(response){
	    	   $("#phy-history tbody tr").remove(); 
	    	   
	          	 $.each(response,function(i,status){
	          		 $('#phy-history').append(
	          				$('<tr>')
	          				.append($('<td class=\"text-left\">').append(status[0]))
	          				.append($('<td class=\"text-left\">').append(status[1]))
	          				.append($('<td class=\"text-left\">').append(status[2]))
	          				.append($('<td class=\"text-left\">').append(status[3]))
	          				.append($('<td class=\"text-center\"><a href=\"'+status[4]+'\" target=\"_blank\"><img src=\"../static/images/view.png\" /></a>').append())
	          				.append($('<td class=\"text-center\"><a href=\"#\"  onclick=deleteHistory('+status[5]+')><img src=\"../static/images/delete-icon.png\" /></a>').append())
	          		 );
	          		
	          	 });
	       	
	          	
	       }
	});
	
}

//Physical count History delete end here.