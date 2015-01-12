<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quickbooks</title>
<script src="js/jquery-latest.js"></script>
<script type="text/javascript">
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
    	$.ajax({
    		type: "POST",
        	url: "https://mindapp-pulpy.rhcloud.com/Quickbook",
        	success: function result(data) {
            	$('#result').append(data);
          	},
    		error: function (xhr, ajaxOptions, thrownError){
        		alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " + thrownError);
        	}
    	});
    });
});
</script>
<style>
body{
background-color:#FF9900;
}
#head{
font-family:verdana;
font-weight:bold;
font-size:23px;
color:#FFFFFF;
}
#tit{
font-family:verdana;
font-size:20px;
font-weight:bold;
margin-left:70px;
color:#FFFFFF;
font-weight:bold;
}
input[type="button"],input[type="submit"]{
color:#ff9900;
font-size:20px;
background-color:#fff;
font-family:verdana;
height:40px;
border:solid 2px;
border-color:#fff;
border-radius:3px;
padding:5px;
}
</style>
</head>
<body>
<br><br><center><div id="head">Get Invoice from QuickBooks via MindPulpy</div><br>
<br><br>
<input type="button" name="submit" id="submit" value="Authenticate QuickBooks"><br><br>
<input type="button" name="b1" id="b1" value="Get Invoice" ><br><br></center>
<div style="margin-left:100px;color:#fff;" id="result"></div>
</body>
</html>
