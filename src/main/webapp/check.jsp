<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" /><style>
.head{
    color:#ffffff;
    font-family:verdana;
    font-size:35px;
    font-weight:bold;
}
body{
background-color:#ff9900;

}
input[type="text"]{
color:#ff9900;
font-size:20px;
background-color:#ffffff;
margin-left:80px;
font-family:verdana;
width:300px;
height:20px;
padding:20px;
} 
input[type="submit"]{

color:#ffffff;
font-size:20px;
background-color:#ff9900;
margin-left:280px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#ffffff;
border-radius:50px;
padding:10px;
}

</style>
<script src="js/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function() {  
    
	$('#submit').click(function(){
		var appid=$("#appid").val();
	    $.ajax({
	    type: "POST",
	    url: "https://mindapp-pulpy.rhcloud.com/ClientOauth",
	    data: {appid:appid},
	    success: function(data) {
	      //alert(data);
	       //$('#results').html(data);
	       window.location=data;
	    }
	});
	});              
});

</script>
</head>

<body>
<br><br><center><div class='head'>Authentication</div></center>
<br><br><center><input type="text" name="appid" id="appid" value="" placeholder='APP_ID'/></center>

<div id='results'></div>
<br><center><input type="submit" name="submit" id="submit" value="Sign in"/></center>
</body>
</html>