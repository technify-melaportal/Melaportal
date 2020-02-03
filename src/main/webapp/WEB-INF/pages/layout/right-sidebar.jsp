<div class="pull-right page-right col-md-2 col-sm-3 col-xs-12">

    <div class="history_box">
    	<div class="last_pages">
            <div class="history-title" id="page-title">
            	<i class="menu_ico ico_dashboard icon-left ico_hide"></i>
                <span>Quick Links</span>
               <!--  <a class="plus-icon"></a> -->
            </div>
            <div class="history-content" id="page-content" style="overflow: hidden;">
                <ul>
                    <li class="first-li"><span>1</span><a class="hreflink" href="<%=request.getContextPath()%>/sales/salesAutoInvoice">Auto Invoice</a><!-- <a class="right-icon"> --></a></li>
                    <li><span>2</span><a class="hreflink" href="<%=request.getContextPath()%>/inventory/selectPhysicalCount">Physical Count</a></li>
                    <li><span>3</span><a class="hreflink" href="<%=request.getContextPath()%>/produce/package-packit">Package</a></li>
                   <!--  <li><span>4</span><a href="#">Other File 3</a></li>
                    <li><span>5</span><a href="#">Other File 4</a></li> -->
                </ul>
            </div>
        </div>
    </div>
    
	<br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="hreflink" id="img_click" href="<%=request.getContextPath()%>/inventory/getNegativeInventoryValues"><img id="img_view" width="25px" src="<%=request.getContextPath()%>/static/images/view.png" /></a>
	<br>
	<div id="div_blink">
	   
	   <a class="hreflink" id="blink_click" href="<%=request.getContextPath()%>/inventory/getNegativeInventoryValues"><blink id="blink" style="font-size: 16px;color: F4370F;font-weight: bold;" >Negative Inventory Values!</blink></a>
	</div>
	<div class="history_box2" id="right-bar-history" hidden="">
    	<div class="last_pages">
            <div class="history-title" id="page-title1">
            	<i class="menu_ico ico_dashboard icon-left ico_hide"></i>
                <span>User</span>
                <a class="plus-icon"></a>
            </div>
            <div class="history-content" id="page-content1" style="overflow: hidden;">
                <ul>
                    <li class="first-li"><span>1</span><a href="#">A Ccountant</a><a class="right-icon"></a></li>
                    <li><span>2</span><a href="#">A Rchive</a></li>
                    <li><span>3</span><a href="#">Sgfjykuklll</a></li>
                    <li><span>4</span><a href="#">Tkghgj jhh</a></li>
                    <li><span>5</span><a href="#">Yjbggg Hduhg</a></li>
                </ul>
            </div>
        </div>
    </div>
	
    
	<div class="right-bar-bottom-part">
		<p>Last Login</p>
		<p class="rg-btm-txt">Wednesday, 16th Oct 2018</p>
	</div>
	
</div>


<!-- if page users.html then show id->right-bar-history -->
<script src="<%=request.getContextPath()%>/static/js/plugin/jquery-validate/jquery.validate.min.js"></script>

<script type="text/javascript">
  var url = window.location.href;
  var msg = document.getElementById('right-bar-history');
  if( url.search( 'users.html' ) > 0 ) {
      msg.style.display = "block";
  }
</script>

<script>
$(document).ready(function(){
    $("#page-title").click(function(){
        $("#page-content").toggle('slow');
    });
	$("#page-title1").click(function(){
        $("#page-content1").toggle('slow');
    });
	$("#img_view").show();
	$("#div_blink").show();
});

</script>
 <script type="text/javascript">

setInterval(function(){
  $('blink').each(function() {
    $(this).toggle();
  });
}, 500);

$("#img_click").click(function(){
	$("#img_view").hide();
	$("#div_blink").hide();
});

$("#blink_click").click(function(){
	$("#img_view").hide();
	$("#div_blink").hide();
});
</script> 

  
<script type="text/javascript">
$(document).ready(function() {
	
	
 	$(".hreflink").click(function( event ) {
		  event.preventDefault();
		  var href = $(this).attr('href');
		 
		  $('#current_link').val(href);
		  
		
		   $.ajax({
      		url: href,
      		type:"GET",
      		data: '', 
      		success: function(data){
      			
      			$('#site-content').html(data);}
  			});
  		
		  
   }); 
 	
 	
	
	
}); 	
</script>
