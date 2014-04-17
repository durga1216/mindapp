<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$('#submit').click(function(){
		alert('Hai');
$.ajax({
    type: "GET",
    url: "sam.xml",
    dataType: "xml",
    success: function (xml) {
alert('sucess');
        // Parse the xml file and get data
        document.write(xml);
        
    }
});
	});
});
</script>
</head>
<body>
<div id="news-container">XML</div>
<input type="submit" id='submit' name="submit" value="submit">
</body>
</html>