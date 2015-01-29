<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quickbooks</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function toggle(div_id) {
	var el = document.getElementById(div_id);
	if ( el.style.display == 'none' ) {	el.style.display = 'block';}
	else {el.style.display = 'none';}
}
function blanket_size(popUpDivVar) {
	if (typeof window.innerWidth != 'undefined') {
		viewportheight = window.innerHeight;
	} else {
		viewportheight = document.documentElement.clientHeight;
	}
	if ((viewportheight > document.body.parentNode.scrollHeight) && (viewportheight > document.body.parentNode.clientHeight)) {
		blanket_height = viewportheight;
	} else {
		if (document.body.parentNode.clientHeight > document.body.parentNode.scrollHeight) {
			blanket_height = document.body.parentNode.clientHeight;
		} else {
			blanket_height = document.body.parentNode.scrollHeight;
		}
	}
	var blanket = document.getElementById('blanket');
	blanket.style.height = blanket_height + 'px';
	var popUpDiv = document.getElementById(popUpDivVar);
	popUpDiv_height=blanket_height/2-200;//200 is half popup's height
	popUpDiv.style.top = popUpDiv_height + 'px';
}
function window_pos(popUpDivVar) {
	if (typeof window.innerWidth != 'undefined') {
		viewportwidth = window.innerHeight;
	} else {
		viewportwidth = document.documentElement.clientHeight;
	}
	if ((viewportwidth > document.body.parentNode.scrollWidth) && (viewportwidth > document.body.parentNode.clientWidth)) {
		window_width = viewportwidth;
	} else {
		if (document.body.parentNode.clientWidth > document.body.parentNode.scrollWidth) {
			window_width = document.body.parentNode.clientWidth;
		} else {
			window_width = document.body.parentNode.scrollWidth;
		}
	}
	var popUpDiv = document.getElementById(popUpDivVar);
	window_width=window_width/2-200;//200 is half popup's width
	popUpDiv.style.left = window_width + 'px';
}
function popup(windowname) {
	blanket_size(windowname);
        window_pos(windowname);
	toggle('blanket');
	toggle(windowname);		
}
$(document).ready(function() {  
    var url=document.URL;
    var appid="MPAPP_1409";
    $('#submit').click(function(){
    	$.ajax({
      		type: "POST",
        	url: "https://mindapp-pulpy.rhcloud.com/Quickcall",
        	data: { 
        		appid:appid,
           		url:url,
        	},
        	success: function(result) {
        	 window.location=result;
           	},
        	error: function (xhr, ajaxOptions, thrownError){
         		alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " + thrownError);
        	}
    	});
    });     
    $('#b1').click(function(){
    	var id="1", Arr=[];
    	var docid,cdate,ddate,bal,tot,cust;
    	$.ajax({
    		type: "POST",
        	url: "https://mindapp-pulpy.rhcloud.com/Quickbook",
        	data: { 
        		id:id,
        	},
        	success: function result(data) {
        		console.log(data);
        		$('#result').append(data);
        		popup('popUpDiv');
          	},
    		error: function (xhr, ajaxOptions, thrownError){
        		alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " + thrownError);
        	}
    	});
    });
});
</script>
<style>
body {
	background-color: #FF9900;
}

#head {
	font-family: verdana;
	font-weight: bold;
	font-size: 23px;
	color: #FFFFFF;
}

#tit {
	font-family: verdana;
	font-size: 20px;
	font-weight: bold;
	margin-left: 70px;
	color: #FFFFFF;
	font-weight: bold;
}

input[type="button"],input[type="submit"] {
	color: #ff9900;
	font-size: 20px;
	background-color: #fff;
	font-family: verdana;
	height: 40px;
	border: solid 2px;
	border-color: #fff;
	border-radius: 3px;
	padding: 5px;
}

#blanket {
	background-color: #000;
	opacity: 0.65;
	*background: none;
	position: absolute;
	z-index: 9001;
	top: 0px;
	left: 0px;
	width: 100%;
}

#popUpDiv {
	position: absolute;
	background-color: #ff9900;
	width: 500px;
	height: 500px;
	border: 3px solid #ff9900;
	z-index: 9002;
	overflow-y:auto;
	overflow-x:auto;
	border-radius: 10px;
	box-shadow: 3px 3px 10px 2px #000;
}

#popUpDiv {
	a position: relative;
	top: 20px;
	left: 20px
}
</style>
</head>
<body>
	<br>
	<br>
	<center>
		<div id="head">Get Invoice from QuickBooks via MindPulpy</div>
		<br> <br> <br> <input type="button" name="submit"
			id="submit" value="Authenticate QuickBooks"><br> <br>
		<input type="button" name="b1" id="b1" value="Get Invoice"><br>
		<br>
	</center>
	<div id="blanket" style="display: none;"></div>
	<div id="popUpDiv" style="display: none;">
		<a style='font-size: 20px; color: #000; float: right;' href=""
			onclick="popup('popUpDiv')">close<img
			style='height: 20px; width: 20px' alt="close" src="images/close.png"></a><br>
		<br>
		<div style=" color: #fff;" id="result"></div>
	</div>
</body>
</html>
