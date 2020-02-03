//validation for Item already exists
function alreadyExistValidation(){
	
	var itemname = $("#itemname").val();
	var path = $("#path").val();
	
	 lbl_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/inventory/itemAlreadyExists",
	         data : {req:itemname},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				 /*$("#lbl_validate").html(""+response.itemName+" already exist !!!");*/
	 				$("#lbl_validate").html("Item name already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#itemname").val('');
	 				$("#itemname").focus();
	 				$("#lbl_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
	   $("#itemdesc").val(itemname);
}

//validation for Invoice No already exists
function invoiceNoAlreadyExistValidation(){
	
	var invoiceno = $("#invoicenumber").val();
	var path = $("#path").val();
	
	 lbl_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/sales/invoiceNoAlreadyExists",
	         data : {req:invoiceno},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				 /*$("#lbl_validate").html(""+response.itemName+" already exist !!!");*/
	 				$("#lbl_validate").html("This Invoice No already exists");
	 				// $("#alert-fancy").show();
	 				 
	 				$("#invoicenumber").val('');
	 				$("#invoicenumber").focus();
	 				$("#lbl_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
}


//admin-setting-package validation

function packvalidation(){

	
	var packname = $("#packname").val();
	var path = $("#path").val();

	 lbl_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/package/packAlreadyExists",
	         data : {req:packname},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        		
	        	 if(response!=null){
	        		
	 				 $("#lbl_validate").html(""+response.packageName+" already exist !!!");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#packname").val('');
	 				$("#packname").focus();
	 				$("#lbl_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
//	   $("#itemdesc").val(itemname);
}


//admin-tank-validation

function tankvalidation(){

	
	var tankname = $("#tankname").val();
	var path = $("#path").val();
	
	 lbl_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/tank/tankAlreadyExists",
	         data : {req:tankname},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        		
	        	 if(response!=null){
	        		
	 				 $("#lbl_validate").html(""+response.tankname+" already exist !!!");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#tankname").val('');
	 				$("#tankname").focus();
	 				$("#lbl_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
//	   $("#itemdesc").val(itemname);
}


//admin-user-validation



function uservalidation(){	
	var username = $("#txtuser").val();
	var path = $("#path").val();
	
	 lbl_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/users/userAlreadyExists",
	         data : {req:username},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				 $("#lbl_validate").html(""+response.userName+" already exist !!!");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#username").val('');
	 				$("#firstname").val('');
	 				$("#lastname").val('');
	 				$("#init").val('');
	 				$("#firstname").focus();
	 				
	 				$("#lbl_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
//	   $("#itemdesc").val(itemname);
}

//pricegroup validation

function pricegroupvalidation(){
	
	var pricegroupname = $("#pricegroupname").val();
	
	var path = $("#path").val();
	
	 lbl_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/sales/pricegroupAlreadyExists",
	         data : {req:pricegroupname},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	/* alert("sucess----->"+pricegroupname)*/
	        	 if(response!=null){
	        		
	 				 /*$("#lbl_validate").html(""+response.itemName+" already exist !!!");*/
	 				$("#lbl_validate").html(""+response.priceGroupName+" name already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#pricegroupname").val('');
	 				$("#pricegroupname").focus();
	 				$("#lbl_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
	   //$("#itemdesc").val(itemname);
}


//beer list already existing
function alreadyExistBeerlist(){
	
	var itemname = $("#itemname-beer").val();
	var path = $("#path").val();
	
	lblbeer_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/inventory/beeritemAlreadyExists",
	         data : {req:itemname,type:'beer'},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				
	 				$("#lblbeer_validate").html("Item name already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#itemname-beer").val('');
	 				$("#itemname-beer").focus();
	 				jQuery("#lblbeer_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
	   
}
function duplicateAbbrevBeerlist(){
	
	var abbrev = $("#beerabbrev-beer").val();
	var path = $("#path").val();
	
	lblbeer_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/inventory/abbreviationAlreadyExists",
	         data : {req:abbrev},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				
	 				$("#lblbeer_validate").html("Abbreviation already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#beerabbrev-beer").val('');
	 				$("#beerabbrev-beer").focus();
	 				$("#lblbeer_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
	  
}
function duplicateColorBeerlist(){
	
	var beercolor = $("#color-beer").val();
	var path = $("#path").val();
	
	lblbeer_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/inventory/colorAlreadyExists",
	         data : {req:beercolor},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				
	 				$("#lblbeer_validate").html("Color already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#color-beer").val('FFFFFF');
	 				$("#color-beer").focus();
	 				$("#lblbeer_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	   
	   
}


//FG list already existing

function duplicateitemnameFGlist(){
	
	var itemname = $("#txtitemname").val();
	var path = $("#path").val();
	
	lblbeer_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/inventory/beeritemAlreadyExists",
	         data : {req:itemname,type:'FG'},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				
	 				$("#lblbeer_validate").html("This name already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#txtitemname").val('');
	 				$("#txtitemname").focus();
	 				$("#lblbeer_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	  
	   $("#txtitemdesc").val(itemname);
}

function duplicateitemdecFGlist(){
	
	var itemdec = $("#txtitemdesc").val();
	var path = $("#path").val();
	
	lblbeer_validate.innerHTML="";
	   $.ajax({
	         type: "Post",
	         url: path+"/inventory/itemdecAlreadyExists",
	         data : {req:itemdec,type:'FG'},
	         dataType:"json",
	         async:false,
	         success: function(response){
	        	
	        	 if(response!=null){
	        		
	 				
	 				$("#lblbeer_validate").html("This Description already exists");
	 				 $("#alert-fancy").show();
	 				 
	 				$("#txtitemdesc").val('');
	 				$("#txtitemdesc").focus();
	 				$("#lblbeer_validate").fadeOut(5000);
	        	   }
	        	
	        	
	         }
		 });
	 
}
