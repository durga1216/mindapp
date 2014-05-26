<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mpulpy</title>
</head>
<script type="text/javascript">
function demo(){
var mysite = "http://sugarcubes.onsugar.com/";
	new Ajax.Request(mysite + "api/posts/create", {
	    method: 'post',
	    crossSite: true,
	    parameters: {
	        type: 'picture',
	        login: 'susee',
	        password: 'MindPulpy',
	        url: 'http://www.craigslist.org/about/best/sdo/566171148.3.jpg',
	        body: 'cat in a hat',
	        callback: 'json'
	    },
	    onSuccess: function(transport) {
	        eval(transport.responseText); //this gives us the onsugar_api object
	        console.log("The URL for your new post is " + mysite + onsugar_api["posts"][0].id);
	    }
	});
}
</script>
<body>
<form onsubmit="return demo()">
<input type="submit">
</form>
</body>
</html>