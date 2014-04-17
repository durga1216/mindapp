<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

    <script type="text/javascript" charset="utf-8">
    function change()
{
  var select=document.getElementById("select1");
  var div=document.getElementById("container");
  var value=select.value;
  if(value=='XML REQUEST'){
  toAppend="<br><font color='blue'>Param1<input type='text' name='x1'> &nbsp; Value <input type='text' name='v1'><br><br>Param2<input type='text' name='x2'>&nbsp; Value <input type='text' name='v2'><br><br>Param3<input type='text' name='x3'>&nbsp; Value <input type='text' name='v3'><br><br>Param4<input type='text' name='x4'>&nbsp; Value <input type='text' name='v4'><br><br>Param5<input type='text' name='x5'>&nbsp; Value <input type='text' name='v5'><br><br>Param6<input type='text' name='x6'>&nbsp; Value <input type='text' name='v6'><br><br>Param7<input type='text' name='x7'>&nbsp; Value <input type='text' name='v7'><br><br>Param8<input type='text' name='x8'>&nbsp; Value <input type='text' name='v8'><br><br>Param9<input type='text' name='x9'>&nbsp; Value <input type='text' name='v9'><br><br>Param10<input type='text' name='x10'>&nbsp; Value <input type='text' name='v10'><br><br>Param11<input type='text' name='x11'>&nbsp; Value <input type='text' name='v11'><br><br>Param12<input type='text' name='x12'>&nbsp; Value <input type='text' name='v12'><br><br>Param13<input type='text' name='x13'>&nbsp; Value <input type='text' name='v13'><br><br>Param14<input type='text' name='x14'>&nbsp; Value <input type='text' name='v14'><br><br>Param15<input type='text' name='x15'>&nbsp; Value <input type='text' name='v15'><br> ";
   div.innerHTML=toAppend;
  document.getElementById("t5").disabled=true;
  document.getElementById("t8").disabled=true;
  document.getElementById("t6").disabled=true;
  document.getElementById("t9").disabled=true;
  }
  else if(value=='GET'){
	  div.innerHTML="";
	  document.getElementById("t5").disabled=false;
	  document.getElementById("t8").disabled=false;
	  document.getElementById("t6").disabled=false;
	  document.getElementById("t9").disabled=false;
	  }
  else if(value=='POST'){
   div.innerHTML="";
   document.getElementById("t5").disabled=false;
   document.getElementById("t8").disabled=false;
   document.getElementById("t6").disabled=false;
   document.getElementById("t9").disabled=false;
	  }
  

}
</script>
</head>
<body>
<form action="FirstPulpy" method="post">
<h1><center><font color="red">Welcome to M-Pulpy Sign-Up Process</font></center></h1>

<table align="center" height="600" width="400">
<tr><td><font color="blue">PROVIDER_NAME</font></td><td><input type="text" name="t1"></td></tr>
<tr><td><font color="blue">KEY_NAME</font></td><td><input type="text" name="t3"></td></tr>
<tr><td><font color="blue">API_KEY</font></td><td><input type="text" name="t4"></td></tr>
<tr><td><font color="blue">SEARCH_URL</font></td><td><input type="text" name="t2"></td></tr>
<tr><td><font color="blue">REQUEST TYPE</font></td><td><select name="select1"  id="select1" onchange="change()">
    <option value="GET">GET</option>
    <option value="POST">POST</option>
    <option value="XML REQUEST">XML REQUEST</option>
    <option value="SOAP REQUEST">SOAP REQUEST</option>
    <option value="USERNAME AND PWD">HTTPS USERNAME AND PWD</option>
</select></td></tr>
<tr><td align="center"><div id="container"></div></td></tr>
<tr><td><font color="blue">PARAM1</font></td><td><input type="text" name="t5" id="t5"></td></tr>
<tr><td><font color="blue">Test_Param1</font></td><td><input type="text" name="t8" id="t8"></td></tr>
<tr><td><font color="blue">PARAM2</font></td><td><input type="text" name="t6" id="t6"></td></tr>
<tr><td><font color="blue">Test_Param2</font></td><td><input type="text" name="t9" id="t9"></td></tr>

<tr><td><center><input type="submit" name="first" value="XML Response"></center></td>
<td><center><input type="submit" name="second" value="JSON Response"></center></td></tr>

</table>
</form>

</body>
</html>