<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="js/jquery-latest.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	$('#submit').click(function(){
		var appid=$("#appid").val();
	 $.ajax({
		    type: 'POST',
		    url: "https://mindapp-pulpy.rhcloud.com/AuthXmlPulpy",
		    data: {appid:appid,
		    	url:"sfgsdfdfgdf",
		    },
            dataType: "xml",
		     success: function(data) {
		    //   alert("Sucess"+appid);
               $(data).find("root").each(function () {
                    a=$(this).find("link").text();
           $("#result").append('a:'+a+ '<br><br>');  
       
                                                          });
		    }
		}); 
	});           
    
});
</script>
<style>
body{
background-color:#ff9900;}
.head{
    color:#ffffff;
    font-family:verdana;
    font-size:40px;}
    
    #result{
    color:#ffffff;
    font-family:verdana;
    font-size:20px;
    border:1px;
    }
    input[type="text"]{
color:#ff9900;
font-size:20px;
background-color:#ffffff;
margin-left:80px;
font-family:verdana;
width:300px;
height:25px;
padding:5px;
} 
input[type="submit"]{

color:#ffffff;
font-size:20px;
background-color:#ff9900;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#ffffff;
border-radius:50px;
padding:10px;
}

</style>
</head>
<body>
<br><br><center><div class="head">Mobile App</div></center><br>
<br><br><center><input type="text" name="appid" id="appid" value="" placeholder='APP_ID'/></center><br>
<br><center><input type="submit" name="submit" id="submit" value="check"/></center>

<br><br><center><div id='result'></div></center>

</body>
</html>