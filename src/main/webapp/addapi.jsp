<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mind Pulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<style>
body{background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:35px;}
    .au{
font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;
}
    
input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
font-family:verdana;
width:300px;
height:25px;
padding:10px;
;
} 
select{
color:#FF9900;
font-size:20px;
width:320px;
height:50px;
padding:10px

}
textarea{
font-size:20px;
margin-left:100px;
font-family:verdana;
width:400px;
height:70px;
color:#FF9900;
padding:10px;

}
input[type="password"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
font-family:verdana;
width:300px;
height:25px;
padding:10px;
} 
#txt{
color:#FFFFFF;
font-size:25px;
}
input[type="button"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
margin-left:20px;
font-family:verdana;
width:120px;
height:40px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:20px;
padding:10px;
}
input[type="submit"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
margin-left:20px;
font-family:verdana;
width:120px;
height:40px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:20px;
padding:10px;
}

.result{
color:#FFFFFF;
    font-family:verdana;
    font-size:25px;}
    
</style>
<script type="text/javascript">
function back()
{
	window.location="indexpulpy.jsp";
	}
</script>
<body>
<form name="add" action="Addapi" method="post">
<br><br><div class="head"><center>Mind Pulpy</center></div><br>
<center><input type="text" name="t1" placeholder="Api Name"><br><br>
<input type="text" name="t2"  placeholder="Provider Name" ><br><br>
<select name="t6">
<option value="General" selected>General</option>
<option value="Backend">Backend</option>
<option value="Social">Social</option>
<option value="Tools" >Tools</option>
<option value="Enterprise">Enterprise</option>
<option value="Entertainment">Entertainment</option>
<option value="Security">Security</option>
<option value="Database">Database</option>
<option value="Maps">Maps</option>
<option value="Education">Education</option>
<option value="Health">Health</option>
<option value="Music">Music</option>
<option value="Shopping">Shopping</option>
<option value="Blogging">Blogging</option>
<option value="Photos">Photos</option>
<option value="Messaging">Messaging</option>
</select><br><br>
<input type="text" name="t3"  placeholder="Eg: http://api.example.com"><br><br>
<textarea name="t4" rows="10" cols="30" placeholder="Description"></textarea><br><br>
<div id="txt">Select Image</div><input type="file" name="t5" placeholder="image location"><br><br>
<input type="submit" value="Add Api">&nbsp;&nbsp;
<input type="button" name="b2" value="Back" Onclick="back()">
</center>
</form>
</body>
</html>