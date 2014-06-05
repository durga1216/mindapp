<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json</title>
	<script src="js/jquery-latest.js"></script>

</head>
<script type="text/javascript">
var intTextBox=0;
function addParam(){
	intTextBox = intTextBox + 1;
	  var contentID = document.getElementById('content');
	  var newTBDiv = document.createElement('div');
	      newTBDiv.setAttribute('id','strText'+intTextBox);
	  newTBDiv.innerHTML = "<input type='text' id='x" + intTextBox + "'    name='x" + intTextBox + "' placeholder='Tag_Label'/>" + "<input type='text' id='xv"+ intTextBox + " ' name='xv"+intTextBox+"' placeholder='Tag_Value'/>";
	  contentID.appendChild(newTBDiv);
}
function removeParam()
{
	var contentID = document.getElementById('content');
    contentID.removeChild(document.getElementById('strText'+intTextBox));
    intTextBox = intTextBox-1;
	}
</script>
<script>
$(document).ready(function(){

	 $('input[name=r1]').click(function(){
		    if($('input:radio[name=r1]:checked').val() == "Basic"){
				$('#Basic').show(); }
		    else{
				$('#Basic').hide(); }
		 
	 });
});
</script>
<body>
<form action="dummy1" method="post">
<center><input type=text name=t1 placeholder="end url"><br>
<a  href="javascript:addParam()">Add_Param</a>
<a href="javascript:removeParam()">Remove_param</a><br>
<br><center><div id="content"></div><br>

<input type="submit" name=s1 value=submit></center>
</form>
</body>
</html>