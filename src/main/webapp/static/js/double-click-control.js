/* $("input[type=submit]").click(function () {
	    	var form_id = $(this).closest("form[id]:visible").attr('id');	 
	    	console.log("test double click form id===>"+form_id);
	    	 if($("#"+form_id).valid()){
	    	 		// $("#"+form_id).hide();
	    			//$('#loader').show();
	    		     $(this).submit();
	    	 		 $(this).attr('disabled','disabled');
	    	 		console.log("double hide");
			         return true;
			   }	   	
	 console.log("login click malai");
});*/

$("input[type=submit]").click(function(event) {
	
	var isOpera = (!!window.opr && !!opr.addons) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
	var isFirefox = typeof InstallTrigger !== 'undefined';
	var isSafari = /constructor/i.test(window.HTMLElement) || (function (p) { return p.toString() === "[object SafariRemoteNotification]"; })(!window['safari'] || (typeof safari !== 'undefined' && safari.pushNotification));
	var isIE = /*@cc_on!@*/false || !!document.documentMode;
	var isEdge = !isIE && !!window.StyleMedia;
	var isChrome = !!window.chrome && !!window.chrome.webstore;
	var isBlink = (isChrome || isOpera) && !!window.CSS;
	
	var form_id = $(this).closest("form[id]:visible").attr('id');	 
	
	if(isFirefox == true){
		 onclick=this.disabled=true; 
		 console.log("new double click firefox");
 	}
	else{
		 $(this).submit();
		 $(this).attr('disabled','disabled');
		 console.log("new double click other");
		 return true;
 	}
	
 		
});  
		
 