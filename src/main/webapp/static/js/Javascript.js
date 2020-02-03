var global="";


function Sales() {
	document.getElementById('sales').style.display = "";
	document.getElementById('sales').style.visibility='visible';
	document.getElementById('by_month').style.visibility='hidden';
	document.getElementById('Production').style.visibility='hidden';
	document.getElementById('fm1').style.visibility='hidden';
	document.getElementById('fm2').style.visibility='hidden';
	document.getElementById('pkg_by_month').style.visibility='hidden';
	document.getElementById('packaging_loss').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('chartFrame').style.display="none";
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
}

function By_Month() {
	document.getElementById('by_month').style.display = "";
	document.getElementById('by_month').style.visibility='visible';
	document.getElementById('fm1').style.visibility='hidden';
	document.getElementById('fm2').style.visibility='hidden';
	document.getElementById('pkg_by_month').style.visibility='hidden';
	document.getElementById('packaging_loss').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	document.getElementById('chartFrame').style.display="none";
}  

function Production() {
	document.getElementById('Production').style.display="";
	document.getElementById('Production').style.visibility='visible';
	document.getElementById('frame').style.visibility='hidden';
	document.getElementById('fm1').style.visibility='hidden';
	document.getElementById('fm2').style.visibility='hidden';
	document.getElementById('pkg_by_month').style.visibility='hidden';
	document.getElementById('packaging_loss').style.visibility='hidden';
	document.getElementById('by_month').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	document.getElementById('chartFrame').style.display="none";
}

function FM1() {
	document.getElementById('fm1').style.display = "";
	document.getElementById('fm1').style.visibility='visible';
	document.getElementById('fm2').style.visibility='hidden';
	document.getElementById('pkg_by_month').style.visibility='hidden';
	document.getElementById('packaging_loss').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	document.getElementById("chartFrame").style.display="none";
}  

function FM2() {
	document.getElementById('fm2').style.display = "";
	document.getElementById('fm2').style.visibility='visible';
	document.getElementById('fm1').style.visibility='hidden';
	document.getElementById('pkg_by_month').style.visibility='hidden';
	document.getElementById('packaging_loss').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	document.getElementById("chartFrame").style.display="none";
}

function Pkg_by_Month() {
	document.getElementById('pkg_by_month').style.display = "";
	document.getElementById('pkg_by_month').style.visibility='visible';
	document.getElementById('fm1').style.visibility='hidden';
	document.getElementById('fm2').style.visibility='hidden';
	document.getElementById('packaging_loss').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	document.getElementById("chartFrame").style.display="none";
}

function Packaging_Loss() {
	document.getElementById('packaging_loss').style.display = "";
	document.getElementById('packaging_loss').style.visibility='visible';
	document.getElementById('fm1').style.visibility='hidden';
	document.getElementById('fm2').style.visibility='hidden';
	document.getElementById('pkg_by_month').style.visibility='hidden';
	document.getElementById('datesearch').style.visibility='hidden';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	document.getElementById("chartFrame").style.display="none";
}

function Date_Search() {
	 document.getElementById('datesearch').style.display = "";
	 document.getElementById('datesearch').style.visibility='visible';
}

function alertOne(value) {
	
		var var1 = global;	
		var e = document.getElementById("beer");
		var beer = e.options[e.selectedIndex].value;
		
		var e = document.getElementById("customer");
		var customer = e.options[e.selectedIndex].value;
		
		var1=var1+"&id4="+customer+"&id3="+beer+"&id1="+document.getElementById('demo').value+"&id2="+document.getElementById('demo1').value;
		document.getElementById("form1").setAttribute('action', var1);
		
	   var from_Date= document.getElementById('demo').value;
	   var to_Date= document.getElementById('demo1').value;
	   var fDate = new Date(from_Date);
	   var tDate = new Date(to_Date);
	   
	   if(from_Date!= '' && from_Date!= '' && fDate> tDate)
	     {
	     alert("Please ensure that the To Date is greater than to the From Date.");
	     return false;
	     }
}

function Show_Chart(value){
	document.getElementById('chartFrame').style.display = "";
	document.getElementById('customer_search').style.display = "";
	document.getElementById('frame').style.visibility='visible';
	document.getElementById('datesearch').style.visibility='visible';
	document.getElementById('chartFrame').style.visibility='visible';
	document.getElementById('customer_search').style.visibility='visible';
	document.getElementById('customer_combo').style.visibility='visible';
	global = value;
    return value;
}


function Show_Chart1(value){
	document.getElementById('chartFrame').style.display = "";
	document.getElementById('frame').style.visibility='visible';
	document.getElementById('datesearch').style.visibility='visible';
	document.getElementById('chartFrame').style.visibility='visible';
	document.getElementById('customer_search').style.visibility='hidden';
	document.getElementById('customer_combo').style.visibility='hidden';
	global = value;
    return value;
}
function combo_customer()
{
	document.getElementById('customer_combo').style.display = "";
	document.getElementById('customer_combo').style.visibility='visible';
}
function search_customer()
{
	document.getElementById('customer_search').style.display = "";
	document.getElementById('customer_search').style.visibility='visible';
}

