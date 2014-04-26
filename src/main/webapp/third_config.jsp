<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="js/jquery-latest.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#FF9900;}
#head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;
    margin-top:50px;}
input[type="text"]{
color:#FF9900;
font-size:20px;
background-color:#FFFFFF;
margin-left:480px;
font-family:verdana;
width:400px;
height:25px;
padding:10px;
} 
input[type="radio"]
 {
   width:20px; 
   height: 20px;
   color:#FFFFFF;
   font-size:20px;
   font-family:verdana;
   margin-left:60px;
 }
 #note{
 color:#FFFFFF;
font-size:10px;
font-family:verdana;
margin-left:100px;
 }
 #not{
 color:#FFFFFF;
font-size:10px;
font-family:verdana;
margin-left:100px;
 }
input[type="submit"]{

color:#FFFFFF;
font-size:20px;
background-color:#FF9900;
margin-left:620px;
font-family:verdana;
width:140px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:50px;
padding:10px;
}
a{font-family:verdana;
  font-size:20px;
  color:#FFFFFF;
  margin-left:400px;}
  .heading{font-family:verdana;
font-weight:bold;
font-size: 20px;
color:#FF9900;
width:25%;
height:30%;
background-color:#FFFFFF;
border-radius:50px;
padding:15px;}
label{
font-family:verdana;
font-size: 20px;
color:#FFFFFF;
}

</style>
<script type="text/javascript">
$(document).ready(function(){
	$('input[name=thirdcycle]').click(function(){
		    if($('input:radio[name=thirdcycle]:checked').val() == "flow"){
			$('#ent').hide();
		    $('#flo').show();
			    }
		    else if($('input:radio[name=thirdcycle]:checked').val() == "entity"){
		     $('#ent').show();
			$('#flo').hide();

		    }
});
});
var intTextBox=0;
function addParent()
{
	intTextBox = intTextBox + 1;
   var contentID = document.getElementById('content');
    var newTBDiv = document.createElement('div');
    newTBDiv.setAttribute('id','strText'+intTextBox);
    newTBDiv.innerHTML = "<input type='text' id='t" + intTextBox + "'    name='t" + intTextBox + "' placeholder='Param_Label'/>" + "<input type='text' id='tv"+ intTextBox + " ' name='tv"+intTextBox+"' placeholder='Param_Value'/>";
    contentID.appendChild(newTBDiv);
}

function removeParent(){
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
}
</script>
</head>
<body>
<div id="head"><center>Mind Pulpy<center></center></div><br><br>
<form action="ThirdConfig" method="post">
<center><div class='heading'>Third Step Configuration</div></center>
<br><br><input type="text" name="thrdurl" value="" placeholder="Third_End_Point_Url*"><br><br>
<CENTER>
<input type="radio" name="thirdcycle"  value="flow">
<label for="rd2">Flow Based</label>
<input type="radio" name="thirdcycle"   value="entity">
<label for="rd2">Entity Based</label>
</CENTER><br><br>

<div id="ent" style="display:none">
<input type="text" name="alabel" value="" placeholder="Key_Label"><br>
<input type="text" name="akey" value="" placeholder="Key_value"><br>
<center><div id='note'>Note:Re-enter API key or token again, or can also enter different key or token including No-Authentication,If avail</div></center>
</div>
</div>
<div id="flo" style="display:none">
<input type="text" name="thrd1" value="" placeholder="Flow_Id_Label"><br>
<input type="text" name="thrd2" value="" placeholder="Flow_Id_value"><br>
<center><div id='not'>Note:To complete whole cycle,connect with unique ID</div></div></center>

<a href="javascript:addParent();">Add Params</a>&nbsp;&nbsp;<a href="javascript:removeParent();">Remove Params</a><br><br>
<div id="content"></div><br><br>
<input type="submit" name="submit" value="Continue"></form>
</body>
</html>