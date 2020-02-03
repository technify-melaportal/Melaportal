 function exportTableToExcel(tableID, filename ,removeindex){
  

	 try
	 {
			$("#txt_excel").val("");
		  	$("#filename").val("");
		  	var tab_text="";
		     var downloadLink;
		     var tableSelect = document.getElementById(tableID);
		  	//alert("tableSelect==>"+tableSelect);

		     var tableSelect2;
		  	for(j = 0 ; j < tableSelect.rows.length ; j++) 
		     {     
		 			 for(i = 0 ; i < tableSelect.rows[j].cells.length ; i++) 
		 			   {     
		 			   
		 				 if(jQuery.inArray(i, removeindex) !== -1)
		 					 {
		 					 //alert("if part" +i);
		 					 }
		 				 else
		 					 {
		 					 //alert("else part " +i);
		 					 tab_text=tab_text+tableSelect.rows[j].cells[i].innerHTML+"~";
		 					 
		 					 }
		 			   }

		 			 tab_text=tab_text+"^";
		 			 
		 			// console.log("column check malai ==>"+tab_text);
		     }
		  	//tab_text =$(tab_text).text();
		  	//tab_text = stripHtml(tab_text);
		  	$("#txt_excel").val(tab_text);
		 	$("#filename").val(filename);
		  	$("form[name='form_excel']").submit();
	 }catch(e)
	 {
		  console.log('An error has occurred: '+e.message);
	 }
  	
  	
  }
 
 
 function exportTableToExcel2(tableID, filename ,removeindex){
	  

	 try
	 {
			$("#txt_excel").val("");
		  	$("#filename").val("");
		  	var tab_text="";
		     var downloadLink;
		     var tableSelect = document.getElementById(tableID);
		  	//alert("tableSelect==>"+tableSelect);

		     var tableSelect2;
		  	for(j = 0 ; j < tableSelect.rows.length ; j++) 
		     {     
		 			 for(i = 0 ; i < tableSelect.rows[j].cells.length ; i++) 
		 			   {     
		 			   
		 				 if(jQuery.inArray(i, removeindex) !== -1)
		 					 {
		 					 //alert("if part" +i);
		 					 }
		 				 else
		 					 {
		 					 //alert("else part " +i);
		 					 tab_text=tab_text+tableSelect.rows[j].cells[i].innerHTML+"~";
		 					 
		 					 }
		 			   }

		 			 tab_text=tab_text+"^";
		 			 
		 			// console.log("column check malai ==>"+tab_text);
		     }
		  	//tab_text =$(tab_text).text();
		  	//tab_text = stripHtml(tab_text);
		  	$("#txt_excel").val(tab_text);
		 	$("#filename").val(filename);
		  	$("form[name='form_excel']").submit();
	 }catch(e)
	 {
		  console.log('An error has occurred: '+e.message);
	 }
  	
  	
  }
 
 function stripHtml(html){
	    // Create a new div element
	    var temporalDivElement = document.createElement("div");
	    // Set the HTML content with the providen
	    temporalDivElement.innerHTML = html;
	    // Retrieve the text property of the element (cross-browser support)
	    return temporalDivElement.textContent || temporalDivElement.innerText || "";
	}