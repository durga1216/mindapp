<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://code.jquery.com/jquery-latest.js"></script>

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
		    },
            dataType: "xml",
		     success: function(data) {
		    //   alert("Sucess"+appid);
               $(data).find("root").each(function () {
                    a=$(this).find("a").text();
                    b=$(this).find("b").text();
           $("#result").append('a:'+a+ '<br>b:'+b+'<br><br>');  
       
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
</style>
</head>
<body>
<br><br><center><div class="head">Mobile App</div></center>
<br><br><center> <input type="text" name="p1" id="p1" value="" placeholder="Param 1"/> </center>
<br><br><center><input type="text" name="appid" id="appid" value="" placeholder='APP_ID'/></center>
<br><center><input type="submit" name="submit" id="submit" value="Submit"/></center>

<br><br><center><div id='result'></div></center>

</body>
</html>