         
<form method="post" action="<%=request.getContextPath()%>/excel/ReportsDownload" name="form_excel">
<textarea rows="" cols="" name="data" id="txt_excel" hidden=""></textarea>
<input type="submit" id="submit_excel" value="submit" hidden="">
<input type="hidden" id="current_link">
<input type="hidden" id="filename" name='filename'>
</form>

<div class="popup mobile-switch" id="popupModal" style="display:none;"></div>

<script type="text/javascript">

$(document).ready(function(){
	
	$('body').on('click','.popupModal',function(event) {
		
		  event.preventDefault();
		  $('#popupModal').html('');
		  var href = $(this).attr('linkpath');
		 
		  $.ajax({
	            async: false,
	            type: "GET",
	            url: href,
	            dataType: "html",
	            success: function (data) {
	            	 $('#popupModal').html(data);
	            }
	        });
		  
	});
		
});
</script> 