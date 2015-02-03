<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

<script src="js/jquery-latest.js"></script>
<head>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-50928435-1', 'mindapp-pulpy.rhcloud.com');
	ga('send', 'pageview');
</script>
<style>
body {
	background-color: #FF9900;
}

.head {
	color: #FFFFFF;
	font-family: verdana;
	font-size: 40px;
}

.au {
	font-family: verdana;
	font-weight: bold;
	font-size: 20px;
	color: #FF9900;
	width: 25%;
	height: 30%;
	background-color: #FFFFFF;
	border-radius: 50px;
	padding: 15px;
}

input[type="text"] {
	color: #FF9900;
	font-size: 20px;
	background-color: #FFFFFF;
	font-family: verdana;
	width: 300px;
	height: 25px;
	padding: 10px;
}

a {
	font-size: 18px;
	font-family: verdana;
	color: #FFFFFF;
}

#indiv {
	color: #FFFFFF;
}

#na {
	margin-top: 0;
	width: 1300px;
	color: #FFFFFF;
	font-size: 20px;
	font-family: verdana;
	text-align: right;
}

img {
	height: 50px;
	width: 60px;
}

input[type="button"],input[type="submit"] {
	color: #FFFFFF;
	font-size: 18px;
	background-color: #00f;
	font-family: verdana;
	width: 300px;
	height: 45px;
	border: solid 2px;
	border-color: #00f;
	border-radius: 10px;
	padding: 10px;
}

input[type="password"] {
	color: #FF9900;
	font-size: 20px;
	background-color: #FFFFFF;
	font-family: verdana;
	width: 300px;
	height: 25px;
	padding: 10px;
}

#sec {
	width: 49%;
	height: 500px;
	background-color: #FF9900;
	float: left;
}

#imdv {
	width: 49%;
	height: 500px;
	background-color: #FF9900;
	float: left;
}

#ful {
	width: 1200px;
	height: 500px;
	background: #FF9900;
	margin-left: 80px;
	border: 0px solid #FFFFFF;
	float: left;
}

.result {
	color: #FFFFFF;
	font-family: verdana;
	font-size: 20px;
}
</style>
</head>
<script type="text/javascript">
	function add() {
		window.location = "index.jsp";
	}
	function load() {
		window.open("terms.jsp", '_blank');

	}
	function load1() {
		window.open("MindPulpy_FAQ.pdf", '_blank');
	}
	function load2() {
		window.open("https://mindtools-inputs.rhcloud.com/index.jsp", '_blank');
	}
</script>
<body>
	<form action="LoginCheckPulpy" method="post">
		<div id=na>
			<a href="http://minddotss.com/"><img
				style="height: 60px; width: 200px;" src="images/log.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				id="indiv" href='comments.jsp'>Discussion Forum</a>&nbsp;&nbsp;&nbsp;<a
				id="indiv" href='API_promotion.jsp'>API Promotion</a>&nbsp;&nbsp;&nbsp;<a
				id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;&nbsp;&nbsp;<a
				id="indiv" href='javascript:load2()'>Apps Builder</a>&nbsp;&nbsp;&nbsp;<a
				id="indiv" href='addapi.jsp'>Add API's</a>&nbsp;&nbsp;&nbsp;<a
				id="indiv"
				href='<%=request.getContextPath()%>Viewapi?category=Search'>Search
				API's</a>
		</div>
		<br>
		<hr>
		<br>
		<div class="head">
			<center>Mind Pulpy</center>
			</h2>
		</div>
		<dir id=full>
			<div id=imdv>
				<center>
					<img alt="logo" src="images/login-Page.PNG"
						style="height: 400px; width: 500px;">
				</center>
			</div>
			<div id="sec">
				<br>
				<center>
					<div class='au'>
						<center>Login Here</center>
					</div>
				</center>
				<center>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<div class="result">${alert}</div>
				</center>
				<br>
				<center>
					<input type=text name="t1" id='t1' placeholder="Email" required><br>
					<br> <input type=password name="t2" id='t2'
						placeholder="Password" required><br>
					<div class="result" style="margin-left: 180px;">
						<a href="fgtpass.jsp">Forgot Password?</a>
					</div>
					<br>
				</center>
				<center>
					<input type="submit" name="submit" id='Login' value="Login">
				</center>
				<br>
				<center>
					<div style="color: #fff; font-size: 15px; font-family: verdana;">
						If you haven't already <a style="color: #00f" href="index.jsp">Create
							a new Account</a>
					</div>
				</center>
				<br> <br>
				<center>
					&nbsp;&nbsp;<img alt="mobile" src="images/mobile.png">&nbsp;&nbsp;<img
						alt="tablet" src="images/tablet.png">&nbsp;&nbsp;<img
						alt="smart tv" src="images/TV.png">&nbsp;&nbsp;<img
						alt="smart watch" src="images/watch-2.png">&nbsp;&nbsp;<img
						alt="google glass" src="images/Glass-Icon.png">
				</center>
			</div>
		</dir>
	</form>
</body>
</html>